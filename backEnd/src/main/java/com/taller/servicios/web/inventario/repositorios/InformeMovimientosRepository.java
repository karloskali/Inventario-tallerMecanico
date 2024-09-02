package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller.servicios.web.inventario.entidades.InformeMovimientos;

public interface InformeMovimientosRepository extends JpaRepository<InformeMovimientos, Integer> {
    
}
