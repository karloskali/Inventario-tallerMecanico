package com.taller.servicios.web.inventario.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.taller.servicios.web.inventario.entidades.Ajuste;

public interface AjusteInterface {
    
    public List<Ajuste> listarTodos();
    public Optional<Ajuste> buscarPorId(Integer id);
    public Ajuste guardar(Ajuste ajuste);
    public void eliminar(Integer id);
    
}
