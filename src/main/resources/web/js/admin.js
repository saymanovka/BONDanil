let table = document.getElementById("statTable");

function createCustomTd() {
    let td = document.createElement("td");
    td.className = "items-center text-left text-sm font-semibold app-color-black pb-5";
    return td;
}

document.getElementById('date').innerText = new Date().toLocaleDateString("ua-UA")

function getLectureData(lectorId) {
    return fetch("http://localhost:8080/lectures/lector/" + lectorId.toString())
        .then(result => result.json());
}

function getHours(lectorId, tdhours, tdsum) {
    getLectureData(lectorId)
        .then(x => {
            let hours = x.length * 2;
            let salary = x.length === 0 ? 0 : x[0].lector.salary;
            tdsum.innerText = hours * salary;
            tdhours.innerText = hours;
        })
}

function tableFill(lectors) {
    let tbody = table.children[1];
    lectors.forEach(element => {
            let tr = document.createElement("tr");
            tr.className = "app-border-1 hover:bg-gray-100";
            for (field in element) {
                let tdhours = createCustomTd();
                let tdsum = createCustomTd();
                let tdsalary = createCustomTd();

                if (field === "salary") {
                    tr.appendChild(tdhours);
                    tr.appendChild(tdsalary);
                    tr.appendChild(tdsum);

                    tdsalary.innerText = element["salary"];

                    getHours(element.lectorId, tdhours, tdsum);
                } else {
                    let td = createCustomTd();
                    td.innerText = element[field];
                    // tdsum.innerText = hours * salary;
                    // tdhours.innerText = hours;

                    tr.appendChild(td);
                }
            }
            tbody.appendChild(tr);
        }
    );
}

fetch('http://localhost:8080/lectors').then(result => result.json()).then(result => tableFill(result))
