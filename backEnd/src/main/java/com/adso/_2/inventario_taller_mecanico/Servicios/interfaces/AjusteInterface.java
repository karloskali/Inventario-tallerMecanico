package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.List;
import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.Ajuste;

public interface AjusteInterface {
    
    public List<Ajuste> listarTodos();
    public Optional<Ajuste> buscarPorId(Integer id);
    public Ajuste guardar(Ajuste ajuste);
    public void eliminar(Integer id);
    
}
