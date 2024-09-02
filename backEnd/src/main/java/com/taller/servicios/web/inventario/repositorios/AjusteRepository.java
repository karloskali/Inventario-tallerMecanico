package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taller.servicios.web.inventario.entidades.Ajuste;

public interface AjusteRepository extends JpaRepository<Ajuste, Integer> {
    
}
