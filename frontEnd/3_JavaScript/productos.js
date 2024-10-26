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
        
        contenido_productos.innerHTML = "<div class='table-container'><table class='table table-striped table-bordered'><thead><tr><th>ID</th><th>Nombre</th><th>Cantidad</th><th>Descripción</th><th>Marca</th><th>Modelo</th><th>Precio</th><th>Ubicación</th><th>Stock</th><th colspan='2'>Opciones</th></tr></thead><tbody>" + items.join("") + "</tbody></table></div>";
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




function nuevo_producto() {
    console.log("Llamado a nuevo producto");

    // Validación de campos obligatorios
    if (!validarCampos("#formNuevo")) {
        alert("Por favor, completa todos los campos obligatorios.");
        return; // Detener la ejecución si hay campos vacíos
    }

    // Convertir el formulario a JSON
    var data = convertirFormDataAJSON($("#formNuevo"));
    var resultado = function(response) {
        alert("El producto fue registrado exitosamente");
        window.location.href = "productoListar.html";
    };

    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: urlServicioWebProductos,  // Definir esta URL en tu proyecto
        data: data,
        dataType: "json",
        success: resultado
    });
}

// Función para validar campos obligatorios
function validarCampos(formSelector) {
    let isValid = true;
    $(formSelector + " [required]").each(function() {
        if (!$(this).val()) {
            isValid = false;
            $(this).addClass("is-invalid"); // Añadir clase para estilo si es necesario
        } else {
            $(this).removeClass("is-invalid"); // Quitar clase si el campo es válido
        }
    });
    return isValid;
}


// Función para obtener un producto por su ID y cargar sus datos en el formulario de edición
function obtener_producto(id) {
    console.log("Llamado obtener producto");
    var url2 = urlServicioWebProductos + "/" + id;

    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: url2,
        dataType: "json",
        success: function(response) {
            console.log(response);
            $("#formEditar #id").val(response.id);
            $("#formEditar #nombre").val(response.nombre);
            $("#formEditar #cantidad").val(response.cantidad);
            $("#formEditar #descripcion").val(response.descripcion);
            $("#formEditar #marca").val(response.marca);
            $("#formEditar #modelo").val(response.modelo);
            $("#formEditar #precio").val(response.precio);
            $("#formEditar #ubicacion").val(response.ubicacion);
            $("#formEditar #stock").val(response.stock);
        }
    });
}

// Función para actualizar un producto existente
function actualizar_producto() {
    console.log("Llamado a actualizar producto");
    var data = convertirFormDataAJSON($("#formEditar"));
    var resultado = function(response) {
        alert("El producto fue actualizado");
        window.location.href = "productoListar.html";
    };

    $.ajax({
        type: "PUT",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: urlServicioWebProductos,
        data: data,
        dataType: "json",
        success: resultado
    });
}

// Función para confirmar y mostrar datos antes de eliminar un producto
function pre_eliminar_producto(id) {
    console.log("Llamado pre eliminar producto");
    var url2 = urlServicioWebProductos + "/" + id;

    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: url2,
        dataType: "json",
        success: function(response) {
            console.log(response);
            $("#formEliminar #id").val(response.id);
            $("#formEliminar #producto_eliminar").html("<strong>Eliminar!</strong> ¿Está seguro de eliminar el producto: <b>" + response.nombre + "</b>?");
        }
    });
}

// Función para eliminar un producto
function eliminar_producto() {
    console.log("Llamado a eliminar producto");
    var id = $("#formEliminar #id").val();
    var url2 = urlServicioWebProductos + "/" + id;

    $.ajax({
        type: "DELETE",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: url2,
        dataType: "json",
        success: function(response) {
            alert("El producto fue eliminado");
            window.location.href = "productoListar.html";
        }
    });
}

// Función para buscar productos y mostrar una lista con los resultados
function buscar_productos() {
    console.log("Ejecutar Buscar Productos");
    var data = convertirFormDataAJSON($("#formBuscar"));

    $.ajax({
        type: "PATCH",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: urlServicioWebProductos,
        data: data,
        dataType: "json",
        success: function(response) {
            var items = [];
            $.each(response, function(index, producto) {
                items.push("<tr><td>" + producto.id + "</td><td>" + producto.nombre + "</td><td>" + producto.precio + "</td><td>" + producto.cantidad + "</td><td>" + producto.ubicacion + "</td><td>" + producto.stock + "</td><td><a class='btn btn-success' href='actualizar.html?id=" + producto.id + "'>Editar</a> <a class='btn btn-danger' href='eliminar.html?id=" + producto.id + "'>Eliminar</a></td></tr>");
            });
            $("#listar_productos").html("<table class='table table-hover'><thead><tr><th>ID</th><th>Nombre</th><th>Precio</th><th>Cantidad</th><th>Ubicación</th><th>Stock</th><th>Opciones</th></tr></thead><tbody>" + items.join("") + "</tbody></table>");
        }
    });
}

// Función para extraer variables de la URL
function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return false;
}

// Función para convertir los datos de un formulario a JSON
function convertirFormDataAJSON(formData) {
    var formArray = formData.serializeArray();
    var formObject = {};
    $.each(formArray, function(i, v) {
        formObject[v.name] = v.value;
    });
    return JSON.stringify(formObject);
}
