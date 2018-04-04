package com.dojo.rest.pedido.web.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dojo.rest.pedido.model.Pedido;

public class PedidoView {
	
	
	private int pedidoKey;
	private String observacao;
	private Date dataCriacao;
	private int lojaKey;
	private Date dataFechamento;
	public int getPedidoKey() {
		return pedidoKey;
	}
	public void setPedidoKey(int pedidoKey) {
		this.pedidoKey = pedidoKey;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public int getLojaKey() {
		return lojaKey;
	}
	public void setLojaKey(int lojaKey) {
		this.lojaKey = lojaKey;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	
	public PedidoView(Pedido pedido) {
		this.pedidoKey = pedido.getPedidoKey();
		this.observacao = pedido.getObservacao();
		this.dataCriacao = pedido.getDataCriacao();
		this.lojaKey = pedido.getLojaKey();
		this.dataFechamento = pedido.getDataFechamento();
	}
	
	public static List<PedidoView> toView(List<Pedido> pedidos){
		List<PedidoView> pedidosView = new ArrayList<>();
		pedidos.forEach(pedido -> {
			pedidosView.add(new PedidoView(pedido));
		}); 
		
		return pedidosView;
	}
}
