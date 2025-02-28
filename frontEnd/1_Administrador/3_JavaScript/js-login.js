let urlServicioWebColaborador = "http://localhost:8081/api/colaborador";
let contenido_productos = document.querySelector("#listado_productos");

document.getElementById('botonLogin').addEventListener('click', function(e){
    e.preventDefault();  // evita que el botón recargue la página (si es tipo "submit")
    login();  // llama a la función
});
   //window.location.href="1_Administrador/1_Html/resumenInventario.html";


// Función para buscar usuario y mostrar los resultados
function login() {

   console.log("Ejecutar login");
   let data = convertirFormDataAJSON($("#formLogin"));  

   $.ajax({
       type: "PATCH",
       headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
       },
       url: urlServicioWebColaborador,
       data: data,
       dataType: "json",
       success: function(response){
            //res.json({ success: true, mensaje: "Login exitoso" });prueba
            
            if (response == null){
                // Muestra un mensaje de error al usuario
                alert("Usuario o contraseña incorrectos.");
            } else {
                let rol = response.rol.nombre;
                console.log(rol);

                if (rol === "administrador") {
                   // Redirige al usuario a la página administrador
                    window.location.href = "../../1_Administrador/1_Html/resumenInventario.html";     
                } // falta el else para usuario vendedor
                //response.rol{ // Verifica si el login fue exitoso
                    // Redirige al usuario a la página correspondiente
                        //window.location.href = "../../1_Administrador/1_Html/resumenInventario.html";
            
            }
        }
       
       });
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

//------------------------------------------------------------------------------

function listar_productos() {
   console.log("listar_productos");
   let data = [];
   let resultado = function (response) {
       let items = [];
       $.each(response, function(index, producto) {
           items.push("<tr><td>" + producto.id + "</td><td>" + producto.nombre + "</td><td>" + producto.cantidad + "</td><td>" + producto.descripcion + "</td><td>" + producto.marca + "</td><td>" + producto.modelo + "</td><td>" + producto.precio + "</td><td>" + producto.ubicacion + "</td><td>" + producto.stock + "</td><td><a class='btn btn-success' href='productoEditar.html?id=" + producto.id + "'>Editar</a></td><td><a class='btn btn-danger' href='productoEliminar.html?id=" + producto.id + "'>Eliminar</a></td></tr>");
       });
       
       contenido_productos.innerHTML = "<div class='table-container'><table class='table table-striped table-bordered'><thead><tr><th>ID</th><th>Nombre</th><th>Cantidad</th><th>Descripción</th><th>Marca</th><th>Modelo</th><th>Precio</th><th>Ubicación</th><th>Stock</th><th colspan='2'>Opciones</th></tr></thead><tbody>"
        + items.join("") + "</tbody></table></div>";
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
