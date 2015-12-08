package com.example.food_app.DatabaseClasses;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Matt on 2015-11-01.
 */
public class Dish implements Serializable {
    String rid;
    String did;
    String dishName;
    String avgRating;
    String category;
    Double price;
    byte[] img;
    public Dish(String did, String rid, String dishName, String category, Double price, byte[] img){
        this.rid = rid;
        this.did = did;
        this.dishName = dishName;
        this.category = category;
        this.price = price;
        this.img = img;
    }
    public String getCategory(){
        return category;
    }
    public Double getPrice(){
        return price;
    }
    public String getRid() {
        return rid;
    }
    public byte[] getImg(){
        return img;
    }
    public String getDid() {
        return did;
    }

    public String getDishName() {
        return dishName;
    }


    public String getAvgRating() {
        return avgRating;
    }
}
