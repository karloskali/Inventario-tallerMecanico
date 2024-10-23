package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.InformeStock;

public interface InformeStockInterface {

    public List<InformeStock> listarTodos();
    public Optional<InformeStock> buscarPorId(Integer id);
    public InformeStock guardar(InformeStock informeStock);
    public void eliminar(Integer id);
}

