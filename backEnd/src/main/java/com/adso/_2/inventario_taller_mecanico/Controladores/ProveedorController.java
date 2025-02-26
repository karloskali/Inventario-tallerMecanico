package com.adso._2.inventario_taller_mecanico.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso._2.inventario_taller_mecanico.Entidades.Proveedor;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ProveedorInterface;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorInterface servicio;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listarProveedores() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarProveedorById(@PathVariable Integer id) {
        Optional<Proveedor> proveedor = servicio.buscarPorId(id);
        if (proveedor.isPresent()) {
            return ResponseEntity.ok(proveedor);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crearProveedor(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(servicio.guardar(proveedor));
    }

    @CrossOrigin(origins = "*")
    @PatchMapping
    public ResponseEntity<?> findByNombre(@RequestBody Proveedor proveedor){
        return ResponseEntity.ok(servicio.findByNombre(proveedor.getNombre()));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editarProveedor(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(servicio.guardar(proveedor));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable Integer id) {
        Optional<Proveedor> proveedor = servicio.buscarPorId(id);
        if (proveedor.isPresent()) {
            servicio.eliminar(id);
            return ResponseEntity.ok(proveedor);
        }
        return ResponseEntity.notFound().build();
    }
}
