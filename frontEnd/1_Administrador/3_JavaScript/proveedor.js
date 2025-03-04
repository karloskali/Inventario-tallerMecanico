let urlServicioWebProveedor = "http://localhost:8081/api/proveedor";
let contenido_proveedor = document.querySelector("#listado_proveedor")

function listar_proveedor() {
    console.log("listar_proveedor");
    let data = [];
    let resultado = function (response) {
        let items = [];
        $.each(response, function(index, proveedor) {
            items.push("<tr><td>" + proveedor.id + "</td><td>" + proveedor.nombre + "</td><td>" + proveedor.nit + "</td><td>" + proveedor.email + "</td><td>" + proveedor.direccion + "</td><td>" + proveedor.telefono + "</td><td><a class='btn btn-success' href='proveedorEditar.html?id=" + proveedor.id + "'>Editar</a></td><td><a class='btn btn-danger' href='proveedorEliminar.html?id=" + proveedor.id + "'>Eliminar</a></td></tr>");
        });
        
        contenido_proveedor.innerHTML = "<div class='table-container'><table class='table table-striped table-bordered'><thead><tr><th>ID</th><th>Nombre</th><th>Nit</th><th>Email</th><th>Dirección</th><th>telefono</th><th colspan='2'>Opciones</th></tr></thead><tbody>"
         + items.join("") + "</tbody></table></div>";
    };
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: urlServicioWebProveedor,
        context: data,
        data: data,
        dataType: "json",
        success: resultado
    });
}


function nuevo_proveedor() {
    console.log("Llamado a nuevo proveedor");

    // Validación de campos obligatorios
    if (!validarCampos("#formNuevoProveedor")) {
        alert("Por favor, completa todos los campos obligatorios.");
        return; // Detener la ejecución si hay campos vacíos
    }

    // Convertir el formulario a JSON
    var data = convertirFormDataAJSON($("#formNuevoProveedor"));
    var resultado = function(response) {
        alert("El producto fue registrado exitosamente");
        window.location.href = "proveedorListar.html";
    };

    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: urlServicioWebProveedor,
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


// Función para obtener un proveedor por su ID y cargar sus datos en el formulario de edición
function obtener_proveedor(id) {
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

// Función para actualizar un proveedor existente
function actualizar_proveedor() {
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

// Función para confirmar y mostrar datos antes de eliminar un proveedor
function pre_eliminar_proveedor(id) {
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

// Función para eliminar un proveedor
function eliminar_proveedor() {
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
function buscar_proveedor() {
    console.log("Ejecutar Buscar Proveedor");
    var data = convertirFormDataAJSON($("#formBuscar"));

    $.ajax({
        type: "PATCH",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: urlServicioWebProveedor,
        data: data,
        dataType: "json",
        success: function(response) {
            var items = [];
            $.each(response, function(index, proveedor) {
                items.push("<tr><td>" + proveedor.id + "</td><td>" + proveedor.nombre + "</td><td>" + proveedor.nit + "</td><td>" + proveedor.email + "</td><td>" + proveedor.direccion + "</td><td>" + proveedor.telefono + "</td><td><a class='btn btn-success' href='actualizar.html?id=" + proveedor.id + "'>Editar</a> <a class='btn btn-danger' href='eliminar.html?id=" + proveedor.id + "'>Eliminar</a></td></tr>");
            });
            $("#listar_proveedor").html("<table class='table table-hover'><thead><tr><th>ID</th><th>Nombre</th><th>Nit</th><th>Email</th><th>Dirección</th><th>Telefono</th><th>Opciones</th></tr></thead><tbody>" + items.join("") + "</tbody></table>");
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