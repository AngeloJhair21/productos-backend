package com.UTP.productos.service;


import com.UTP.productos.entidad.Producto;
import com.UTP.productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    //Leer todos los productos
    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }
    //Guardar producto nuevo
    public Producto guardarProducto(Producto producto){
        return repository.save(producto);
    }

    //Actualizar producto exitente
    public Producto actualizarProducto(Long id, Producto productoDetalles){
        Optional<Producto> productoExitente = repository.findById(id);
        if (productoExitente.isPresent()) {
            //Van a obtener cada dato
            Producto producto = productoExitente.get();
            producto.setNombre(productoDetalles.getNombre());
            producto.setPrecio(productoDetalles.getPrecio());
            producto.setCantidad(productoDetalles.getCantidad());
            //Y lo guardara
            return repository.save(producto);
        }
        return null;
    }

    //ELiminar Producto
    public void eliminarProducto(Long id){
        repository.deleteById(id);
    }
}
