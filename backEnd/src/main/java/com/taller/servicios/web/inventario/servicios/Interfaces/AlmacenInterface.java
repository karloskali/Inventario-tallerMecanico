package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.Almacen;

public interface AlmacenInterface {
    
    public List<Almacen> listarTodos();
    public Optional<Almacen> buscarPorId(Integer id);
    public Almacen guardar(Almacen almacen);
    public void eliminar(Integer id);

}
