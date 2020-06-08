package app.models;

import app.enums.Funcoes;


public class MobileMembers extends Membro {

    
    public MobileMembers(String email, String nome, Funcoes funcao) {
        super(email, nome, funcao);
        
    }
    @Override
    public void PostarMensagem() {
        
    }
    @Override
    public void Apresentação() {
        
    }
}