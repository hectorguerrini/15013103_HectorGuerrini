package Atividade3;

import java.util.Scanner;

import Atividade3.controllers.AnimeController;

public class Sistema {
    private AnimeController animeController;
    private Scanner scanner;

    public Sistema() {
        animeController = new AnimeController();
        scanner = new Scanner(System.in);
    }

    public void run() {
        
        
        boolean alive = true;
        do{
            menu();
            int opcao = Integer.parseInt(scanner.next());
            switch (opcao){
                case 0:
                    alive = false;
                    break;
                case 1:
                    animeController.getAnimes("naruto");
                    break;
                case 2:
                    
                    break;            
                default:
                    System.out.println("Opcao Invalida!");
            }

        }while(alive);
    }

    private void menu() {
        System.out.println("LISTA ANIMES E MANGAS");
        System.out.println("1 - Procurar Animes");
        System.out.println("2 - Procurar Mangas");        
        System.out.println("0 - Sair");
    }
    
}
