package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.InformeVentas;

public interface InformeVentasInterface {

    public List<InformeVentas> listarTodos();
    public Optional<InformeVentas> buscarPorId(Integer id);
    public InformeVentas guardar(InformeVentas informeVentas);
    public void eliminar(Integer id);
    
}
