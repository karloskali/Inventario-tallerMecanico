package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.DTO.ProductoDTO;
import com.adso._2.inventario_taller_mecanico.Entidades.Producto;

public interface ProductoInterface {

    public List<Producto> listarTodos();
    public Optional<Producto> buscarPorId(Integer id);
    public Producto editarProducto(Integer proveedor, ProductoDTO productoDTO);
    public Producto guardar(Producto producto);
    public void eliminar(Integer id);

    public Producto crearProducto(ProductoDTO productoDTO);

}
