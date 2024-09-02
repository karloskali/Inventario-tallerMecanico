package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.Expedicion;


public interface ExpedicionInterface {
    
    public List<Expedicion> listarTodos();
    public Optional<Expedicion> buscarPorId(Integer id);
    public Expedicion guardar(Expedicion expedicion);
    public void eliminar(Integer id);

}
