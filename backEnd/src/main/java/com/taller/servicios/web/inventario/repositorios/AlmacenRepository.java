package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taller.servicios.web.inventario.entidades.Almacen;

public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
    
}
