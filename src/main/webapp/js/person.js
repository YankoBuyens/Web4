window.onload = getNewPersons;



let getPersonsRequest = new XMLHttpRequest();


let personDiv = document.getElementById("tabel");


function getNewPersons () {
    getPersonsRequest.open("GET", "Controller", true);

    getPersonsRequest.onreadystatechange = showPersons;
    getPersonsRequest.send(null);
}
function showPersons () {
    if (getPersonsRequest.readyState == 4) {
        if (getPersonsRequest.status == 200) {
            console.log("Hilp")

            let jsonpersons = JSON.parse(getPersonsRequest.responseText)


            for (let person in jsonpersons){
                let newRow = personDiv.insertRow(); //Voegt een tr toe aan de tabel
                let newCell = newRow.insertCell();

                let firstName = document.createTextNode(person.firstName);   //Maakt nieuwe tekst
                newCell.appendChild(firstName);

            }
            setInterval(getNewPersons,5000);
        }
    }
}