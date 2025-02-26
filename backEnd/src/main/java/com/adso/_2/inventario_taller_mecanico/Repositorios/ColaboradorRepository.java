package com.adso._2.inventario_taller_mecanico.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adso._2.inventario_taller_mecanico.Entidades.Colaborador;


public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    Optional<Colaborador> findByUserAndPassword(String user, String password);
    
}
