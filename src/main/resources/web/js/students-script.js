const groupsSelect = document.getElementById('groupId');
const studentsSelect = document.getElementById('nameId');
const facultiesSelect = document.getElementById('facultyId');

studentsSelect.onchange = () => {
    let selectedItem = studentsSelect.options[studentsSelect.selectedIndex];
    let groupId = selectedItem.getAttribute('groupId');
    location.href = `student.html?groupId=${groupId}&studentId=${selectedItem.value}`
};

function addGroups(groupsData){
    groupsData.forEach(element => {
        const groupId = element.groupId;
        const groupName = element.name;

        let option = document.createElement("option");
        option.value = groupId;
        option.text = groupName;

        groupsSelect.add(option);
    });

}

function addStudents(studentsData){
    studentsData.forEach(element => {
        const studentName = element.name;

        let option = document.createElement("option");
        option.value = element.studentId;
        option.setAttribute('groupId', element.group.groupId)
        option.text = studentName;

        studentsSelect.add(option);
    });

}

function addFaculties(facultiesData){
    facultiesData.forEach(element =>{
        const facultyId = element.facultyId;
        const facultyName = element.name;

        let option = document.createElement("option");
        option.value = facultyId;
        option.text = facultyName;

        facultiesSelect.add(option);
    })
}

fetch('http://localhost:8080/faculties').then(result => result.json()).then(result => addFaculties(result));
fetch('http://localhost:8080/groups').then(result => result.json()).then(result => addGroups(result));
fetch('http://localhost:8080/students').then(result => result.json()).then(result => addStudents(result));
