package com.example.food_app.DatabaseClasses;

/**
 * Created by Matt on 2015-11-01.
 */
public class Review {
    String username;
    String did;
    String desc;
    String rating;
    String category;
    public Review(String username, String did, String desc, String rating, String category){
        this.username = username;
        this.did = did;
        this.desc = desc;
        this.rating = rating;
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
    public String getUsername() {
        return username;
    }

    public String getDid() {
        return did;
    }

    public String getDesc() {
        return desc;
    }

    public String getRating() {
        return rating;
    }
}
