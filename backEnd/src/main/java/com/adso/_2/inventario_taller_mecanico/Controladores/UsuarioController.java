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

import com.adso._2.inventario_taller_mecanico.Entidades.Usuario;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.UsuarioInterface;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioInterface servicio;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(servicio.listarTodos());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarUsuarioById(@PathVariable(value = "id") Integer id) {
        Optional<Usuario> usuario = servicio.buscarPorId(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(servicio.guardar(usuario));
    }

    @CrossOrigin(origins = "*")
    @PutMapping
    public ResponseEntity<?> editarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(servicio.guardar(usuario));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable(value = "id") Integer id) {
        Optional<Usuario> usuario = servicio.buscarPorId(id);
        if (usuario.isPresent()) {
            servicio.eliminar(id);
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }
}

