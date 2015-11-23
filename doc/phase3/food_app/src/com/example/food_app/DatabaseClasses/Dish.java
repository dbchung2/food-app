package com.example.food_app.DatabaseClasses;

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

    public Dish(String did, String rid, String dishName, String category, Double price){
        this.rid = rid;
        this.did = did;
        this.dishName = dishName;
        this.category = category;
        this.price = price;
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
