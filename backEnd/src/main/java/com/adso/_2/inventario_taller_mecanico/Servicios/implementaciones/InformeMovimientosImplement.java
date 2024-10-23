package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.InformeMovimientos;
import com.adso._2.inventario_taller_mecanico.Repositorios.InformeMovimientosRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.InformeMovimientosInterface;

@Service
public class InformeMovimientosImplement implements InformeMovimientosInterface {
    
    @Autowired
    private InformeMovimientosRepository repositorio;

    @Override
    public List<InformeMovimientos> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<InformeMovimientos> buscarPorId(Integer id){
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
