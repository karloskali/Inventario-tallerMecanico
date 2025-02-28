package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.DTO.ColaboradorDTO;
import com.adso._2.inventario_taller_mecanico.Entidades.Colaborador;
import com.adso._2.inventario_taller_mecanico.Entidades.Rol;
import com.adso._2.inventario_taller_mecanico.Repositorios.ColaboradorRepository;
import com.adso._2.inventario_taller_mecanico.Repositorios.RolRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ColaboradorInterface;


@Service
public class ColaboradorImplement implements ColaboradorInterface {

    @Autowired
    private ColaboradorRepository repositorio;

    @Autowired
    private RolRepository rolRepositorio;

    @Override
    public List<Colaborador> listarTodos(){
        return repositorio.findAll();
            }

    @Override
    public Optional<Colaborador> buscarPorId(Integer id){
        return repositorio.findById(id);
    }

    @Override
    public Colaborador crearColaborador(ColaboradorDTO colaboradorDTO) {
        Colaborador colaborador = new Colaborador();
        colaborador.setId(colaboradorDTO.getId());
        colaborador.setNombre(colaboradorDTO.getNombre());
        colaborador.setApellido(colaboradorDTO.getApellido());
        colaborador.setEmail(colaboradorDTO.getEmail());
        colaborador.setCedula(colaboradorDTO.getCedula());
        colaborador.setUser(colaboradorDTO.getEmail());
        colaborador.setPassword(colaboradorDTO.getCedula());
        colaborador.setDireccion(colaboradorDTO.getDireccion());
        colaborador.setTelefono(colaboradorDTO.getTelefono());

        // Buscar el proveedor por nombre
        Optional<Rol> optRol = rolRepositorio.findByNombre(colaboradorDTO.getNombreRol());
        if (optRol.isPresent()) {
            colaborador.setRol(optRol.get());
        } else {
            // Puedes optar por crear un nuevo proveedor o lanzar un error
            throw new RuntimeException("Proveedor no encontrado con el nombre: " + colaboradorDTO.getNombreRol());
        }
        
        return repositorio.save(colaborador);
    }


    @Override
    public Optional<Colaborador> login (String user, String password){
        return repositorio.findByUserAndPassword(user, password);
    }

    @Override
    public Colaborador guardar(Colaborador colaborador){
        //asignar usuario y contraseña automaticamente
        //colaborador.setUser(colaborador.getEmail());
        //colaborador.setPassword(colaborador.getCedula());
        //guardar en la base de datos
        return repositorio.save(colaborador);
    }

    @Override
    public void eliminar(Integer id){
        repositorio.deleteById(id);
    }


    
}
