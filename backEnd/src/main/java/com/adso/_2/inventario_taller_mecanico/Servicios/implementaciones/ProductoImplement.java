package com.adso._2.inventario_taller_mecanico.Servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso._2.inventario_taller_mecanico.DTO.ProductoDTO;
import com.adso._2.inventario_taller_mecanico.Entidades.Producto;
import com.adso._2.inventario_taller_mecanico.Entidades.Proveedor;
import com.adso._2.inventario_taller_mecanico.Repositorios.ProductoRepository;
import com.adso._2.inventario_taller_mecanico.Repositorios.ProveedorRepository;
import com.adso._2.inventario_taller_mecanico.Servicios.interfaces.ProductoInterface;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductoImplement implements ProductoInterface {

    @Autowired
    private ProductoRepository productoRepositorio;

    @Autowired
    private ProveedorRepository proveedorRepositorio;

    @Override
    public List<Producto> listarTodos(){
        return productoRepositorio.findAll();
    }

    @Override
    public Optional<Producto> buscarPorId(Integer id){
        return productoRepositorio.findById(id);
    }

    @Override
    public Producto crearProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setCantidad(productoDTO.getCantidad());
        producto.setStock(productoDTO.getStock());
        producto.setMarca(productoDTO.getMarca());
        producto.setModelo(productoDTO.getModelo());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setUbicacion(productoDTO.getUbicacion());
        producto.setDescripcion(productoDTO.getDescripcion());

        // Buscar el proveedor por nombre
        Optional<Proveedor> optProveedor = proveedorRepositorio.findByNombre(productoDTO.getNombreProveedor());
        if (optProveedor.isPresent()) {
            producto.setProveedor(optProveedor.get());
        } else {
            // Puedes optar por crear un nuevo proveedor o lanzar un error
            throw new RuntimeException("Proveedor no encontrado con el nombre: " + productoDTO.getNombreProveedor());
        }
        
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto editarProducto(Integer id, ProductoDTO productoDTO) {
        Optional<Producto> productoExistente = productoRepositorio.findById(id);
        if (productoExistente.isPresent()) {
            Producto productoActualizado = productoExistente.get();
            productoActualizado.setId(productoDTO.getId());
            productoActualizado.setNombre(productoDTO.getNombre());
            productoActualizado.setCantidad(productoDTO.getCantidad());
            productoActualizado.setStock(productoDTO.getStock());
            productoActualizado.setMarca(productoDTO.getMarca());
            productoActualizado.setModelo(productoDTO.getModelo());
            productoActualizado.setPrecio(productoDTO.getPrecio());
            productoActualizado.setUbicacion(productoDTO.getUbicacion());
            productoActualizado.setDescripcion(productoDTO.getDescripcion());
            // ... actualiza otros campos

            Optional<Proveedor> proveedor = proveedorRepositorio.findById(productoDTO.getProveedor());
            if (proveedor.isPresent()) {
                productoActualizado.setProveedor(proveedor.get());
            } else {
                throw new EntityNotFoundException("Proveedor no encontrado");
            }

            return productoRepositorio.save(productoActualizado);
        } else {
            throw new EntityNotFoundException("Producto no encontrado");
        }
    }
    
/* codigo para buscar proveedor por nombre
 * @Override
    public Producto editarProducto(Integer id, ProductoDTO productoDTO) {
        Optional<Producto> productoExistente = productoRepositorio.findById(id);
    
        if (productoExistente.isPresent()) {
            Producto productoActualizado = productoExistente.get();
            productoActualizado.setId(productoDTO.getId());
            productoActualizado.setNombre(productoDTO.getNombre());
            productoActualizado.setCantidad(productoDTO.getCantidad());
            productoActualizado.setStock(productoDTO.getStock());
            productoActualizado.setMarca(productoDTO.getMarca());
            productoActualizado.setModelo(productoDTO.getModelo());
            productoActualizado.setPrecio(productoDTO.getPrecio());
            productoActualizado.setUbicacion(productoDTO.getUbicacion());
            productoActualizado.setDescripcion(productoDTO.getDescripcion());
    
            // Buscar proveedor por nombre
            if (productoDTO.getNombreProveedor() != null && !productoDTO.getNombreProveedor().isEmpty()) {
                Optional<Proveedor> proveedor = proveedorRepositorio.findByNombre(productoDTO.getNombreProveedor());
    
                if (proveedor.isPresent()) {
                    productoActualizado.setProveedor(proveedor.get());
                } else {
                    throw new EntityNotFoundException("Proveedor no encontrado con nombre: " + productoDTO.getNombreProveedor());
                }
            } else {
                throw new IllegalArgumentException("Nombre de proveedor no proporcionado en el DTO.");
            }
    
            return productoRepositorio.save(productoActualizado);
        } else {
            throw new EntityNotFoundException("Producto no encontrado con ID: " + id);
        }
    }
 */
    

    @Override
    public Producto guardar(Producto producto){
        return productoRepositorio.save(producto);
    }

    @Override
    public void eliminar(Integer id){
        productoRepositorio.deleteById(id);
    }
        
}
