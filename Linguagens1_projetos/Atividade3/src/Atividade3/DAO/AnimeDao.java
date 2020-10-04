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
import Atividade3.models.AnimeModel;

public class AnimeDao implements IDAO<AnimeModel>,IDAOFields {

    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:db/atividade.db";

    public AnimeDao() {
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<AnimeModel> getListDB(String search) {
        List<AnimeModel> list = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + "title LIKE '%"+search+"%'");
            while(result.next()){
                AnimeModel anime = new AnimeModel(
                        result.getString("title"),
                        result.getString("image_url"),
                        result.getString("synopsis"),
                        result.getInt("episodes"),
                        result.getDouble("score")
                );
                list.add(anime);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void insertTable(AnimeModel anime) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, anime.getTitle());
            preparedStatement.setString(2, anime.getImage_url());
            preparedStatement.setString(3, anime.getSynopsis());
            preparedStatement.setInt(4, anime.getEpisodes());
            preparedStatement.setDouble(5, anime.getScore());
            int retorno = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AnimeModel> getListApi(String search) {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://api.jikan.moe/v3/search/anime?q="+search)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code:" + response.statusCode());
                   
            JSONObject meuJson = new JSONObject(response.body());
            JSONArray array = meuJson.getJSONArray("results");
            return AnimeModel.fromJsonArray(array);
        } catch (Exception e) {
            return new ArrayList<AnimeModel>();          
        }
    }

    @Override
    public String getTableName() {
        return "animes";
    }

    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (title, image_url, synopsis, episodes, score) VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }

  
}
