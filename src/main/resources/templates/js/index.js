const maanden = ["Januari", "Februari", "Maart", "April", "Mei", "Juni", "Juli", "Augustus", "September", "Oktober", "November", "December"];

let startJaar = new Date().getFullYear();
let eindJaar = 2024;
let huidigeDatum = new Date();
let huidigJaar = huidigeDatum.getFullYear();
let huidigMaand = huidigeDatum.getMonth();

// DOM Elementen selecteren
const selectMaand = document.getElementById("maanden-select");
const selectJaar = document.getElementById("jaren-select");
const geselecteerdeMaand = selectMaand.value;
const geselecteerdJaar = selectJaar.value;
const formBody = document.getElementById("form-body");
const alertSuccess = document.querySelector(".alert-success");
const tableSelect = document.querySelector(".table-container");
const buttonSubmit = document.querySelector(".btn-success");
const buttonDownload = document.querySelector(".btn-danger");


// Functies om de maanden en jaren te vullen
const laadMaanden = () => {
    // maanden.forEach(e =>
    //     selectMaand.insertAdjacentHTML("beforeend", `<option value="${e}">${e}</option>`));

    for (let i = 0; i < maanden.length; i++) {
        if(i == huidigMaand) {
            selectMaand.insertAdjacentHTML("beforeend", `<option value="${i}" selected="${huidigMaand}">${maanden[i]}</option>`);
        }
        else {
            selectMaand.insertAdjacentHTML("beforeend", `<option value="${i}">${maanden[i]}</option>`);
            }
    }
}

const laadJaren = () => {
    for (let i = startJaar; i < eindJaar; i++) {
        if(i == huidigJaar) {
            selectJaar.insertAdjacentHTML("beforeend", `<option value="${i}" selected="${huidigJaar}" >${i}</option>`);
        }
        else {
        selectJaar.insertAdjacentHTML("beforeend", `<option value="${i}">${i}</option>`);
        } 
    }
}

// Functie om dagen in een maand te tellen
const dagenInMaand = (jaar, maand) => {
    // tel 1 bij maand op omdat DATE niet 0-based is
    maand = parseInt(maand) + 1;
    return new Date(jaar, maand, 0).getDate();
}

window.onload = () => {
    laadMaanden();
    laadJaren();
    veranderMaandJaar();
};

// Event listeners voor het wijzigen van maand en/of jaar
// bij onchange van 1 van de selects (maand en jaar) verander dan beiden
const veranderMaandJaar = () => {
    let gekozenJaar = selectJaar.options[selectJaar.selectedIndex].value;
    let gekozenMaand = selectMaand.options[selectMaand.selectedIndex].value;
    let dagen = dagenInMaand(gekozenJaar, gekozenMaand);
    console.log(gekozenMaand + " " + gekozenJaar);
    console.log("Aantal dagen in gekozen maand: " + dagen);
    verwijderFormulier();
    genereerFormulier(dagen);
    if(tableSelect.style.display = "none"){
        tableSelect.style.display = "block";
        alertSuccess.style.display = "none";
        buttonSubmit.style.display = "inline-block";
        buttonDownload.style.display = "inline-block";
    }
}

selectJaar.onchange = veranderMaandJaar;
selectMaand.onchange = veranderMaandJaar;

// Aan de hand van het door de gebruiker geselecteerde jaar en de maand, moet het juiste formulier(met juiste data) gegenereerd worden
// Nog functie schrijven die aan de hand van gekozen maand en jaar juiste aantal rijen in formulier genereerd
// Default moet het formulier van de huidige maand worden getoond

// Functie om formulier te vullen
const genereerFormulier = (dagen) => {
    for (let i = 0; i < dagen; i++) {
        formBody.insertAdjacentHTML("beforeend", 
        `<tr id="dag-${i+1}" class="formulier-rij">
            <th scope="row">${i + 1}</th>
            <td><input type="number" class="form-input" id="opdracht-uren-${i + 1}"></td>
            <td><input type="number" class="form-input" id="overwerk-uren-${i + 1}"></td>
            <td><input type="number" class="form-input" id="verlof-uren-${i + 1}"></td>
            <td><input type="number" class="form-input" id="ziekte-uren-${i + 1}"></td>
            <td><input type="number" class="form-input" id="training-uren-${i + 1}"></td>
            <td><input type="number" class="form-input" id="overig-uren-${i + 1}"></td>
            <td class="form-verklaring"><input type="text" class="form-input" id="verklaring-overig-${i + 1}"></td>
        </tr>`)
    }

    const formInputs = document.querySelectorAll(".form-input");

    // Functionaliteit voor het opslaan van formulier
    formInputs.forEach(e => {
        e.addEventListener("change", () => {
            alert("something changed")
        })
    })
    console.log(formInputs);

    buttonSubmit.addEventListener("click", () => {
        formulierObjectMaken();
    });

}

const verwijderFormulier = () => {
    formBody.innerHTML = "";
}

function formulierObjectMaken(){
    var xhr = new XMLHttpRequest();
    var x = document.getElementsByClassName("formulier-rij");
    var dagen = [];

    for (var i = 0; i < x.length; i++) {
        var dag = {};
        let j = i + 2;
        let datum = new Date(selectJaar.value, selectMaand.value, j);
        dag.datum = datum;
        dag.opdrachtUren = document.getElementById(`opdracht-uren-${i + 1}`).value;
        dag.overwerkUren = document.getElementById(`overwerk-uren-${i + 1}`).value;
        dag.verlofUren = document.getElementById(`verlof-uren-${i + 1}`).value;
        dag.ziekteUren = document.getElementById(`ziekte-uren-${i + 1}`).value;
        dag.trainingUren = document.getElementById(`training-uren-${i + 1}`).value;
        dag.overigeUren = document.getElementById(`overig-uren-${i + 1}`).value;
        dag.overigeUrenUitleg = document.getElementById(`verklaring-overig-${i + 1}`).value;
        dagen.push(dag);
    }

    var formulier = {};
    formulier.jaar = selectJaar.value;
    formulier.maand = selectMaand.value;
    formulier.werkDagen = dagen;

    console.log(JSON.stringify(formulier));

    xhr.open("POST", "http://localhost:8082/api/formulier/nieuw", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(formulier));

    tableSelect.style.display = "none";
    alertSuccess.style.display = "block";
    buttonSubmit.style.display = "none";
    buttonDownload.style.display = "none";
}

/* SAVE ONCHANGE */

