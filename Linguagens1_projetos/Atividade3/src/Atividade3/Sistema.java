package Atividade3;

import Atividade3.controllers.AnimeController;

public class Sistema {
    private AnimeController animeController;

    public Sistema() {
        animeController = new AnimeController();
    }

    public void run() {
        
        animeController.getAnimes("overlord");
        
    }

    
}
