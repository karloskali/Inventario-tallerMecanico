package com.adso._2.inventario_taller_mecanico.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adso._2.inventario_taller_mecanico.Entidades.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
     
}
