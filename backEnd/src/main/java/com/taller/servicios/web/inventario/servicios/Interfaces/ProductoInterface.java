package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.Producto;

public interface ProductoInterface {

    public List<Producto> listarTodos();
    public Optional<Producto> buscarPorId(Integer id);
    public Producto guardar(Producto producto);
    public void eliminar(Integer id);
    //public Optional<List<Producto>> buscar(String nombre);
    
}
