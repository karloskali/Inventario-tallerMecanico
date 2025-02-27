package com.adso._2.inventario_taller_mecanico.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso._2.inventario_taller_mecanico.DTO.ProductoDTO;
import com.adso._2.inventario_taller_mecanico.Entidades.Producto;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ProductoInterface;

import jakarta.persistence.EntityNotFoundException;


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
    public ResponseEntity<?> listarProductosById(@PathVariable Integer id){
        Optional<Producto> producto = servicio.buscarPorId(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto);
        }
        return ResponseEntity.notFound().build();
    }
    

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Producto> crearProductos(@RequestBody ProductoDTO productoDTO){
        Producto productoCreado = servicio.crearProducto(productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Producto> editarProducto(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        try {
            Producto productoActualizado = servicio.editarProducto(id, productoDTO);
            return ResponseEntity.ok(productoActualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

/*
 * @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Producto> editarProducto(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        Producto productoActualizado = servicio.editarProducto(id, productoDTO);
        return ResponseEntity.ok(productoActualizado);
    }
 */
    

    //@CrossOrigin(origins = "*")
    //@PutMapping
    //public ResponseEntity<?> editarProducto(@RequestBody Producto producto, Proveedor id){
        //return ResponseEntity.ok(servicio.guardar(producto));
    //}

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        Optional<Producto> producto = servicio.buscarPorId(id);
        if (producto.isPresent()) {
            servicio.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
