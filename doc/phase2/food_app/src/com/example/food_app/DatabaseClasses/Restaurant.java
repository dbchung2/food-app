package com.example.food_app.DatabaseClasses;

/**
 * Created by Matt on 2015-11-01.
 */
public class Restaurant {
    String rname;
    String rid;
    String address;
    String postalCode;
    public Restaurant(String rid, String rname, String address, String postalCode){
        this.rid = rid;
        this.rname = rname;
        this.address = address;
        this.postalCode = postalCode;
    }

    public String getRname() {
        return rname;
    }
    public String getRid(){
        return rid;
    }
    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
