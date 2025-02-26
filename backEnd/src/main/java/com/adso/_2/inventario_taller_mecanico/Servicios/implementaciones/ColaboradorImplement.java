package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.Entidades.Colaborador;
import com.adso._2.inventario_taller_mecanico.Repositorios.ColaboradorRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ColaboradorInterface;


@Service
public class ColaboradorImplement implements ColaboradorInterface {

    @Autowired
    private ColaboradorRepository repositorio;

    @Override
    public List<Colaborador> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<Colaborador> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

    @Override
    public Optional<Colaborador> login (String user, String password){
        return repositorio.findByUserAndPassword(user, password);
    }

    @Override
    public Colaborador guardar(Colaborador colaborador){
        //asignar usuario y contraseña automaticamente
        colaborador.setUser(colaborador.getEmail());
        colaborador.setPassword(colaborador.getCedula());
        //guardar en la base de datos
        return repositorio.save(colaborador);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }


    
}
