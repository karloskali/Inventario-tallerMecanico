package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller.servicios.web.inventario.entidades.InformeCompras;

public interface InformeComprasRepository extends JpaRepository<InformeCompras, Integer> {
    
}
