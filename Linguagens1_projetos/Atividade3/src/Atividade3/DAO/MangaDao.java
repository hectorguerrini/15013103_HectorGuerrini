package Atividade3.DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Atividade3.interfaces.IDAO;
import Atividade3.interfaces.IDAOFields;
import Atividade3.models.MangaModel;

public class MangaDao implements IDAO<MangaModel>, IDAOFields {

    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:db/atividade.db";

    public MangaDao() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    
    /** 
     * @return String
     */
    @Override
    public String getTableName() {        
        return "mangas";
    }

    
    /** 
     * @param table
     * @return String
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (title, image_url, synopsis, chapters, volumes, type, score) VALUES (?, ?, ?, ?, ?, ?, ?);";
    }

    
    /** 
     * @param table
     * @return String
     */
    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }

    
    /** 
     * @param search
     * @return List<MangaModel>
     */
    @Override
    public List<MangaModel> getListDB(String search) {
        List<MangaModel> list = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + "title LIKE '%"+search+"%'");
            while(result.next()){
                MangaModel manga = new MangaModel(
                        result.getString("title"),
                        result.getString("image_url"),
                        result.getString("synopsis"),
                        result.getInt("chapters"),
                        result.getInt("volumes"),
                        result.getString("type"),
                        result.getDouble("score")
                );
                list.add(manga);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    
    /** 
     * @param manga
     */
    @Override
    public void insertTable(MangaModel manga) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, manga.getTitle());
            preparedStatement.setString(2, manga.getImage_url());
            preparedStatement.setString(3, manga.getSynopsis());
            preparedStatement.setInt(4, manga.getChapters());
            preparedStatement.setInt(5, manga.getVolumes());
            preparedStatement.setString(6, manga.getType());
            preparedStatement.setDouble(7, manga.getScore());
            int retorno = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
    /** 
     * @param search
     * @return List<MangaModel>
     */
    @Override
    public List<MangaModel> getListApi(String search) {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://api.jikan.moe/v3/search/manga?q="+search)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code:" + response.statusCode());
                   
            JSONObject meuJson = new JSONObject(response.body());
            JSONArray array = meuJson.getJSONArray("results");
            return MangaModel.fromJsonArray(array);
        } catch (Exception e) {
            return new ArrayList<MangaModel>();          
        }
    }
    
}
