package com.dojo.rest.pedido.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dojo.rest.pedido.web.form.PedidoForm;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pedido {
	
	public Pedido(PedidoForm form) {
		this.lojaKey = form.getLojaKey();
		this.observacao = form.getObservacao();
		this.dataCriacao = new Date();
	}

	@Id 
	@GeneratedValue
	private Integer pedidoKey;
	
	private String observacao;
	
	private Date dataCriacao;
	
	private Integer lojaKey;
	
	private Date dataFechamento;
	
	

}
