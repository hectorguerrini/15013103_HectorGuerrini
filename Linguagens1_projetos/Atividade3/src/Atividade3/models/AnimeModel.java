package Atividade3.models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
public class AnimeModel {
    private String title; 
    private String image_url;
    private String synopsis;
    private int episodes;
    private double score;
        
    
    public AnimeModel(String title, String image_url, String synopsis, int episodes, double score) {
        this.title = title;
        this.image_url = image_url;
        this.synopsis = synopsis;
        this.episodes = episodes;
        this.score = score;
    }

    
    public static AnimeModel fromJson(JSONObject json) {
        
        return new AnimeModel(
                json.getString("title"),
                json.getString("image_url"),
                json.getString("synopsis"),
                json.getInt("episodes"),
                json.getDouble("score")
        );        
    }

    public static List<AnimeModel> fromJsonArray(String json) {
        
        JSONArray array = new JSONArray(json);
        List<AnimeModel> animes = new ArrayList<>();
        for (Object anime :
        array) {
            animes.add(fromJson((JSONObject) anime));
        }
        return animes;
    }

    @Override
    public String toString() {
        return "AnimeModel { episodes=" + episodes + ", image_url=" + image_url + ", score=" + score + ", synopsis="
                + synopsis + ", title=" + title + "}";
    }
}
