package com.example.food_app.DatabaseClasses;


 
import java.util.ArrayList;

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
               "username INTEGER, " + 
    		   "did INTEGER," +
               "desc TEXT," +
               "rating INTEGER CHECK(rating>0 AND rating<=5)," +
               "FOREIGN KEY(username) REFERENCES user(username),"+
               "FOREIGN KEY(did) REFERENCES user(did),"+
               "PRIMARY KEY(username, did))";
       String CREATE_WISHLIST_TABLE = "CREATE TABLE wishlist ( " +
               "username INTEGER, " + 
    		   "did INTEGER,"+
               "FOREIGN KEY(username) REFERENCES user(username),"+
               "FOREIGN KEY(did) REFERENCES user(did),"+
               "PRIMARY KEY(did, username))";
       
       String CREATE_DISH_TABLE = "CREATE TABLE dish ( "+
    		   //"did INTEGER PRIMARY KEY AUTOINCREMENT,"+
    		   //"rid INTEGER " +
    		   "dname varchar(255), " +
    		   //"rating INTEGER, " +
    		   //"dishImage BLOB," +
    		   //"FOREIGN KEY(rid) REFERENCES restaurant(rid))"
    		   //Temporary Change
    		   "FOREIGN KEY(dname))"
    		   ;
       
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
   
   public ArrayList<String> getWishlist(String username){
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

    public void addDish(String rid, String dishName, String avgRating){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put("rid", rid);
        values.put("dname", dishName);
        //values.put("rating", avgRating);

        database.insert("dish", // table
            null, //nullColumnHack
            values);
        database.close();
    }

    public Dish getDish(String rid, String did) {
        String[] columns = {"rid", "did", "dishName", "avgRating"};
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor = db.query("dish", // a. table
            columns, // b. column names
            " rid = ? AND did = ?", // c. selections
            new String[] {rid, did}, // d. selections args
            null, // e. group by
            null, // f. having
            null, // g. order by
            null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        Dish dish = new Dish(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return dish;
    }

    public void addReview(String username, String did, String desc, String rating){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("did", did);
        values.put("desc", desc);
        values.put("rating", rating);

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
        Review review = new Review(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
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
    
    public ArrayList<String> getAllRestNames(){
    	String[] columns = {"rid", "rname", "address", "postalCode"};
 	   ArrayList<String> restName = new ArrayList<String>();
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
 	    	restName.add(cursor.getString(1));
           cursor.moveToNext();
 	    	i++;
 	    }
 	    return restName;
    }
    
    public ArrayList<String> getAllDishNames(){
    	String[] columns = {"rid", "did", "dishName", "avgRating"};
 	   ArrayList<String> dishName = new ArrayList<String>();
 	   // 1. get reference to readable DB
 	    SQLiteDatabase db = this.getReadableDatabase();
 	
 	    // 2. build query
 	   Cursor  cursor = db.rawQuery("select * from dish", null);
 	    
 	    // 3. if we got results get the first one

        if ((cursor != null) && (cursor.getCount() > 0)) {
            cursor.moveToFirst();
        }
        else if(cursor==null){
           return null;
       }
         int i=0;
 	    while(i < cursor.getCount()){
 	    	dishName.add(cursor.getString(1));
           cursor.moveToNext();
 	    	i++;
 	    }
 	    return dishName;
    }

    public ArrayList<Dish>  getRestaurantDishes(String rname, String rlocation) {
        ArrayList<Dish> restaurantDishes = new ArrayList<Dish>();

        String[] columns = {"rid", "did", "dishName", "avgRating"};
        String rid;
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor ridCursor = db.rawQuery("SELECT * FROM restaurant WHERE rname = "+rname+" AND location = "+rlocation, null);
        if ((ridCursor != null) && (ridCursor.getCount() > 0)) {
            ridCursor.moveToFirst();
            rid = ridCursor.getString(0);
        }
        // 2. build query
        Cursor cursor = db.query("dish", // a. table
            columns, // b. column names
            " rid = ?", // c. selections
            new String[] {rname, rlocation}, // d. selections args
            null, // e. group by
            null, // f. having
            null, // g. order by
            null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        Dish dish = new Dish(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

        int i=0;
        while(i < cursor.getCount()){
            Dish temp = new Dish(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
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
            Review temp = new Review(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            allReviews.add(temp);
            cursor.moveToNext();
            i++;
        }
        return allReviews;
    }
    
    public ArrayList<String> getAllTextReviews() {
        ArrayList<String> allReviews = new ArrayList<String>();
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor = db.rawQuery("select * from review", null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        int i=0;
        while(i < cursor.getCount()){
            allReviews.add(cursor.getString(2));
            cursor.moveToNext();
            i++;
        }
        return allReviews;
    }

}

