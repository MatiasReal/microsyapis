window.addEventListener("DOMContentLoaded", populateForm)

const pacientesList = document.getElementById("pacientes-list")

async function populateForm() {
    try {
        const pacientsReqData = await fetch("/pacientes");
        if (!pacientsReqData.ok) throw new Error("Failed to fetch pacientes");
        const jsonData = await pacientsReqData.json();
        pacientesList.innerHTML = jsonData.map(p => (`
            <option value=${p.id}>${p.apellido}, ${p.nombre} - ${p.cedula}
            </option>
        `)).join("\n");
    } catch(err) {
        console.error(err)
    }
}