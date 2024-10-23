package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.InformeStock;
import com.adso._2.inventario_taller_mecanico.Repositorios.InformeStockRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.InformeStockInterface;


@Service
public class InformeStockImplement implements InformeStockInterface {
    
    @Autowired
    private InformeStockRepository repositorio;

    @Override
    public List<InformeStock> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<InformeStock> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public InformeStock guardar(InformeStock informeStock){
        return repositorio.save(informeStock);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}

