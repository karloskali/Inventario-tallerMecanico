package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.InformeCompras;


public interface InformeComprasInterface {
    
    public List<InformeCompras> listarTodos();
    public Optional<InformeCompras> buscarPorId(Integer id);
    public InformeCompras guardar(InformeCompras informeCompras);
    public void eliminar(Integer id);
}