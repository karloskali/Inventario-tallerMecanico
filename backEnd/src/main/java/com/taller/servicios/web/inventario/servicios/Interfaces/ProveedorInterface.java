package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.Proveedor;

public interface ProveedorInterface {

    public List<Proveedor> listarTodos();
    public Optional<Proveedor> buscarPorId(Integer id);
    public Proveedor guardar(Proveedor proveedor);
    public void eliminar(Integer id);
    
}
