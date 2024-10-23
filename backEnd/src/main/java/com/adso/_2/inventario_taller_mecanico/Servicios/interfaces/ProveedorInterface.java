package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.Proveedor;

public interface ProveedorInterface {

    public List<Proveedor> listarTodos();
    public Optional<Proveedor> buscarPorId(Integer id);
    public Proveedor guardar(Proveedor proveedor);
    public void eliminar(Integer id);
    
}

