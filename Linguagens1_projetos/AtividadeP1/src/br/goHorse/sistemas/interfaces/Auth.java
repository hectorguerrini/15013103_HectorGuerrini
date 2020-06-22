package br.goHorse.sistemas.interfaces;

import br.goHorse.sistemas.models.Usuario;

public interface Auth {

	abstract public boolean validarSenha(Usuario user, String senha); 
}