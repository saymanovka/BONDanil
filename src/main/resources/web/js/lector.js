const urlParams = new URLSearchParams(window.location.search);

fetch(`http://localhost:8080/lectures/lector/${urlParams.get('lectorId')}`)
    .then(res => res.json())
    .then(x => scheduleFill(x));

fetch(`http://localhost:8080/lector/${urlParams.get('lectorId')}`)
    .then(res => res.json())
    .then(x => {
        document.getElementById('lectorName').innerText = x.name;
        document.getElementById('lectorPhone').innerText = x.phone;
    });

document.getElementById('date').innerText = new Date().toLocaleDateString("ua-UA");

let daysofWeek = {
    "понедельник" : 2,
    "вторник" : 3,
    "среда" : 4,
    "четверг" : 5,
    "пятница" : 6,
    "субота" : 7
}
let timeofLectures = {
    "8:30:00" : 0,
    "10:15:00" : 1,
    "12:10:00" : 2,
    "13:55:00" : 3,
}

function scheduleFill (lectures){
    let table = document.getElementById("scheduleId");
    let tbody = table.childNodes[3];
    lectures.forEach(element =>{
        var daynumber = daysofWeek[`${new Date(element.time).toLocaleDateString("ua-UA", { weekday: 'long' })}`];
        var lecturenumber = timeofLectures[`${new Date(element.time).getHours()}:${new Date(element.time).getMinutes()}:00`];
        console.log(element.subject.name);
        for(let i = 0; i<tbody.children.length; i++){
            if(lecturenumber == i){
                let row = tbody.children[i].children;
                //console.log(row)
                for(let j = 2; j < row.length; j++){
                    if(daynumber == j){
                        let divwrapper = document.createElement("div");
                        divwrapper.className = "flex flex-col rounded-md p-2";
                        let lecturename = document.createElement("span");
                        lecturename.className = "font-semibold text-xs app-color-black";
                        lecturename.innerText = element.subject.name;
                        let lectureType = element.lectureType === 'PRACTICE' ? 'Практичне заняття' : 'Лекція';
                        let groupname = document.createElement("span");
                        groupname.className = "text-semibold text-xs app-color-gray-1";
                        groupname.innerText = `${element.group.name} - ${lectureType}`;
                        let lectorname = document.createElement("span");
                        lectorname.className = "text-semibold text-xs app-color-black";
                        lectorname.innerText = element.lector.name;
                        divwrapper.appendChild(lecturename);
                        divwrapper.appendChild(groupname);
                        divwrapper.appendChild(lectorname)
                        row[j].appendChild(divwrapper);

                    }
                    
                }
            }
        }
    }
    ); 
}