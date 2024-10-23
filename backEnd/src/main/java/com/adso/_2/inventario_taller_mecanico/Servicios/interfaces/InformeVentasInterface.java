package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.InformeVentas;

public interface InformeVentasInterface {

    public List<InformeVentas> listarTodos();
    public Optional<InformeVentas> buscarPorId(Integer id);
    public InformeVentas guardar(InformeVentas informeVentas);
    public void eliminar(Integer id);
    
}