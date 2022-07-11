function loadContacts() {
    console.log("AQUI")
    var xmlHttp = new XMLHttpRequest();
    console.log(xmlHttp);
    xmlHttp.open( "GET", '/contacts/username', false ); // false for synchronous request
    xmlHttp.send( null );
    var rsp = xmlHttp.responseText.toString();
    document.getElementById("contact-list").value = rsp;
}
