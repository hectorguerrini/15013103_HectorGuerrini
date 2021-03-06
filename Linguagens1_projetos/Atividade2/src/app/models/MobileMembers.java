package app.models;

import app.enums.Funcoes;
import app.enums.Horarios;


public class MobileMembers extends Membro {

    
    public MobileMembers(String email, String nome, Funcoes funcao) {
        super(email, nome, funcao);
        
    }
    
    
    /** 
     * @param horario
     */
    @Override
    public void Mensagem(Horarios horario) {
        switch (horario) {
            case horaNormal:
                System.out.format("%s - Happy  Coding!\n", this.getNome());
                break;
            case horaExtra:
                System.out.format("%s - Happy_C0d1ng. Maskers\n", this.getNome());
                break;
            default:
                break;
        }
    }

	@Override
	public void Apresentar() {
		System.out.println(this.toString());		
	}

    
}