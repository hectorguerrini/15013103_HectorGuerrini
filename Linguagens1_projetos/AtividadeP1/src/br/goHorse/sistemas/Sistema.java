package br.goHorse.sistemas;

import java.util.Scanner;

import br.goHorse.sistemas.controllers.Venda;
import br.goHorse.sistemas.models.Usuario;

public class Sistema {
	final static Scanner sc = new Scanner(System.in);
	public static void run() {
		int menu;
		Usuario user = new Usuario("Usuario de Teste", "teste@user.com", "123456");
		Venda sistemaVendas = new Venda(user);
		
		do {
			System.out.println("Pizzaria o Rato que Ri!");
			System.out.println("1 - Nova Venda");
			System.out.println("2 - Verificar pedidos");
			System.out.println("3 - Alterar Pedidos");
			System.out.println("0 - Sair");
			menu = sc.nextInt();
			switch (menu) {
				case 1:										
					sistemaVendas.novaVenda();
					break;
				case 2:
					sistemaVendas.verificarPedidos();
					break;
				case 3:
					sistemaVendas.alterarPedido();
					break;
				default:
					break;
			}
			System.out.println();
		} while (menu != 0);
		System.out.println("Obrigado Por utilizar o Sistema da goHorse!");
	}
}