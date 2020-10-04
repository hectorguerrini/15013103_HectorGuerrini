package Atividade3.models;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class MangaModel {
    private String title; 
    private String image_url;
    private String synopsis;
    private int chapters;
    private int volumes;
    private String type;
    private double score;

    public MangaModel(String title, String image_url, String synopsis, int chapters, int volumes, String type,
            double score) {
        this.title = title;
        this.image_url = image_url;
        this.synopsis = synopsis;
        this.chapters = chapters;
        this.volumes = volumes;
        this.type = type;
        this.score = score;
    }

    public static MangaModel fromJson(JSONObject json) {        
        return new MangaModel(
                json.getString("title"),
                json.getString("image_url"),
                json.getString("synopsis"),
                json.getInt("chapters"),
                json.getInt("volumes"),
                json.getString("type"),
                json.getDouble("score")
        );        
    }

    public static List<MangaModel> fromJsonArray(JSONArray json) {                
        List<MangaModel> mangas = new ArrayList<>();
        for (Object manga :
        json) {
            mangas.add(fromJson((JSONObject) manga));
        }
        return mangas;
    }



    public String getTitle() {
        return title;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getChapters() {
        return chapters;
    }

    public int getVolumes() {
        return volumes;
    }

    public String getType() {
        return type;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "MangaModel [title=" + title + ", image_url=" + image_url + ", score=" + score + ", synopsis="
                + synopsis + ", chapters=" + chapters + ", type=" + type + ", volumes=" + volumes + "]";
    }

        
}
