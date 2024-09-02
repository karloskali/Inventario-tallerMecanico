package com.taller.servicios.web.inventario.servicios.Implementaciones;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.Recepcion;
import com.taller.servicios.web.inventario.repositorios.RecepcionRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.RecepcionInterface;


@Service
public class RecepcionImplement implements RecepcionInterface {
    
    @Autowired
    private RecepcionRepository repositorio;

    @Override
    public List<Recepcion> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public Recepcion guardar(Recepcion recepcion){
        return repositorio.save(recepcion);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}
