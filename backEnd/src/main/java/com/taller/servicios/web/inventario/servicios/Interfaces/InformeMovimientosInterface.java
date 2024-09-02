package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.InformeMovimientos;

public interface InformeMovimientosInterface {
    
    public List<InformeMovimientos> listarTodos();
    public Optional<InformeMovimientos> buscarPorId(Integer id);
    public InformeMovimientos guardar(InformeMovimientos informeMovimientos);
    public void eliminar(Integer id);

}
