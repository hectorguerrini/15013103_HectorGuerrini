package app;

import java.util.Scanner;

import app.enums.Horarios;
import app.models.MaskSociety;
import app.models.Membro;

public class App {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        MaskSociety society = new MaskSociety(Horarios.horaNormal);
        while(true){
            System.out.println("Bem Vindo\nMENU DE OPÇÕES:\nPressione:");
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
                    society.cadastrarMembro(menuCadastroMembro());        
                    break;
                case 2:
                    
                    break;
                case 3:
                    society.excluirMembro(menuCadastroMembro());
                    break;
                case 4:
                    society.trocarHorarioTrabalho();
                    break;
                case 5:

                    break;
                case 0:
                    break;
                default:
                    break;
            }
            
        }
        
    }
    public static Membro menuCadastroMembro() {
        System.out.println("1- Mobile Members");
        System.out.println("2- Heavy Lifters");
        System.out.println("3- Script Guys");
        System.out.println("4- Big Brothers");
        System.out.println("0- Exit");
        int menuMembro = sc.nextInt();
        switch (menuMembro) {
            case 1:
                
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 0:
            
                break;
            default:
                break;
        }
        return null;
        
    }
    
}

