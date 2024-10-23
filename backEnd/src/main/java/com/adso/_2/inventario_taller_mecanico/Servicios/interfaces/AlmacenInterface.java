package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.Almacen;

public interface AlmacenInterface {
    
    public List<Almacen> listarTodos();
    public Optional<Almacen> buscarPorId(Integer id);
    public Almacen guardar(Almacen almacen);
    public void eliminar(Integer id);

}
