package br.goHorse.sistemas.controllers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import br.goHorse.sistemas.enums.EstadoPedido;
import br.goHorse.sistemas.enums.FormaPagamento;
import br.goHorse.sistemas.models.Pedido;
import br.goHorse.sistemas.models.Usuario;


public class Venda {
	private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
	private Authenticate auth = new Authenticate();
	private Usuario userLogged;
	final static Scanner sc = new Scanner(System.in);
	public Venda(Usuario userLogged) {
		this.userLogged = userLogged;
	}

	public void novaVenda(){		
		if(auth.confirmacaoUsuario(this.userLogged)){
			System.out.println("NOVA VENDA: ");
			System.out.println("Digite a descricao do Pedido: ");
			String desc = sc.nextLine();
			System.out.println("Digite o valor do Pedido: ");			
			Double valor = Double.parseDouble(sc.nextLine());
			FormaPagamento fPagamento;
			while (true) {
				try {
					fPagamento = this.selectFormaPgto();	
					break;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Opção invalida! digite novamento a opção de pagamento");
				}		
			}
			
			Pedido pedido = new Pedido(this.geradorId(), desc, valor, fPagamento, EstadoPedido.REALIZADO);

			listaPedidos.add(pedido);
			System.out.println("Pedido Realizado");			
		}				
	}
	public void verificarPedidos() {
		System.out.println("LISTA DE PEDIDOS:");
		for (Pedido pedido : listaPedidos) {
			System.out.println(pedido);
		}
	}
	public void alterarPedido() {
		this.verificarPedidos();
		System.out.println("Digite o ID do pedido para altera-lo: ");
		String iD = sc.nextLine();
		
	}
	
	private FormaPagamento selectFormaPgto() throws ArrayIndexOutOfBoundsException{		
		System.out.println("FORMAS DE PAGAMENTO: ");
		for(int i = 1; i <= FormaPagamento.values().length; i++) {
			System.out.format("%d - %s\n", i, FormaPagamento.values()[i-1]);
		}
		int fPgto = Integer.parseInt(sc.nextLine());
		return FormaPagamento.values()[fPgto-1];
	}
	private EstadoPedido selectEstado() throws ArrayIndexOutOfBoundsException{		
		System.out.println("OPCOES DE ESTADOS DE PEDIDO: ");
		for(int i = 1; i <= EstadoPedido.values().length; i++) {
			System.out.format("%d - %s\n", i, EstadoPedido.values()[i-1]);
		}
		System.out.println("0 - Sair");		
		int estado = Integer.parseInt(sc.nextLine());
		if(estado == 0){
			return null;
		} 
		return EstadoPedido.values()[estado-1];
	}
	private String geradorId(){
		Random random = new Random();
		String idGerado = "";
		for(int i = 0; i < 3; i++){
			idGerado += random.nextInt(10);
		}
		return idGerado;
	}
}