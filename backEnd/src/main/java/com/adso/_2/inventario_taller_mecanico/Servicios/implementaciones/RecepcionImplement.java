package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.Recepcion;
import com.adso._2.inventario_taller_mecanico.Repositorios.RecepcionRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.RecepcionInterface;


@Service
public class RecepcionImplement implements RecepcionInterface {
    
    @Autowired
    private RecepcionRepository repositorio;

    @Override
    public List<Recepcion> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<Recepcion> buscarPorId(Integer id){
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
