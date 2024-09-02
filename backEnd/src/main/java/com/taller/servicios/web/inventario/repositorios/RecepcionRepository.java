package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taller.servicios.web.inventario.entidades.Recepcion;

public interface RecepcionRepository extends JpaRepository<Recepcion, Integer> {
    
}
