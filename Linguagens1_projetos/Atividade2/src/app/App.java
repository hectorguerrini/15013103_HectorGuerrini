package app;

import java.util.Scanner;

import app.enums.Horarios;
import app.models.MaskSociety;
import app.models.Membro;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
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

                    
                    break;
            
                default:
                    break;
            }
        }
    }
    public static Membro menuCadastroMembro() {
        return null;
        
    }
}

//Cadastrar novo membro
//apresentacao dos membros cadastrados
//Excluir um membro
//trocar jornada de trabalho
//postar msg
//Sair do sistema
