package app;

import java.util.Scanner;

import app.controllers.MaskSociety;
import app.enums.Funcoes;
import app.enums.Horarios;
import app.models.BigBrothers;
import app.models.HeavyLifters;
import app.models.Membro;
import app.models.MobileMembers;
import app.models.ScriptGuys;
/**
 * Hector Guerrini Herrera 15.01310-3
 * André Shpaisman 16.00507-4
 */
public class App {
    final static Scanner sc = new Scanner(System.in);
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        MaskSociety society = new MaskSociety(Horarios.horaNormal);
        System.out.println("Bem Vindo");
        boolean run = true;
        while(run){
            System.out.println("MENU DE OPÇÕES:\nPressione:");
            System.out.println("1- Cadastrar novo membro");
            System.out.println("2- Apresentação dos membros cadastrados");
            System.out.println("3- Excluir um membro");
            System.out.println("4- Trocar jornada de trabalho");
            System.out.println("5- Postar mensagem");
            System.out.println("0- Sair do sistema");
            System.out.println("Jornada de trabalho atual: " + society.getHorarioTrabalho());
            int menu = sc.nextInt();
            
            switch (menu) {
                case 1:
                    Membro m = menuCadastroMembro();
                    if (m != null){
                        society.cadastrarMembro(m);
                    }                    
                    break;
                case 2:
                    society.ApresentarMembros();
                    break;
                case 3:
                    if (society.getListaMembros().size() > 0) {
                        for (int i = 0; i < society.getListaMembros().size(); i++) {
                            System.out.format("%d - %s - %s\n", i, society.getListaMembros().get(i).getNome(),society.getListaMembros().get(i).getFuncao() );
                        }
                        System.out.println("Digite o Id do Usuario a ser excluido: ");
                        int index = sc.nextInt();
                        society.excluirMembro(society.getListaMembros().get(index));
                    } else {
                        System.out.println("Nenhum Usuario cadastrado");
                    }
                    break;
                case 4:
                    society.trocarHorarioTrabalho();
                    break;
                case 5:
                    society.PostarMensagem();
                    break;
                case 0:   
                    run = false;
                    break;
                default:
                    break;
            }
            System.out.println();
            
        }
        
    }
    
    /** 
     * @return Membro
     */
    public static Membro menuCadastroMembro() {
        System.out.println("Menu Cadastro de Membros:");
        
        System.out.println("1- Mobile Members");
        System.out.println("2- Heavy Lifters");
        System.out.println("3- Script Guys");
        System.out.println("4- Big Brothers");
        System.out.println("0- Exit");
        int menuMembro = sc.nextInt();
        System.out.print("Digite o nome: ");
        String nome = sc.next();
        System.out.print("Digite o email: ");
        String email = sc.next();
        switch (menuMembro) {
            case 1:
                return new MobileMembers(email, nome, Funcoes.MobileMembers);                 
            case 2:
                return new HeavyLifters(email, nome, Funcoes.HeavyLifters);                
            case 3:
                return new ScriptGuys(email, nome, Funcoes.ScriptGuys);                
            case 4:
                return new BigBrothers(email, nome, Funcoes.BigBrothers);
                
            case 0:
                return null;
            default:
                return null;                
        }        
        
    }
    
}

