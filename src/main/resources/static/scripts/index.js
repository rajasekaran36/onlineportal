function signin(){
    var userId = document.getElementById("userid").value;
    fetch('http://localhost:8080/get/'+userId, {
        method: 'GET',
    })
    .then((response) => response.json())
    .then((result) => {
            window.location = "dashboard.html";
            console.log('Success:', result);
        })
    .catch((error) => {
        console.error('Error:', error);
        });
}