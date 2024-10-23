package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.Ajuste;
import com.adso._2.inventario_taller_mecanico.Repositorios.AjusteRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.AjusteInterface;


@Service
public class AjusteImplement implements AjusteInterface {
    
    @Autowired
    private AjusteRepository repositorio;

    @Override
    public List<Ajuste> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<Ajuste> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public Ajuste guardar(Ajuste ajuste){
        return repositorio.save(ajuste);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }
    
}
