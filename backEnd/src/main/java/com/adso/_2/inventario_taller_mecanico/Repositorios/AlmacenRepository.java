package com.adso._2.inventario_taller_mecanico.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adso._2.inventario_taller_mecanico.Entidades.Almacen;

public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
    
}
