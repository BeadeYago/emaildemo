let createForm = document.getElementById('createForm');
let errorDis = document.getElementById('error')


let addPerson = () => {

    let createName = document.getElementById('createName').value;
    let createLastName = document.getElementById('createLastName').value;
    let createEmail = document.getElementById('createEmail').value;
    let createGender = document.querySelector('input[name="gender"]:checked').value;
    let createArea = document.getElementById('createArea').value;

    if (createName == "") {
        Swal.fire({
            icon: 'error',
            title: 'El nombre no puede quedar vacio.',
        })
    } else if (createLastName == "") {
        Swal.fire({
            icon: 'error',
            title: 'El apellido no puede quedar vacio.',
        })
    } else if (createEmail == "") {
        Swal.fire({
            icon: 'error',
            title: 'El email no puede quedar vacio.',
        })
    } else if (createArea == "") {
        Swal.fire({
            icon: 'error',
            title: 'Seleccione una materia.',
        })
    } else {
        fetch("http://localhost:8080/api/persons", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: createName,
                lastName: createLastName,
                email: createEmail,
                gender: createGender,
                area: createArea
            })
        }).then((response) => {
            if(response.status >= 200 && response.status <= 299){
                Swal.fire({
                    icon: 'success',
                    title: 'Su peticion ha sido aceptada, pronto le llegara un correo electronico.',
                })
                return response.json();
            } else {
                throw Error(response.statusText);
            }
        })
        .catch(() => {
            Swal.fire({
                icon: 'error',
                title: 'El correo ya esta asignado a esta materia.',
            })
        })
    }
};


createForm.addEventListener('submit', function (e) {
    e.preventDefault();
    addPerson();
});