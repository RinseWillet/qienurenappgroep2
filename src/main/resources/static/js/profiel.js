const profieltraineeNaam = document.getElementById("profieltrainee-naam");
const profieltraineeEmail = document.getElementById("profieltrainee-email");
const profieltraineeStartdatum = document.getElementById("profieltrainee-startdatum");
const profieltraineeRol = document.getElementById("profieltrainee-rol");
const profieltraineeTelnr = document.getElementById("profieltrainee-telnr");
const profieltraineeAdres = document.getElementById("profieltrainee-adres");
const profieltraineePostcode = document.getElementById("profieltrainee-postcode");
const profieltraineeWoonplaats = document.getElementById("profieltrainee-woonplaats");
const profieltraineeKCP = document.getElementById("profieltrainee-kcp");
const profieltraineeBedrijf = document.getElementById("profieltrainee-bedrijf");
const profieltraineeKCPtelnr = document.getElementById("profieltrainee-kcptelnr");
// window.onload = () => {
//     traineeNaamFunction();
//     console.log("onload");
// };
const traineeNaamFunction = () => {
    var urlString = window.location.href;
    var url = new URL(urlString);
    var urlId = url.searchParams.get("id");

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            trainee = JSON.parse(this.responseText);
            let welkomHtml = ``;
            console.log(trainee.leidingGevende);
            profieltraineeNaam.innerHTML = `${trainee.naam}`;
            profieltraineeEmail.innerHTML = `${trainee.email}`;
            profieltraineeStartdatum.innerHTML = `${trainee.startDatum}`;
            profieltraineeRol.innerHTML = `${trainee.roles}`;
            profieltraineeTelnr.innerHTML = `${trainee.telefoonnr}`;
            profieltraineeAdres.innerHTML = `${trainee.straatNaamNr}`;
            profieltraineePostcode.innerHTML = `${trainee.postcode}`;
            profieltraineeWoonplaats.innerHTML = `${trainee.woonplaats}`;
            profieltraineeKCP.innerHTML = `${trainee.leidingGevende.naam}`;
            profieltraineeBedrijf.innerHTML = `${trainee.leidingGevende.company.naam}`;
            profieltraineeKCPtelnr.innerHTML = `${trainee.leidingGevende.telefoonnr}`;
        }
    }
    xhr.open("GET", `http://localhost:8082/api/trainee/${urlId}` , true);
    xhr.send();
}

traineeNaamFunction();