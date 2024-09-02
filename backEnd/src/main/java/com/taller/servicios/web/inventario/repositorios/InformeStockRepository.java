package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taller.servicios.web.inventario.entidades.InformeStock;

public interface InformeStockRepository extends JpaRepository<InformeStock, Integer> {
    
}
