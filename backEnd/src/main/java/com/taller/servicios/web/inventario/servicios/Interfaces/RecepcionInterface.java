package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.Recepcion;


public interface RecepcionInterface {

    public List<Recepcion> listarTodos();
    public Optional<Recepcion> buscarPorId(Integer id);
    public Recepcion guardar(Recepcion recepcion);
    public void eliminar(Integer id);
    
}
