package br.goHorse.sistemas.controllers;

import java.text.Normalizer.Form;
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

	public Venda(Usuario userLogged) {
		this.userLogged = userLogged;
	}

	public void novaVenda(){		
		if(auth.confirmacaoUsuario(this.userLogged)){
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite a descricao do Pedido: ");
			String desc = sc.next();
			System.out.println("Digite o valor do Pedido: ");
			Double valor = sc.nextDouble();			
			FormaPagamento fPagamento = this.selectFormaPgto();			
			Pedido pedido = new Pedido(this.geradorId(), desc, valor, fPagamento, EstadoPedido.REALIZADO);

			listaPedidos.add(pedido);
			System.out.println("Pedido Realizado");
			sc.close();
		}				
	}

	private FormaPagamento selectFormaPgto() {
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= FormaPagamento.values().length; i++) {
			System.out.format("%i - %s", i, FormaPagamento.values()[i]);
		}
		int fPgto = sc.nextInt();
		sc.close();
		return FormaPagamento.values()[fPgto-1];
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