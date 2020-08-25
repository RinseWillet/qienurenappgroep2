const traineeNaam = document.getElementById("trainee-naam");
const afgelopenFormulieren = document.getElementById("afgelopen-formulieren");
const formBody = document.getElementById("form-body");
const modalHeader = document.querySelector(".modal-title");
const klikbaarOogje = document.querySelector(".fa-eye");
const formulierItem = document.querySelector(".list-group-item");
const navlink = document.querySelector(".nav-link");
const profielpagina = document.getElementById("profielpagina");



//haalt id uit huidige url
var url_string = window.location.href; 
var url = new URL(url_string); 
var idpf = url.searchParams.get("id"); 

//voegt ID toe aan profielpaginaurl
function aanpassenurl(){
    let pfurl = document.getElementById('profielpaginaurl').href;
    pfurl = pfurl + "?id=" + idpf;
    var a = document.querySelector('a[href="/profielpagina"]'); if (a) {   a.setAttribute('href', pfurl) }

    let urenURL = document.getElementById('urenformurl').href;
    urenURL = urenURL + "?id=" + idpf;
    var b = document.querySelector('a[href="/traineeformulier"]'); if (b) {   b.setAttribute('href', urenURL) }
}



const maandNummerNaarString = (maandNummer) => {
    switch (maandNummer) {
        case 0:
            return "Januari";
        case 1:
            return "Februari";
        case 2:
            return "Maart";
        case 3:
            return "April";
        case 4:
            return "Mei";
        case 5:
            return "Juni";
        case 6:
            return "Juli";
        case 7:
            return "Augustus";
        case 8:
            return "September";
        case 9:
            return "Oktober";
        case 10:
            return "November";
        case 11:
            return "December";
    }
}



window.onload = () => {
    traineeNaamFunction();
    aanpassenurl();
};

const traineeNaamFunction = () => {
    var urlString = window.location.href;
    var url = new URL(urlString);
    var urlId = url.searchParams.get("id");

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            trainee = JSON.parse(this.responseText);

            let archiefFormulierHTML = ``;
            let huidigMaandFormulier = ``;

            traineeNaam.innerHTML = `Welkom, ${trainee.naam}!`;
            // traineeOpdrachtgever.innerHTML = `Opdrachtgever : ${trainee.leidingGevende}`;

            var formulieren = trainee.archief;
            var huidigFormulier = trainee.tijdelijkeFormulieren;

            formulieren.sort(function (a, b) {
                return a.id - b.id
            });
            formulieren.reverse();

            for (let i = 0; i < formulieren.length; i++) {
                maand = maandNummerNaarString(formulieren[i].maand);
                var e = formulieren[i];

                for (let i = 0; i < 3; i++) {
                    maand = maandNummerNaarString(formulieren[i].maand);
                    var e = formulieren[i];


                    // inTeVoegenHTML = `<li data-toggle="modal" data-target="#staticBackdrop" href="./formulier.html?id=${e.id}" 
                    // class="list-group-item list-group-item-action" id="${e.id}">${e.naam} | ${e.maand} | ${e.jaar} | ${e.formulierstatus}</li>`;

                    formulierHTML = `<li data-toggle="modal" data-target="#staticBackdrop" 
                     class="list-group-item list-group-item-action d-flex justify-content-between" id="${e.id}"><span id="${e.id}">${maand}</span><span id="${e.id}">${e.jaar}</span><span id="${e.id}">${e.adminStatus}</span><i id="${e.id}" class="far fa-eye"></i></li>`;

                    afgelopenFormulieren.insertAdjacentHTML('beforeend', archiefFormulierHTML);

                }


                for (let x = 0; x < huidigFormulier.length; x++) {
                    maand = maandNummerNaarString(huidigFormulier[x].maand);
                    var e = huidigFormulier[x];

                    huidigMaandFormulier = `<li data-toggle="modal" data-target="#staticBackdrop" 
                class="list-group-item list-group-item-action d-flex justify-content-between" id="${e.id}"><span id="${e.id}">${maand}</span><span id="${e.id}">${e.jaar}</span><span id="${e.id}">${e.adminStatus}</span><i id="${e.id}" class="far fa-eye"></i></li>`;
                    tijdelijkeFormulieren.insertAdjacentHTML('beforeend', huidigMaandFormulier);
                }

            }

        }
        xhr.open("GET", `http://localhost:8082/api/trainee/${urlId}`, true);
        xhr.send();
    }

}


const genereerFormulier = (formulier) => {
    formulier.maand = maandNummerNaarString(formulier.maand);
    modalHeader.innerHTML = `${trainee.naam} | ${formulier.maand}/${formulier.jaar}`
    for (let i = 0; i < formulier.werkDagen.length; i++) {
        formBody.insertAdjacentHTML("beforeend",
            `<tr id="dag-${i + 1}" class="formulier-rij">
            <th scope="row">${i + 1}</th>
            <td class="admin-opmaak" id="opdracht-uren-${i + 1}">${formulier.werkDagen[i].opdrachtUren}</td>
            <td class="admin-opmaak"id="overwerk-uren-${i + 1}">${formulier.werkDagen[i].overwerkUren}</td>
            <td class="admin-opmaak"id="verlof-uren-${i + 1}">${formulier.werkDagen[i].verlofUren}</td>
            <td class="admin-opmaak" id="ziekte-uren-${i + 1}">${formulier.werkDagen[i].ziekteUren}</td>
            <td class="admin-opmaak"id="training-uren-${i + 1}">${formulier.werkDagen[i].trainingsUren}</td>
            <td class="admin-opmaak"id="overig-uren-${i + 1}">${formulier.werkDagen[i].overigeUren}</td>
            <td class="admin-opmaak form-verklaring"><class="form-input" id="verklaring-overig-${i + 1}">${formulier.werkDagen[i].overigeUrenUitleg}</td>
        </tr>`)
    }
}

const verwijderFormulier = () => {
    formBody.innerHTML = "";
}

function getEventTarget(e) {
    e = e || window.event;
    return e.target || e.srcElement;
}

afgelopenFormulieren.onclick = function (event) {
    var target = getEventTarget(event);
    let id = target.id;
    let hetFormulier;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            hetFormulier = JSON.parse(this.responseText);
            verwijderFormulier();
            genereerFormulier(hetFormulier);
        }
    }

    xhr.open("GET", `http://localhost:8082/api/formulier/${id}`, true);
    xhr.send();

};


