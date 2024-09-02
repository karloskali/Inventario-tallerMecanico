package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taller.servicios.web.inventario.entidades.InformeVentas;

public interface InformeVentasRepository extends JpaRepository<InformeVentas, Integer> {
        
}
