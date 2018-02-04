var AMIVAL = 3.15;
var AISVAL = 2.65;
var DIVAL = 10.0;

var totalFacture = 0.0;

function afficherFacture(prenom, nom, actes)
{
    totalFacture = 0.0;
    var text = "<html>\n";
    text +=
            "    <head>\n\
            <title>Facture</title>\n\
            <link rel='stylesheet' type='text/css' href='/home/diallo/NetBeansProjects/CabinetInfirmierServer/src/java/fr/ujfGrenoble/miage/cabinetinfirmier/resources/infirmier.css'/>\n\
         </head>\n\
         <body>\n";


    text += "<h2>Facture pour :" + prenom + " " + nom + "<br/> </h2>\n";


    // Trouver l'adresse du patient
    var xmlDoc = loadXMLDoc("/home/diallo/NetBeansProjects/CabinetInfirmierServer/src/java/fr/ujfGrenoble/miage/cabinetinfirmier/resources/cabinet.xml");
    var patients = xmlDoc.getElementsByTagName("patient");
    var i = 0;
    var found = false;

    while ((i < patients.length) && (!found)) {
        var patient = patients[i];
        var localNom = patient.getElementsByTagName("nom")[0].childNodes[0].nodeValue;
        var localPrenom = patient.getElementsByTagName("prénom")[0].childNodes[0].nodeValue;
        if ((nom === localNom) && (prenom === localPrenom)) {
            found = true;
        } else {
            i++;
        }
    }


    if (found) {
        text += " <div class='infirmier'><div class='image'><div class='presfac'><strong>Adresse : </strong>";
        // On récupère l'adresse du patient
        var adresse;
        // adresse = ... à compléter par une expression DOM
        adresse = patient.getElementsByTagName("adresse")[0];
        text += adresseToText(adresse);
        text += "<br/>";

        var nSS = patient.getElementsByTagName("numéro")[0].childNodes[0].nodeValue;
        ;
        // nss = récupérer le numéro de sécurité sociale grâce à une expression DOM

        text += "<strong>Numéro de sécurité sociale : </strong>" + nSS + "</div></div>";
    }

    text += " <div class='imagecabinet'>";
    text += "<img src='/home/d/diallo/NetBeansProjects/CabinetInfirmierServer/src/java/fr/ujfGrenoble/miage/cabinetinfirmier/resources/image/infirmiere.jpg' alt='Smiley face'width='100' height='90'/></div></div><br/>";



    // Tableau récapitulatif des Actes et de leur tarif
    text += "<table border='1'  bgcolor='#CCCCCC'><thead>";
    text += "<tr>";
    text += "<th>Type</th> <th>Clé</th> <th>Intitulé</th> <th>Coef</th> <th>Tarif</th></tr>";
    text += "</thead>";

    //var acteIds = actes.split(" ");
    var acteIds = patient.getElementsByTagName("acte");
    for (var j = 0; j < acteIds.length; j++) {
        text += "<tr>";
        var acteId = acteIds[j].getAttribute("id");
        text += acteTable(acteId);
        text += "</tr>";
    }

    text += "<tbody><tr><th colspan='4'>Total</th><th>" + totalFacture + "</th></tr>\n";

    text += "</tbody></table>";


    text +=
            "    </body>\n\
    </html>\n";

    return text;
}

// Mise en forme d'un noeud adresse pour affichage en html
function adresseToText(adresse)
{
    var str = "";
    if (adresse.getElementsByTagName("étage")[0] !== undefined) {
        str += adresse.getElementsByTagName("étage")[0].childNodes[0].nodeValue + " ième Etage, ";
    }
    if (adresse.getElementsByTagName("numéro")[0] !== undefined) {
        str += adresse.getElementsByTagName("numéro")[0].childNodes[0].nodeValue + " ";
    }
    str += adresse.getElementsByTagName("rue")[0].childNodes[0].nodeValue + ", "
            + adresse.getElementsByTagName("codePostal")[0].childNodes[0].nodeValue + " "
            + adresse.getElementsByTagName("ville")[0].childNodes[0].nodeValue;
    return str;
}
function acteTable(acteId)
{
    var str = "";

    var xmlDoc = loadXMLDoc("/home/d/diallo/NetBeansProjects/CabinetInfirmierServer/src/java/fr/ujfGrenoble/miage/cabinetinfirmier/resources/actes.xml");
    var actes;
    var types;
    // actes = récupérer les actes de xmlDoc
    actes = xmlDoc.getElementsByTagName("acte");

    // Clé de l'acte (3 lettres)
    var cle = "";

    // Coef de l'acte (nombre)

    var coef = 0;

    // Type id pour pouvoir récupérer la chaîne de caractères du type 
    //  dans les sous-éléments de types
    var typeId = "";
    // Chaîne de caractère du type

    var type = "";
    // Intitulé de l'acte
    var intitule = "";


    // Tarif = (lettre-clé)xcoefficient (utiliser les constantes 
    // var AMIVAL = 3.15; var AISVAL = 2.65; et var DIVAL = 10.0;)
    var tarif = 0.0;



    // Trouver l'acte qui correspond
    var i = 0;
    var found = false;

// A dé-commenter dès que actes aura le bon type...
    while ((i < actes.length) && (!found)) {
        var acte = actes[i];
        var localacte = acte.getAttribute("id");
        if (acteId === localacte) {
            found = true;
        } else {
            i++;
        }
    }

    if (found) {
        // A compléter
        cle = acte.getAttribute("clé");
        coef = acte.getAttribute("coef");
        typeId = acte.getAttribute("type");
        type = loadtype(typeId);
        intitule = acte.childNodes[0].nodeValue;
        if (cle === "AMI")
            tarif = AMIVAL * coef;
        else if (cle === "AIS")
            tarif = AISVAL * coef;
        else
            tarif = DIVAL * coef;
    }

    // A modifier

    str += "<td>" + type + "</td>";
    str += "<td>" + cle + "</td>";
    str += "<td>" + intitule + "</td>";
    str += "<td>" + coef + "</td>";
    str += "<td>" + tarif + "</td>";

    totalFacture += tarif;

    return str;
}

function loadtype(typeId) {
    var xmlDoc = loadXMLDoc("/home/d/diallo/NetBeansProjects/CabinetInfirmierServer/src/java/fr/ujfGrenoble/miage/cabinetinfirmier/resources/actes.xml");
    var types;
    types = xmlDoc.getElementsByTagName("type");
    var j = 0;
    var type = "Moi";
    var foundtype = false;
    while ((j < types.length) && (!foundtype)) {
        var typeNode = types[j];
        var localType = typeNode.getAttribute("id");
        if (typeId === localType) {
            type = typeNode.childNodes[0].nodeValue;
            foundtype = true;
        } else {
            j++;
        }
        if (foundtype) {
            return type;
        }
    }
}

// Fonction qui charge un document XML
function loadXMLDoc(docName)
{
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else
    {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.open("GET", docName, false);
    try {
        xmlhttp.send();
    } catch (exception)
    {
        if (exception.name == 'NetworkError') {
            console.log('There was a network error.');
        }
    }

    xmlDoc = xmlhttp.responseXML;

    return xmlDoc;

}
