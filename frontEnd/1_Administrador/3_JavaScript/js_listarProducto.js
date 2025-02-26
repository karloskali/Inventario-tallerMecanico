const API_URL = "http://localhost:8081/api/producto"; // Cambia según tu API

function cargarDatos() {
    fetch(API_URL)
        .then(response => response.json()) // Convertir respuesta a JSON
        .then(data => {
            let lista = document.getElementById("lista");
            lista.innerHTML = ""; // Limpiar lista antes de agregar nuevos datos

            data.forEach(producto => {
                let item = document.createElement("li");
                item.textContent = `${producto.nombre} - $${producto.precio}`;
                lista.appendChild(item);
            });
        })
        .catch(error => console.error("Error al obtener datos:", error));
}
