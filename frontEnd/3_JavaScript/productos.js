let urlServicioWebProductos = "http://localhost:8081/api/producto";
let contenido_productos = document.querySelector("#listado_productos");

function listar_productos() {
    console.log("listar_productos");
    let data = [];
    let resultado = function (response) {
        let items = [];
        $.each(response, function(index, producto) {
            items.push("<tr><td>" + producto.id + "</td><td>" + producto.nombre + "</td><td>" + producto.cantidad + "</td><td>" + producto.descripcion + "</td><td>" + producto.marca + "</td><td>" + producto.modelo + "</td><td>" + producto.precio + "</td><td>" + producto.ubicacion + "</td><td>" + producto.stock + "</td><td><a class='btn btn-success' href='editar.html?id=" + producto.id + "'>Editar</a></td><td><a class='btn btn-danger' href='eliminar.html?id=" + producto.id + "'>Eliminar</a></td></tr>");
        });
        
        contenido_productos.innerHTML = "<table class='table table-striped table-bordered w-100'><thead><tr><th>ID</th><th>Nombre</th><th>Cantidad</th><th>Descripción</th><th>Marca</th><th>Modelo</th><th>Precio</th><th>Ubicación</th><th>Stock</th><th colspan='2'>Opciones</th></tr></thead><tbody>" + items.join("") + "</tbody></table>";
    };

    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: urlServicioWebProductos,
        context: data,
        data: data,
        dataType: "json",
        success: resultado
    });
}
