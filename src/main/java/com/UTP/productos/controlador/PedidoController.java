package com.UTP.productos.controlador;

import com.UTP.productos.entidad.Pedido;
import com.UTP.productos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public List<Pedido> listarPedidos() {
        return service.obtenerTodos();
    }

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return service.guardarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void cancelarPedido(@PathVariable Long id) {
        service.eliminarPedido(id);
    }
}
