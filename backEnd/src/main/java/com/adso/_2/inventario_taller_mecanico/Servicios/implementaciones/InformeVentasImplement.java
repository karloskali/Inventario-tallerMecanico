package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.InformeVentas;
import com.adso._2.inventario_taller_mecanico.Repositorios.InformeVentasRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.InformeVentasInterface;

@Service
public class InformeVentasImplement implements InformeVentasInterface {
    
    @Autowired
    private InformeVentasRepository repositorio;

    @Override
    public List<InformeVentas> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<InformeVentas> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

     @Override
    public InformeVentas guardar(InformeVentas informeVentas){
        return repositorio.save(informeVentas);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }
    
}
