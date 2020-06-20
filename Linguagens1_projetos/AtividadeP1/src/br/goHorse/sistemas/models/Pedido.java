package br.goHorse.sistemas.models;

import br.goHorse.sistemas.enums.EstadoPedido;
import br.goHorse.sistemas.enums.FormaPagamento;

public class Pedido {
	private String ID;
	private String descricao;
	private Double valor;
	private FormaPagamento formaPagamento;
	private EstadoPedido estadoPedido;
	
}