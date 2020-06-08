package app.models;

import app.enums.Funcoes;
import app.enums.Horarios;


public class MobileMembers extends Membro {

    
    public MobileMembers(String email, String nome, Funcoes funcao) {
        super(email, nome, funcao);
        
    }
	
	@Override
	public void Apresentar() {
		System.out.println(this.toString());
		
	}

    @Override
    public void Mensagem(Horarios horario) {
        switch (horario) {
            case horaNormal:
                System.out.format("%s - HappyCoding!", this.getNome());
                break;
            case horaExtra:
                System.out.format("%s - Happy_C0d1ng. Maskers", this.getNome());
                break;
            default:
                break;
        }

    }
}