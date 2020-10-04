package Atividade3.controllers;

import java.util.List;

import Atividade3.DAO.AnimeDao;
import Atividade3.models.AnimeModel;

public class AnimeController {
    private AnimeDao dao;
    private List<AnimeModel> list;
    
    public AnimeController() {
        this.dao = new AnimeDao();        
    }
 
    public void getAnimes(String search){
        this.list = this.dao.getListApi(search);
        for (AnimeModel animeModel : list) {
            System.out.println(animeModel);
        }
        
    }
}
