package Atividade3.controllers;

import java.util.List;

import Atividade3.DAO.AnimeDao;
import Atividade3.interfaces.IController;
import Atividade3.models.AnimeModel;

public class AnimeController implements IController {
    private AnimeDao dao;
    private List<AnimeModel> list;
    
    public AnimeController() {
        this.dao = new AnimeDao();        
    }
    

    
    /** 
     * Função para retornar a lista de animes por titulo
     * @param search Variavel de pesquisa de animes por titulo
     */
    @Override
    public void get(String search) {
        this.list = this.dao.getListDB(search);
        if (this.list.size() == 0) {
            this.list = this.dao.getListApi(search);
            saveListInDB();
        } 
        showList();
    }

    @Override
    public void saveListInDB() {
        for (AnimeModel animeModel : this.list) {
            this.dao.insertTable(animeModel);                   
        }  
    }

    @Override
    public void showList() {
        for (AnimeModel animeModel : this.list) {
            System.out.println(animeModel);                     
        }  
    }
}
