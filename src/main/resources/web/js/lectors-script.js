const lectorsSelect = document.getElementById('lectorNameId');

function addLectors(lectorsData){
    lectorsData.forEach(element => {
        const lectorId = element.lectorId;
        const lectorName = element.name;

        let option = document.createElement("option");
        option.value = lectorId;
        option.text = lectorName;

        lectorsSelect.add(option);
    });
}


fetch('http://localhost:8080/lectors').then(result => result.json()).then(result => addLectors(result));
lectorsSelect.onchange = () => {
    let lectorId = lectorsSelect.options[lectorsSelect.selectedIndex].value;
    location.href = `lector.html?lectorId=${lectorId}`
};
