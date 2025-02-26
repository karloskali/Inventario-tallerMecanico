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

import com.adso._2.inventario_taller_mecanico.Entidades.Colaborador;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ColaboradorInterface;


@RestController
@RequestMapping("/api/colaborador")
public class ColaboradorController{

    @Autowired
    private ColaboradorInterface servicio;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listarColaborador(){
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarColaboradorById(@PathVariable Integer id){
        Optional<Colaborador> colaborador = servicio.buscarPorId(id);
        if (colaborador.isPresent()) {
            return ResponseEntity.ok(colaborador);
        }
        return ResponseEntity.notFound().build();
    }
    
    @CrossOrigin(origins = "*")
    @PatchMapping
    public ResponseEntity<?> login(@RequestBody Colaborador colaborador){
        return ResponseEntity.ok(servicio.login(colaborador.getUser(), colaborador.getPassword()));
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crearColaborador(@RequestBody Colaborador colaborador){
        return ResponseEntity.ok(servicio.guardar(colaborador));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editarColaborador(@RequestBody Colaborador colaborador){
        return ResponseEntity.ok(servicio.guardar(colaborador));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        Optional<Colaborador> colaborador = servicio.buscarPorId(id);
        if (colaborador.isPresent()) {
            servicio.eliminar(id);
            return ResponseEntity.ok(colaborador);
        }
        return ResponseEntity.notFound().build();
    }
    
}
    
