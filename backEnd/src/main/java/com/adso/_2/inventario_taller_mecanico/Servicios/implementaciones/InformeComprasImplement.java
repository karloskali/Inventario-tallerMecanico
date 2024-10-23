package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.InformeCompras;
import com.adso._2.inventario_taller_mecanico.Repositorios.InformeComprasRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.InformeComprasInterface;


@Service
public class InformeComprasImplement implements InformeComprasInterface {
    
    @Autowired
    private InformeComprasRepository repositorio;

    @Override
    public List<InformeCompras> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<InformeCompras> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public InformeCompras guardar(InformeCompras informeCompras){
        return repositorio.save(informeCompras);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }

    
}
