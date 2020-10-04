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
        this.list = this.dao.getListDB(search);
        if (this.list.size() == 0) {
            this.list = this.dao.getListApi(search);
            saveListInDB();
        } 
        showList();
        
                      
    }
    private void saveListInDB(){
        for (AnimeModel animeModel : this.list) {
            this.dao.insertTable(animeModel);                   
        }  
    }
    
    private void showList(){
        for (AnimeModel animeModel : this.list) {
            System.out.println(animeModel);                     
        }  
    }
}
