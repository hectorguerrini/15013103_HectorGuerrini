package Atividade3.DAO;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Atividade3.models.AnimeModel;

public class AnimeDao {

    public AnimeDao() {

    }

    public List<AnimeModel> getListAnimes(String search) {
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

}
