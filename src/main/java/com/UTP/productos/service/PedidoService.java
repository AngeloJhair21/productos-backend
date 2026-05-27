package com.UTP.productos.service;

import com.UTP.productos.entidad.Pedido;
import com.UTP.productos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }


    public Pedido guardarPedido(Pedido pedido) {
        pedido.setFecha(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }

    // Cancelar/Eliminar un pedido por su ID
    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}