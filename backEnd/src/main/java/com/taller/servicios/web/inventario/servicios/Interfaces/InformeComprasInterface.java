package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.InformeCompras;


public interface InformeComprasInterface {
    
    public List<InformeCompras> listarTodos();
    public Optional<InformeCompras> buscarPorId(Integer id);
    public InformeCompras guardar(InformeCompras informeCompras);
    public void eliminar(Integer id);
}
