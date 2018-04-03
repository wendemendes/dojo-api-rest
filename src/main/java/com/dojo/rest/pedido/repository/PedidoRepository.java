package com.dojo.rest.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dojo.rest.pedido.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
