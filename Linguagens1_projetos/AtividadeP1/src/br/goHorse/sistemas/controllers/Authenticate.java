package br.goHorse.sistemas.controllers;

import java.util.Scanner;

import br.goHorse.sistemas.interfaces.Auth;
import br.goHorse.sistemas.models.Usuario;

public class Authenticate implements Auth {
	final static Scanner sc = new Scanner(System.in);
	public boolean confirmacaoUsuario(Usuario user){
		
		System.out.println("Validação de Usuario.");
		System.out.println("Digite sua senha para continuar: ");
		String senha = sc.next();
		boolean valido = this.validarSenha(user, senha);		
		return valido;
	}
	@Override
	public boolean validarSenha(Usuario user, String senha) {
		if(user.getSenha().equals(senha)){
			System.out.println("Valido");
			return true;
		}
		System.out.println("Senha Invalida!");
		return false;
	}
	
}