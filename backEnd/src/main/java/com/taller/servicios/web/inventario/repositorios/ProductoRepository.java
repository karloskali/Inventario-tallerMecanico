package com.taller.servicios.web.inventario.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taller.servicios.web.inventario.entidades.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    //Optional<List<Producto>> findByNombreLikeOrVencimiento(String nombre, String vencimiento);
}
