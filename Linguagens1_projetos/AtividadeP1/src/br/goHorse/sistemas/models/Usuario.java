package br.goHorse.sistemas.models;

public class Usuario {
	private String nome;
	private String email;
	private String senha;

	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	/** 
	 * @return String
	 */
	public String getSenha() {
		return senha;
	}

	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Usuario{ "+ "email=" + email + ", nome=" + nome + ", senha=" + senha + " }";
	}

	
}