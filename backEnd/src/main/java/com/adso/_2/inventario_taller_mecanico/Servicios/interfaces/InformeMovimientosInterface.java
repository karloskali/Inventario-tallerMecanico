package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.InformeMovimientos;

public interface InformeMovimientosInterface {
    
    public List<InformeMovimientos> listarTodos();
    public Optional<InformeMovimientos> buscarPorId(Integer id);
    public InformeMovimientos guardar(InformeMovimientos informeMovimientos);
    public void eliminar(Integer id);

}
