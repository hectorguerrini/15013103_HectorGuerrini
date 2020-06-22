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
	
	
	/** 
	 * Retorna o ID do pedido
	 * @return String
	 */
	public String getID() {
		return ID;
	}
	
	/** 
	 * Atribui o estado do pedido a um novo estado
	 * @param estadoPedido REALIZADO, PREPARACAO, SAIU_PARA_ENTREGA, ENTREGUE, DEVOLVIDO
	 */
	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Pedido{ "+ "ID=" + ID + ", descricao=" + descricao + ", estadoPedido=" + estadoPedido + ", formaPagamento="
				+ formaPagamento + ", valor=" + valor + " }";
	}
}