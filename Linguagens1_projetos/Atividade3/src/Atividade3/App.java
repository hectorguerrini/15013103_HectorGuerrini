package Atividade3;

import Atividade3.controllers.AnimeController;

public class App {
    public static void main(String[] args) throws Exception {
        AnimeController controller = new AnimeController();
        controller.getAnimes();
    }
}
