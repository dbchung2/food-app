package com.example.food_app.DatabaseClasses;

import java.io.Serializable;

/**
 * Created by Matt on 2015-11-01.
 */
public class Review implements Serializable{
    String username;
    String did;
    String desc;
    String rating;
    String category;
    String price;
    public Review(String username, String did, String desc, String rating, String price) {
        this.username = username;
        this.did = did;
        this.desc = desc;
        this.rating = rating;
        this.price = price;
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
