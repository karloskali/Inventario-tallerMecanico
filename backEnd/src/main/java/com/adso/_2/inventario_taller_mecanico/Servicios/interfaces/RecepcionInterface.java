package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.Recepcion;

public interface RecepcionInterface {

    public List<Recepcion> listarTodos();
    public Optional<Recepcion> buscarPorId(Integer id);
    public Recepcion guardar(Recepcion recepcion);
    public void eliminar(Integer id);
    
}
