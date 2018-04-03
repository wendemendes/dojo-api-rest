package com.dojo.rest.pedido.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Pedido {
	
	@Id 
	@GeneratedValue
	private Integer pedidoKey;
	
	private String observacao;
	
	private Date dataCriacao;
	
	private Date dataFechamento;
	
	

}
