package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.Expedicion;


public interface ExpedicionInterface {
    
    public List<Expedicion> listarTodos();
    public Optional<Expedicion> buscarPorId(Integer id);
    public Expedicion guardar(Expedicion expedicion);
    public void eliminar(Integer id);

}
