package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taller.servicios.web.inventario.entidades.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

        
}
