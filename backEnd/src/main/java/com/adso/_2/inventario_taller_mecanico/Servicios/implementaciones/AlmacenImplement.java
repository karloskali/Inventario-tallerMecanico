package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.Almacen;
import com.adso._2.inventario_taller_mecanico.Repositorios.AlmacenRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.AlmacenInterface;


@Service
public class AlmacenImplement implements AlmacenInterface {
    
    @Autowired
    private AlmacenRepository repositorio;

    @Override
    public List<Almacen> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<Almacen> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public Almacen guardar(Almacen almacen){
        return repositorio.save(almacen);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }
    
}
