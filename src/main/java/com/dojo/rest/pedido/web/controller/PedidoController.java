package com.dojo.rest.pedido.web.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.rest.pedido.model.Pedido;
import com.dojo.rest.pedido.repository.PedidoRepository;
import com.dojo.rest.pedido.web.form.PedidoForm;
import com.dojo.rest.pedido.web.view.PedidoView;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository; 

	@GetMapping
	public List<PedidoView> listar(){
		return PedidoView.toView(pedidoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public PedidoView obter(@PathVariable int id) {
		return new PedidoView(pedidoRepository.findOne(id));
		
	}
	
	@PostMapping
	public PedidoView criar(PedidoForm form) {
		Pedido pedido = new Pedido(form);
		return null;
	}

}
