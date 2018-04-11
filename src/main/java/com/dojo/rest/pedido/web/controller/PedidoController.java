package com.dojo.rest.pedido.web.controller;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<PedidoView> criar(@RequestBody PedidoForm form) {
		Pedido pedido = new Pedido(form);
		PedidoView pedidoView = new PedidoView(pedidoRepository.save(pedido));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pedidoView.getPedidoKey()).toUri();
		
		return ResponseEntity.created(uri).body(pedidoView);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable int id){		
		pedidoRepository.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PedidoView> atualizar(@RequestBody PedidoForm form, @PathVariable int id) {
		Pedido pedido = pedidoRepository.findOne(id);
		
		pedido
		
		Pedido pedido = new Pedido(form);
		pedido.setPedidoKey(id);
		Pedido pedidoAlterado = pedidoRepository.save(pedido);
		PedidoView pedidoView = new PedidoView(pedidoAlterado);
		
		return ResponseEntity.ok(pedidoView);
	}
	
}
