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

import com.adso._2.inventario_taller_mecanico.Entidades.InformeStock;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.InformeStockInterface;

@RestController
@RequestMapping("/api/informe_stock")
public class InformeStockController {

    @Autowired
    private InformeStockInterface servicio;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listarInformesStock() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarInformeStockById(@PathVariable Integer id) {
        Optional<InformeStock> informeStock = servicio.buscarPorId(id);
        if (informeStock.isPresent()) {
            return ResponseEntity.ok(informeStock);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crearInformeStock(@RequestBody InformeStock informeStock) {
        return ResponseEntity.ok(servicio.guardar(informeStock));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editarInformeStock(@RequestBody InformeStock informeStock) {
        return ResponseEntity.ok(servicio.guardar(informeStock));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarInformeStock(@PathVariable Integer id) {
        Optional<InformeStock> informeStock = servicio.buscarPorId(id);
        if (informeStock.isPresent()) {
            servicio.eliminar(id);
            return ResponseEntity.ok(informeStock);
        }
        return ResponseEntity.notFound().build();
    }
}
