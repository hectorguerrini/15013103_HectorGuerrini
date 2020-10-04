package Atividade3.interfaces;

import java.util.List;

public interface IDAO <T>{
    List<T> getListDB(String search);
    void createDB(T t);
    List<T> getListApi(String search);
    
}
