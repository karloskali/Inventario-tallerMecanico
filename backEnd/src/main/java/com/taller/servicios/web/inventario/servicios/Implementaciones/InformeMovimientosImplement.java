package com.taller.servicios.web.inventario.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.servicios.web.inventario.entidades.InformeMovimientos;
import com.taller.servicios.web.inventario.repositorios.InformeMovimientosRepository;
import com.taller.servicios.web.inventario.servicios.Interfaces.InformeMovimientosInterface;



@Service
public class InformeMovimientosImplement implements InformeMovimientosInterface {
    
    @Autowired
    private InformeMovimientosRepository repositorio;

    @Override
    public List<InformeMovimientos> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public InformeMovimientos guardar(InformeMovimientos informeMovimientos){
        return repositorio.save(informeMovimientos);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}