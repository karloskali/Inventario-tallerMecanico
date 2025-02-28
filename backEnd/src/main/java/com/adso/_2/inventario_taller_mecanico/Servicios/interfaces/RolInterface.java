package com.adso._2.inventario_taller_mecanico.Servicios.interfaces;

import java.util.Optional;

import com.adso._2.inventario_taller_mecanico.Entidades.Rol;

public interface  RolInterface {

    public Rol guardar(Rol rol);

    public Optional <Rol>findByNombre(String Nombre);
    
}
