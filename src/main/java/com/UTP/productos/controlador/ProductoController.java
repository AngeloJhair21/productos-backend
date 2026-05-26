package com.UTP.productos.controlador;

import com.UTP.productos.entidad.Producto;
import com.UTP.productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> listarProductos(){
        return service.obtenerTodos();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return service.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
        return service.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id){
        service.eliminarProducto(id);
    }
}
