package com.adso._2.inventario_taller_mecanico.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adso._2.inventario_taller_mecanico.Entidades.Rol;

public interface  RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombre(String Nombre);
    
}
