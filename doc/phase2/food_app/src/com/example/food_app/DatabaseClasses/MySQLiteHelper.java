package com.example.food_app.DatabaseClasses;


 
import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class MySQLiteHelper extends SQLiteOpenHelper {

   // Database Version
   private static final int DATABASE_VERSION = 1;
   // Database Name
   private static final String DATABASE_NAME = "FoodDB";
    
   public MySQLiteHelper(Context context) {
       super(context, DATABASE_NAME, null, DATABASE_VERSION);  
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
       // SQL statement to create book table
       String CREATE_USER_TABLE = "CREATE TABLE user ( " +
               "username varchar(255) PRIMARY KEY, " + 
    		   "firstname varchar(255)," +
               "lastname varchar(255)," +
               "password varchar(255))";
       
       String CREATE_RESTO_TABLE= "CREATE TABLE restaurant ( " +
               "rid INTEGER PRIMARY KEY AUTOINCREMENT, " + 
               "rname varchar(255)," +
               "address varchar(255)," +
               "postalCode varchar(255))";

       String CREATE_REVIEW_TABLE = "CREATE TABLE review ( " +
               "username varchar(255), " +
           "did INTEGER," +
               "desc TEXT," +
               "rating INTEGER," +
                "price varchar(255),"+
               "FOREIGN KEY(username) REFERENCES user(username),"+
               "FOREIGN KEY(did) REFERENCES user(did),"+
               "PRIMARY KEY(username, did))";
       String CREATE_WISHLIST_TABLE = "CREATE TABLE wishlist ( " +
               "username INTEGER, " + 
    		   "did INTEGER,"+
               "FOREIGN KEY(username) REFERENCES user(username),"+
               "FOREIGN KEY(did) REFERENCES user(did),"+
               "PRIMARY KEY(did, username))";
       String CREATE_DISH_TABLE = "CREATE TABLE dish ( " +
    		   "did INTEGER PRIMARY KEY, " +
    		   "rid INTEGER, " +
    		   "dishName varchar(255)," +
           "category varchar(255)," +
           "price DOUBLE," +
           "avgRating INTEGER CHECK(avgRating <= 5))";
       String CREATE_SPENT_TABLE = "CREATE TABLE spent ( " +
           "username varchar(255), "+
           "did INTEGER, "+
           "datetime DATETIME , "+
           "category varchar(255), " +
           "price DOUBLE, " +
           "FOREIGN KEY(username) REFERENCES user(username),"+
           "FOREIGN KEY(did) REFERENCES user(did),"+
           "PRIMARY KEY(datetime))";




       db.execSQL(CREATE_SPENT_TABLE);
       db.execSQL(CREATE_USER_TABLE);
       db.execSQL(CREATE_RESTO_TABLE);
       db.execSQL(CREATE_REVIEW_TABLE);
       db.execSQL(CREATE_WISHLIST_TABLE);
       db.execSQL(CREATE_DISH_TABLE);


   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS user");
       db.execSQL("DROP TABLE IF EXISTS restaurant");
       db.execSQL("DROP TABLE IF EXISTS review");
       db.execSQL("DROP TABLE IF EXISTS wishlist");
       db.execSQL("DROP TABLE IF EXISTS dish");

       this.onCreate(db);
   }
   public void addUser(String uname, String pwd,
		   String first, String last){
       SQLiteDatabase database = this.getWritableDatabase();
       
       ContentValues values = new ContentValues();
       values.put("username", uname); 
       values.put("password", pwd); 
       values.put("firstname", first); 
       values.put("lastname", last); 
       
       database.insert("user", // table
               null, //nullColumnHack
               values);
       database.close();
	   
   }
   public void addSpent (String username, String did, String datetime, String category, Double price){
       //yyyy-MM-dd HH:mm:ss
       SQLiteDatabase database = this.getWritableDatabase();

       ContentValues values = new ContentValues();
       values.put("username", username);
       values.put("did", did);
       values.put("datetime", datetime);
       values.put("category", category);
       values.put("price", price);
       database.insert("spent", // table
           null, //nullColumnHack
           values);
       database.close();
   }
   public ArrayList<String> getSpentTitles(String username){
       SQLiteDatabase database = this.getWritableDatabase();
       ArrayList<String> result = new ArrayList<String>();

       Cursor cursor = database.rawQuery("select category, sum(price) from spent where username = "+username+" group by category", null);
       if ((cursor != null) && (cursor.getCount() > 0)) {
           cursor.moveToFirst();
       }
       else if(cursor==null){
           return null;
       }
       int i=0;
       while(i < cursor.getCount()){
           result.add("Category: "+cursor.getString(0)+"    Total spent: $"+cursor.getDouble(1));
           cursor.moveToNext();
           i++;
       }
       return result;
   }
    public ArrayList<String> getSpentByCategory(String username, String cat){
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<String> result = new ArrayList<String>();

        Cursor cursor = database.rawQuery("select did, sum(price) from spent where username = "+username+ " group by did", null);


        if ((cursor != null) && (cursor.getCount() > 0)) {
            cursor.moveToFirst();
        }
        else if(cursor==null){
            return null;
        }
        int i=0;
        while(i < cursor.getCount()){
            result.add("Category: "+cursor.getString(0)+"    Total spent: $"+cursor.getDouble(1));
            cursor.moveToNext();
            i++;
        }
        return result;
    }
   public User getUser(String username){
	   String[] columns = {"username", "password", "firstname", "lastname"};
	  
	   // 1. get reference to readable DB
	    SQLiteDatabase db = this.getReadableDatabase();
	
	    // 2. build query
	    Cursor cursor = 
	            db.query("user", // a. table
	            columns, // b. column names
	            " username = ?", // c. selections 
	            new String[] { username }, // d. selections args
	            null, // e. group by
	            null, // f. having
	            null, // g. order by
	            null); // h. limit
	    
	    if ((cursor != null) && (cursor.getCount() > 0)) {
	    	cursor.moveToFirst();
	    	return new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
	    }
	    return null;
   }
   
   public void addRestaurant(String rname, String address, String postalCode){
	   SQLiteDatabase database = this.getWritableDatabase();
       
       ContentValues values = new ContentValues();
       values.put("rname", rname); 
       values.put("address", address); 
       values.put("postalCode", postalCode); 
       
       database.insert("restaurant", // table
               null, //nullColumnHack
               values);
       database.close();
   }
   
   public Restaurant getRestaurant(String rid){
	   String[] columns = {"rid", "rname", "address", "postalCode"};
	  
	   // 1. get reference to readable DB
	    SQLiteDatabase db = this.getReadableDatabase();
	
	    // 2. build query
	    Cursor cursor = 
	            db.query("restaurant", // a. table
	            columns, // b. column names
	            " rid = ?", // c. selections 
	            new String[] { (rid) }, // d. selections args
	            null, // e. group by
	            null, // f. having
	            null, // g. order by
	            null); // h. limit
	    
	    // 3. if we got results get the first one
	    if (cursor != null)
	        cursor.moveToFirst();

       Restaurant restaurant = new Restaurant(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
       return restaurant;
   }
   
   public void addWishlist(String did, String username){
 SQLiteDatabase database = this.getWritableDatabase();
       
       ContentValues values = new ContentValues();
       values.put("username", username); 
       values.put("did", did); 

       database.insert("wishlist", // table
               null, //nullColumnHack
               values);
       database.close();
   }
    
   public Float getAvgRating(String did){
       ArrayList<String> ratings = rawQuery("select rating from review where did = "+did);
       float result=0;
       for(String rating: ratings){
           result+= Float.parseFloat(rating);
       }
       result = result/ratings.size();
       return result;
   }

   public ArrayList<String> getWishlistIds(String username){
	   String[] columns = {"username", "did"};
	   ArrayList<String> dishIDs = new ArrayList<String>();
	   // 1. get reference to readable DB
	    SQLiteDatabase db = this.getReadableDatabase();
	
	    // 2. build query
	    Cursor cursor = 
	            db.query("wishlist", // a. table
	            columns, // b. column names
	            " username = ?", // c. selections 
	            new String[] { (username) }, // d. selections args
	            null, // e. group by
	            null, // f. having
	            null, // g. order by
	            null); // h. limit
	    
	    // 3. if we got results get the first one

       if ((cursor != null) && (cursor.getCount() > 0)) {
           cursor.moveToFirst();
       }
       else if(cursor==null){
          return null;
      }
        int i=0;
	    while(i < cursor.getCount()){
	    	dishIDs.add(cursor.getString(1));
          cursor.moveToNext();
	    	i++;
	    }
	    return dishIDs;
   }
   public ArrayList<Dish> convertIdsToDish(ArrayList<String> dishIds){
       ArrayList<Dish> allDishes = new ArrayList<Dish>();
       for(String id : dishIds){
           allDishes.add(getDish("", id));
       }
       return allDishes;
   }
    public ArrayList<String> convertIdsToNames(ArrayList<String> dishIds){
        ArrayList<String> allDisheNames = new ArrayList<String>();
        for(String id : dishIds){
            allDisheNames.add(getDish("", id).getDishName());
        }
        return allDisheNames;
    }
    public void removeFromWishlist(String username, String did){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete("wishlist", "username = ? AND did = ?", new String[]{username, did});

    }
    public void addDish(String rid, String dishName, String category, Double price){
        SQLiteDatabase database = this.getWritableDatabase();

        
        ContentValues values = new ContentValues();
        values.put("rid", rid); 
        values.put("dishName", dishName);
        values.put("category", category);
        values.put("price", price);

        //Later on we will update the avg rating based on reviews instead of initializing it to 0
        values.put("avgRating", 0);

        database.insert("dish", // table
                null, //nullColumnHack
                values);
        database.close();
    }
    public Dish getDish(String rid, String did) {
        String[] columns = {"did", "rid", "dishName", "avgRating"};
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor = db.query("dish", // a. table
            columns, // b. column names
            "did = ?", // c. selections
            new String[] {did}, // d. selections args
            null, // e. group by
            null, // f. having
            null, // g. order by
            null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        Dish dish = new Dish(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getDouble(
            4));
        return dish;
    }

    public void addReview(String username, String did, String desc, String rating, String price){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("did", did);
        values.put("desc", desc);
        values.put("rating", rating);
        values.put("price", price);
        database.insert("review", // table
            null, //nullColumnHack
            values);
        database.close();
    }
    public Review getReview(String username, String did) {
        String[] columns = {"username", "did", "desc", "rating"};
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor = db.query("review", // a. table
            columns, // b. column names
            " username = ? AND did = ?", // c. selections
            new String[] {username, did}, // d. selections args
            null, // e. group by
            null, // f. having
            null, // g. order by
            null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        Review review = new Review(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        return review;
        }

    public ArrayList<Restaurant> getAllRestaurants(){
        String[] columns = {"rid", "rname", "address", "postalCode"};
        ArrayList<Restaurant> allRestaurants = new ArrayList<Restaurant>();
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor  cursor = db.rawQuery("select * from restaurant", null);

        // 3. if we got results get the first one

        if ((cursor != null) && (cursor.getCount() > 0)) {
            cursor.moveToFirst();
        }
        else if(cursor==null){
            return null;
        }
        int i=0;
        while(i < cursor.getCount()){

            Restaurant temp = new Restaurant(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            allRestaurants.add(temp);
            cursor.moveToNext();
            i++;
        }
        return allRestaurants;
    }

    public ArrayList<Dish>  getRestaurantDishes(String rid) {
        ArrayList<Dish> restaurantDishes = new ArrayList<Dish>();

        String[] columns = {"rid", "did", "dishName", "avgRating"};

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
        // 2. build query
        Cursor  cursor = db.rawQuery("select * from dish where rid = "+rid, null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();


        int i=0;
        while(i < cursor.getCount()){
            Dish temp = new Dish(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getDouble(
                4));
            restaurantDishes.add(temp);
            cursor.moveToNext();
            i++;
        }
        return restaurantDishes;
    }
    public ArrayList<Review>  getDishReviews(String did) {
        ArrayList<Review> restaurantDishes = new ArrayList<Review>();


        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
        // 2. build query
        Cursor  cursor = db.rawQuery("select * from review where did = "+did, null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();


        int i=0;
        while(i < cursor.getCount()){
            Review temp = new Review(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            restaurantDishes.add(temp);
            cursor.moveToNext();
            i++;
        }
        return restaurantDishes;
    }
    public ArrayList<Review> getAllReviews() {
        ArrayList<Review> allReviews = new ArrayList<Review>();
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor = db.rawQuery("select * from review", null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        int i=0;
        while(i < cursor.getCount()){
            Review temp = new Review(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            allReviews.add(temp);
            cursor.moveToNext();
            i++;
        }
        return allReviews;
    }
    public ArrayList<String> getAttributeArray(String table, String attribute){
        HashMap<String, String[]> columns = new HashMap<String, String[]>();
        columns.put("dish", new String[]{"did", "rid", "dishName", "avgRating"});
        columns.put("review", new String[]{"username", "did", "desc", "rating"});
        columns.put("restaurant", new String[]{"rid", "rname", "address", "postalCode"});
        columns.put("user", new String[]{"username", "password", "firstname", "lastname"});
        columns.put("wishlist", new String[]{"username", "did"});

        ArrayList<String> result = new ArrayList<String>();
        String[] tableColumns = columns.get(table);
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor  cursor = db.rawQuery("select " +attribute+ " from "+table, null);

        // 3. if we got results get the first one
        int columnCount = cursor.getCount();
        if ((cursor != null) && (columnCount> 0)) {
            cursor.moveToFirst();
        }
        else if(cursor==null){
            return null;
        }
        int i=0;
        while(i < cursor.getCount()){
            result.add(cursor.getString(0));
            cursor.moveToNext();
            i++;
        }
        return result;
    }
    public ArrayList<String> rawQuery(String query){
        ArrayList<String> result = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor  cursor = db.rawQuery(query, null);

        // 3. if we got results get the first one
        int columnCount = cursor.getCount();
        if ((cursor != null) && (columnCount> 0)) {
            cursor.moveToFirst();
        }
        else if(cursor==null){
            return null;
        }
        int i=0;
        while(i < cursor.getCount()){
            result.add(cursor.getString(0));
            cursor.moveToNext();
            i++;
        }
        return result;
    }

}

