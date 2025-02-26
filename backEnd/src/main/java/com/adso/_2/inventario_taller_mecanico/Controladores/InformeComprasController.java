package com.adso._2.inventario_taller_mecanico.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.adso._2.inventario_taller_mecanico.Entidades.InformeCompras;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.InformeComprasInterface;

@RestController
@RequestMapping("/api/informe_compras")
public class InformeComprasController {

    @Autowired
    private InformeComprasInterface servicio;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listarInformesCompras() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarInformeCompraById(@PathVariable Integer id) {
        Optional<InformeCompras> informeCompra = servicio.buscarPorId(id);
        if (informeCompra.isPresent()) {
            return ResponseEntity.ok(informeCompra);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crearInformeCompra(@RequestBody InformeCompras informeCompra) {
        return ResponseEntity.ok(servicio.guardar(informeCompra));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editarInformeCompra(@RequestBody InformeCompras informeCompra) {
        return ResponseEntity.ok(servicio.guardar(informeCompra));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarInformeCompra(@PathVariable Integer id) {
        Optional<InformeCompras> informeCompra = servicio.buscarPorId(id);
        if (informeCompra.isPresent()) {
            servicio.eliminar(id);
            return ResponseEntity.ok(informeCompra);
        }
        return ResponseEntity.notFound().build();
    }
}

