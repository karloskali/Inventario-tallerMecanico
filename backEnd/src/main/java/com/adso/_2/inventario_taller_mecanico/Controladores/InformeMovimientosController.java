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

import com.adso._2.inventario_taller_mecanico.Entidades.InformeMovimientos;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.InformeMovimientosInterface;

@RestController
@RequestMapping("/api/informe_movimientos")
public class InformeMovimientosController {

    @Autowired
    private InformeMovimientosInterface servicio;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listarInformesMovimientos() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarInformeMovimientoById(@PathVariable Integer id) {
        Optional<InformeMovimientos> informeMovimiento = servicio.buscarPorId(id);
        if (informeMovimiento.isPresent()) {
            return ResponseEntity.ok(informeMovimiento);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crearInformeMovimiento(@RequestBody InformeMovimientos informeMovimiento) {
        return ResponseEntity.ok(servicio.guardar(informeMovimiento));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editarInformeMovimiento(@RequestBody InformeMovimientos informeMovimiento) {
        return ResponseEntity.ok(servicio.guardar(informeMovimiento));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarInformeMovimiento(@PathVariable Integer id) {
        Optional<InformeMovimientos> informeMovimiento = servicio.buscarPorId(id);
        if (informeMovimiento.isPresent()) {
            servicio.eliminar(id);
            return ResponseEntity.ok(informeMovimiento);
        }
        return ResponseEntity.notFound().build();
    }
}

