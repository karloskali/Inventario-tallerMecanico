package com.adso._2.inventario_taller_mecanico.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso._2.inventario_taller_mecanico.Entidades.Producto;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ProductoInterface;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoInterface servicio;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listarProductos(){
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarProductosById(@PathVariable(value = "id") Integer id){
        Optional<Producto> producto = servicio.buscarPorId(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crearProductos(@RequestBody Producto producto){
        return ResponseEntity.ok(servicio.guardar(producto));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(servicio.guardar(producto));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable(value="id") Integer id){
        Optional<Producto> producto = servicio.buscarPorId(id);
        if (producto.isPresent()) {
            servicio.eliminar(id);
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }

}
