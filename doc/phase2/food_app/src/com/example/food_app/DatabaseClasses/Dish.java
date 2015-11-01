package com.example.food_app.DatabaseClasses;

/**
 * Created by Matt on 2015-11-01.
 */
public class Dish {
    String rid;
    String did;
    String dishName;
    String avgRating;
    String image;
    public Dish(String rid, String did, String dishName, String avgRating){
        this.rid = rid;
        this.did = did;
        this.dishName = dishName;
        this.avgRating = avgRating;
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
