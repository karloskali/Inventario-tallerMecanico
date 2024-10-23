package com.adso._2.inventario_taller_mecanico.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adso._2.inventario_taller_mecanico.Entidades.InformeStock;

public interface InformeStockRepository extends JpaRepository<InformeStock, Integer> {
    
}
