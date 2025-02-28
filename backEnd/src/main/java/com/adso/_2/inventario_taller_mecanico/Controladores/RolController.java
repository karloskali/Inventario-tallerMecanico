package com.adso._2.inventario_taller_mecanico.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso._2.inventario_taller_mecanico.Entidades.Rol;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.RolInterface;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private RolInterface servicio;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crearRol(@RequestBody Rol rol) {
        return ResponseEntity.ok(servicio.guardar(rol));
    }

    
}
