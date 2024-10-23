package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.Expedicion;
import com.adso._2.inventario_taller_mecanico.Repositorios.ExpedicionRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ExpedicionInterface;

@Service
public class ExpedicionImplement implements ExpedicionInterface {
    
    @Autowired
    private ExpedicionRepository repositorio;

    @Override
    public List<Expedicion> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<Expedicion> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public Expedicion guardar(Expedicion expedicion){
        return repositorio.save(expedicion);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}