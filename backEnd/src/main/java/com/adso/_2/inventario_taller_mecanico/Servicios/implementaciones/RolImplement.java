package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.Rol;
import com.adso._2.inventario_taller_mecanico.Repositorios.RolRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.RolInterface;

@Service
public class RolImplement implements RolInterface {

    @Autowired
    private RolRepository repositorio;

    @Override
    public Rol guardar(Rol rol){
        return repositorio.save(rol);
    }

    @Override
    public Optional<Rol> findByNombre(String Nombre){
        return repositorio.findByNombre(Nombre);
    }
    
}
