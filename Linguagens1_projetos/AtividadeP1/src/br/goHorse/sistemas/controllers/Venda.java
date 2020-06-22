package br.goHorse.sistemas.controllers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import br.goHorse.sistemas.enums.EstadoPedido;
import br.goHorse.sistemas.enums.FormaPagamento;
import br.goHorse.sistemas.exceptions.IDNotFoundException;
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
	/**
	 * Método para realizar uma nova venda no sistema.
	 */
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
					System.out.println("Opção invalida! digite novamente a opção de pagamento");
				}		
			}
			
			Pedido pedido = new Pedido(this.geradorId(), desc, valor, fPagamento, EstadoPedido.REALIZADO);

			listaPedidos.add(pedido);
			System.out.println("Pedido Realizado");			
		}				
	}
	/**
	 * Método para verifcar todos os pedidos
	 */
	public void verificarPedidos() {
		System.out.println("LISTA DE PEDIDOS:");
		for (Pedido pedido : listaPedidos) {
			System.out.println(pedido);
		}
	}
	/**
	 * Método para alterar um pedido que esteja na lista de pedidos.
	 */
	public void alterarPedido() {
		if(auth.confirmacaoUsuario(this.userLogged)){
			this.verificarPedidos();
			while (true) {
				try {
					System.out.println("Digite o ID do pedido para altera-lo: ");
					String iD = sc.nextLine();		
	
					Pedido selectPedido = this.getPedidoFromID(iD);
	
					System.out.println("Digite o Novo Estado do pedido: ");
					selectPedido.setEstadoPedido(selectEstado());
	
					System.out.println("Pedido alterado");
					System.out.println(selectPedido);
					break;
				} catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Opção invalida! digite novamente a opção de estado");
				} catch (IDNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (Exception e){
					System.out.println(e.getMessage());
					break;
				}
			}
		}				
	}
	
	
	/** 
	 * Método para selecionar as possíveis formas de pagamento.
	 * @return FormaPagamento
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private FormaPagamento selectFormaPgto() throws ArrayIndexOutOfBoundsException{		
		System.out.println("FORMAS DE PAGAMENTO: ");
		for(int i = 1; i <= FormaPagamento.values().length; i++) {
			System.out.format("%d - %s\n", i, FormaPagamento.values()[i-1]);
		}
		int fPgto = Integer.parseInt(sc.nextLine());
		return FormaPagamento.values()[fPgto-1];
	}
	
	/** 
	 * Método para selecionar os possíveis estados do pedido.
	 * @return EstadoPedido (REALIZADO, PREPARACAO, SAIU_PARA_ENTREGA, ENTREGUE, DEVOLVIDO)
	 * @throws Exception
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private EstadoPedido selectEstado() throws Exception, ArrayIndexOutOfBoundsException {
		System.out.println("OPCOES DE ESTADOS DE PEDIDO: ");
		for(int i = 1; i <= EstadoPedido.values().length; i++) {
			System.out.format("%d - %s\n", i, EstadoPedido.values()[i-1]);
		}
		System.out.println("0 - Sair");		
		int estado = Integer.parseInt(sc.nextLine());
		if(estado == 0){
			throw new Exception("Operacao Cancelada!");
		} 
		return EstadoPedido.values()[estado-1];
	}

	
	/** 
	 * Método para pegar o pedido a partir do ID na lista de pedidos.
	 * @param iD do pedido
	 * @return Pedido objeto do pedido
	 * @throws IDNotFoundException
	 */
	private Pedido getPedidoFromID(String iD) throws IDNotFoundException {
		for (Pedido pedido : listaPedidos) {
			if(pedido.getID().equals(iD)){
				return pedido;
			}
		}
		throw new IDNotFoundException("ID não encontrado");
	}

	
	/** 
	 * Método para gerar ID aleatorio de tamanho 3.
	 * @return String
	 */
	private String geradorId(){
		Random random = new Random();
		String idGerado = "";
		for(int i = 0; i < 3; i++){
			idGerado += random.nextInt(10);
		}
		return idGerado;
	}
}