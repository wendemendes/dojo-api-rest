package com.dojo.rest.pedido.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.rest.pedido.model.Pedido;
import com.dojo.rest.pedido.repository.PedidoRepository;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository; 

	@GetMapping
	public List<Pedido> listar(){
		
		return pedidoRepository.findAll();
	}
	

}
