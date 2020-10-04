package Atividade3;

import java.util.Scanner;

import Atividade3.controllers.AnimeController;
import Atividade3.controllers.MangaController;
import Atividade3.interfaces.IController;

public class Sistema {
    private IController animeController;
    private IController mangaController;
    private Scanner sc;

    public Sistema() {
        animeController = new AnimeController();
        mangaController = new MangaController();
        sc = new Scanner(System.in);
    }

    public void run() {
        
        
        boolean alive = true;
        do{
            menu();
            int opcao = Integer.parseInt(sc.next());
            String search;
            System.out.println("Pesquisar: ");
            switch (opcao){
                case 0:
                    alive = false;
                    break;
                case 1:
                    search = sc.next();
                    animeController.get(search);
                    break;
                case 2:
                    search = sc.next();
                    mangaController.get(search);
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
