package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taller.servicios.web.inventario.entidades.Expedicion;

public interface ExpedicionRepository extends JpaRepository<Expedicion, Integer> {
    
}
