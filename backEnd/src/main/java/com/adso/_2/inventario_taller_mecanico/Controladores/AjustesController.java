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

import com.adso._2.inventario_taller_mecanico.Entidades.Ajuste;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.AjusteInterface;

@RestController
@RequestMapping("/api/ajustes")
public class AjustesController {

    @Autowired
    private AjusteInterface servicio;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listarAjustes(){
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarAjusteById(@PathVariable(value = "id") Integer id){
        Optional<Ajuste> ajustes = servicio.buscarPorId(id);
        if (ajustes.isPresent()) {
            return ResponseEntity.ok(ajustes);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crearAjuste(@RequestBody Ajuste ajuste){
        return ResponseEntity.ok(servicio.guardar(ajuste));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editarAjuste(@RequestBody Ajuste ajuste){
        return ResponseEntity.ok(servicio.guardar(ajuste));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAjuste(@PathVariable(value="id") Integer id){
        Optional<Ajuste> ajuste = servicio.buscarPorId(id);
        if (ajuste.isPresent()) {
            servicio.eliminar(id);
            return ResponseEntity.ok(ajuste);
        }
        return ResponseEntity.notFound().build();
    }
}
