package Atividade3.controllers;

import java.util.List;

import Atividade3.DAO.MangaDao;
import Atividade3.interfaces.IController;
import Atividade3.models.MangaModel;

public class MangaController implements IController{
    private MangaDao dao;
    private List<MangaModel> list;

    public MangaController() {
        this.dao = new MangaDao();
    }

    
    /** 
     * @param search
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
        for (MangaModel animeModel : this.list) {
            this.dao.insertTable(animeModel);                   
        }  
    }

    @Override
    public void showList() {
        for (MangaModel animeModel : this.list) {
            System.out.println(animeModel);                     
        }  
    }
}
