package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taller.servicios.web.inventario.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
