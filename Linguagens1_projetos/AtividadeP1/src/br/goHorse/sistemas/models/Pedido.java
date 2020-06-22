package br.goHorse.sistemas.models;

import br.goHorse.sistemas.enums.EstadoPedido;
import br.goHorse.sistemas.enums.FormaPagamento;

public class Pedido {
	private String ID;
	private String descricao;
	private Double valor;
	private FormaPagamento formaPagamento;
	private EstadoPedido estadoPedido;

	public Pedido(String iD, String descricao, Double valor, FormaPagamento formaPagamento, EstadoPedido estadoPedido) {
		ID = iD;
		this.descricao = descricao;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
		this.estadoPedido = estadoPedido;
	}
	
	public String getID() {
		return ID;
	}
	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	@Override
	public String toString() {
		return "Pedido { "+ "ID=" + ID + ", descricao=" + descricao + ", estadoPedido=" + estadoPedido + ", formaPagamento="
				+ formaPagamento + ", valor=" + valor + " }";
	}
}