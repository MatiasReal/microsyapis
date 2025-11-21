window.addEventListener("DOMContentLoaded", populateForm);
document.getElementById("turnos-form").addEventListener("submit", handleCreacionTurno);
const pacientesList = document.getElementById("pacientes-list");
const odontologosList = document.getElementById("odontologos-list");

async function handleCreacionTurno(e) {
    e.preventDefault();

    const fechaSeleccionada = e.target["fecha-turno"].value;

    const datosTurno = {
        paciente: JSON.parse(e.target["pacientes-list"].value),
        odontologo: JSON.parse(e.target["odontologos-list"].value),
        fechaHora: fechaSeleccionada
    }

    try {
        const response = await fetch("/turnos", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(datosTurno),
        });

        if (response.ok) {
            alert("¡Turno creado exitosamente!");
            e.target.reset();
        } else {
            alert("Error al crear el turno.");
        }

    } catch (err) {
        console.error("Error en el fetch:", err);
        alert("Error de conexión al crear el turno.");
    }
}

async function populateForm() {
    await populateOdontologos();
    await populatePacientes();
}

async function populatePacientes() {
    try {
        const pacientsReqData = await fetch("/pacientes");
        if (!pacientsReqData.ok) throw new Error("Failed to fetch pacientes");
        const jsonData = await pacientsReqData.json();
        pacientesList.innerHTML = jsonData.map(p => (`
            <option value=${JSON.stringify(p)}>${p.apellido}, ${p.nombre} - ${p.cedula}
            </option>
        `)).join("\n");
    } catch(err) {
        console.error(err)
    }
}

async function populateOdontologos() {
    try {
        const odontologosReqData = await fetch("/odontologos");
        if (!odontologosReqData.ok) throw new Error("Failed to fetch odontologos");
        const jsonData = await odontologosReqData.json();
        if (jsonData.length) {
            odontologosList.innerHTML = jsonData.map(o => (`
                <option value=${JSON.stringify(o)}>${o.apellido}, ${o.nombre} - ${o.matricula}
                </option>
            `)).join("\n");
        }
    } catch(err) {
        console.error(err);
    }
}
