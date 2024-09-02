package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.InformeStock;



public interface InformeStockInterface {

    public List<InformeStock> listarTodos();
    public Optional<InformeStock> buscarPorId(Integer id);
    public InformeStock guardar(InformeStock informeStock);
    public void eliminar(Integer id);
}
