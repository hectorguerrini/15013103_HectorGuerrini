package br.goHorse.sistemas;

import java.util.Scanner;

public class App {
	final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
		int menu;
		do {
			System.out.println("Pizzaria o Rato que Ri!");
			System.out.println("1 - Nova Venda");
			System.out.println("2 - Verificar pedidos");
			System.out.println("3 - Alterar Pedidos");
			System.out.println("0 - Sair");
			menu = sc.nextInt();
			switch (menu) {
				case 1:
					
					break;
			
				default:
					break;
			}
		} while (menu != 0);
		
    }
}
