// DOM Elementen selecteren
const formBody = document.getElementById("form-body");
const alertSuccess = document.querySelector(".alert-success");
const tableSelect = document.querySelector(".table-container");
const buttonSubmit = document.querySelector(".btn-success");
const buttonDownload = document.querySelector(".btn-danger");
const medewerkerNaam = document.getElementById("medewerker-naam");
const medewerkerOpdrachtgever = document.getElementById("medewerker-opdrachtgever");
const huidigeMaand = document.getElementById("huidige-maand");
const huidigJaar = document.getElementById("huidig-jaar");

const maandNummerNaarString = (maandNummer) => {
    switch (maandNummer) {
        case 1:
            return "Januari";
        case 2:
            return "Februari";
        case 3:
            return "Maart";
        case 4:
            return "April";
        case 5:
            return "Mei";
        case 6:
            return "Juni";
        case 7:
            return "Juli";
        case 8:
            return "Augustus";
        case 9:
            return "September";
        case 10:
            return "Oktober";
        case 11:
            return "November";
        case 12:
            return "December";
    }
}

const vulMedewerkerVelden = (medewerker) => {
    medewerkerNaam.innerHTML = medewerker.naam;
    if (medewerker.type !== "InterneMedewerker") {
        medewerkerOpdrachtgever.innerHTML = medewerker.leidingGevende.bedrijf.naam;
    } else {
        medewerkerOpdrachtgever.innerHTML = "Qien";
    }
}

const vulMaandEnJaar = (formulier) => {
    huidigeMaand.innerHTML = maandNummerNaarString(formulier.maand);
    huidigJaar.innerHTML = formulier.jaar;
}

{/* <p>Naam: <span id="trainee-naam"></p>
    <p>Opdrachtgever: <span id="trainee=opdrachtgever"></span></p>
    <p>Maand: <span id="huidige-maand"></span></p>
    <p>Jaar: <span id="huidig-jaar"></span></p> */}

const verwijderFormulier = () => {
    formBody.innerHTML = "";
}

function formulierObjectMaken() {
    var xhr = new XMLHttpRequest();
    var x = document.getElementsByClassName("formulier-rij");
    var dagen = [];

    for (var i = 0; i < x.length; i++) {
        var dag = {};
        dag.opdrachtUren = document.getElementById(`opdracht-uren-${i}`).value;
        dag.overwerkUren = document.getElementById(`overwerk-uren-${i}`).value;
        dag.verlofUren = document.getElementById(`verlof-uren-${i}`).value;
        dag.ziekteUren = document.getElementById(`ziekte-uren-${i}`).value;
        dag.trainingUren = document.getElementById(`training-uren-${i}`).value;
        dag.overigeUren = document.getElementById(`overig-uren-${i}`).value;
        dag.overigeUrenUitleg = document.getElementById(`verklaring-overig-${i}`).value;
        dagen.push(dag);
    }

    var nieuwFormulier = {};
    nieuwFormulier.jaar = formulier.jaar;
    nieuwFormulier.maand = formulier.maand;
    nieuwFormulier.id = formulier.id;
    nieuwFormulier.werkDagen = dagen;

    console.log(JSON.stringify(nieuwFormulier));

    xhr.open("POST", "http://localhost:8082/api/formulier/nieuw", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(nieuwFormulier));

    tableSelect.style.display = "none";
    alertSuccess.style.display = "block";
    buttonSubmit.style.display = "none";
    buttonDownload.style.display = "none";
}

/* SAVE ONCHANGE */

// get klaargezet tijdelijk formulier

const haalFormulierOp = () => {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            const formulieren = JSON.parse(this.responseText);

            formulieren.forEach(e => {
                genereerFormulier(e);
                vulMaandEnJaar(e);
            })
        }
    }


    xhr.open("GET", `http://localhost:8082/api/trainee/tijdelijkeformulieren/1`, true);
    xhr.send();
}

const genereerFormulier = (formulier) => {
    console.log(formulier.werkDagen.length)
    console.log(formulier.id);
    for (let i = 0; i < formulier.werkDagen.length; i++) {
        formBody.insertAdjacentHTML("beforeend",
            `<tr id="dag-${i}" class="formulier-rij">
                <th scope="row">${i + 1}</th>
                <td><input type="number" class="form-input" id="opdracht-uren-${i}" value="${formulier.werkDagen[i].opdrachtUren}"></td>
                <td><input type="number" class="form-input" id="overwerk-uren-${i}" value="${formulier.werkDagen[i].overwerkUren}"></td>
                <td><input type="number" class="form-input" id="verlof-uren-${i}" value="${formulier.werkDagen[i].verlofUren}"></td>
                <td><input type="number" class="form-input" id="ziekte-uren-${i}" value="${formulier.werkDagen[i].ziekteUren}"></td>
                <td><input type="number" class="form-input" id="training-uren-${i}" value="${formulier.werkDagen[i].trainingsUren}"></td>
                <td><input type="number" class="form-input" id="overig-uren-${i}" value="${formulier.werkDagen[i].overigeUren}"></td>
                <td class="form-verklaring"><input type="text" class="form-input" id="verklaring-overig-${i}" value="${(formulier.werkDagen[i].overigeUrenUitleg === null) ? "" : formulier.werkDagen[i].overigeUrenUitleg}"></td>
            </tr>`)
    }

    const formInputs = document.querySelectorAll(".form-input");

    // Functionaliteit voor het opslaan van formulier
    formInputs.forEach(e => {
        e.addEventListener("change", () => {
            console.log("something changed")
            var xhr = new XMLHttpRequest();

            var x = document.getElementsByClassName("formulier-rij");
            var dagen = [];

            for (var i = 0; i < x.length; i++) {
                var dag = {};
                // let j = i + 2;
                // let datum = new Date(selectJaar.value, selectMaand.value, j);
                dag.datum = i + 1;
                dag.opdrachtUren = document.getElementById(`opdracht-uren-${i}`).value;
                dag.overwerkUren = document.getElementById(`overwerk-uren-${i}`).value;
                dag.verlofUren = document.getElementById(`verlof-uren-${i}`).value;
                dag.ziekteUren = document.getElementById(`ziekte-uren-${i}`).value;
                dag.trainingsUren = document.getElementById(`training-uren-${i}`).value;
                dag.overigeUren = document.getElementById(`overig-uren-${i}`).value;
                dag.overigeUrenUitleg = document.getElementById(`verklaring-overig-${i}`).value;
                dagen.push(dag);
            }

            var nieuwFormulier = {};
            nieuwFormulier.jaar = formulier.jaar;
            nieuwFormulier.maand = formulier.maand;
            nieuwFormulier.id = formulier.id;
            nieuwFormulier.werkDagen = dagen;

            console.log(JSON.stringify(nieuwFormulier));

            xhr.open("PUT", `http://localhost:8082/api/trainee/tijdelijkformulier/update/1122`, true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(JSON.stringify(nieuwFormulier));

        })
    })

    buttonSubmit.addEventListener("click", () => {
        formulierObjectMaken();
    });

}

haalFormulierOp();

// afgelopenFormulieren.onclick = function (event) {
//     var target = getEventTarget(event);
//     let id = target.id;
//     let hetFormulier;
//     var xhr = new XMLHttpRequest();
//     xhr.onreadystatechange = function () {
//         if (xhr.readyState == 4) {
//             hetFormulier = JSON.parse(this.responseText);
//             verwijderFormulier();
//             genereerFormulier(hetFormulier);
//         }
//     }

//     xhr.open("GET", `http://localhost:8082/api/formulier/${id}`, true);
//     xhr.send();

// };

