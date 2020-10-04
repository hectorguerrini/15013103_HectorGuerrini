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

    
    
    /** 
     * @param json
     * @return AnimeModel
     */
    public static AnimeModel fromJson(JSONObject json) {        
        return new AnimeModel(
                json.getString("title"),
                json.getString("image_url"),
                json.getString("synopsis"),
                json.getInt("episodes"),
                json.getDouble("score")
        );        
    }

    
    /** 
     * @param json
     * @return List<AnimeModel>
     */
    public static List<AnimeModel> fromJsonArray(JSONArray json) {                
        List<AnimeModel> animes = new ArrayList<>();
        for (Object anime :
        json) {
            animes.add(fromJson((JSONObject) anime));
        }
        return animes;
    }


    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "AnimeModel { \ntitle= " + title + ",\n image_url= " + image_url + ",\n score= " + score + ",\n synopsis= "
                + synopsis + ",\n episodes= " + episodes
                 + "\n}";
    }

    
    /** 
     * @return String
     */
    public String getTitle() {
        return title;
    }

    
    /** 
     * @return String
     */
    public String getImage_url() {
        return image_url;
    }

    
    /** 
     * @return String
     */
    public String getSynopsis() {
        return synopsis;
    }

    
    /** 
     * @return int
     */
    public int getEpisodes() {
        return episodes;
    }

    
    /** 
     * @return double
     */
    public double getScore() {
        return score;
    }

   
}
