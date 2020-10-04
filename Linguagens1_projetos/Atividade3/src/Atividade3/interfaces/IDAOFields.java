package Atividade3.interfaces;

public interface IDAOFields {

    String getTableName();
    String getInsertString(String table);
    String getSelectConditionalString(String table);
}