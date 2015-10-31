package com.example.food_app;


 
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
               "username INTEGER FOREIGN KEY REFERENCSE user(username), " + 
    		   "did INTEGER FOREIGN KEY REFERENCSE dish(did)," +
               "desc TEXT," +
               "rating INTEGER CHECK(rating>0 AND rating<=5)," + 
               "PRIMARY KEY(username, did)";


       // create tables
       db.execSQL(CREATE_USER_TABLE);
       db.execSQL(CREATE_RESTO_TABLE);
       db.execSQL(CREATE_REVIEW_TABLE);

   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // Drop older books table if existed
       db.execSQL("DROP TABLE IF EXISTS books");

       // create fresh books table
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

   public String getUser(String username){
	   String[] pwordColumn = {"password"};
	   
	   // 1. get reference to readable DB
	    SQLiteDatabase db = this.getReadableDatabase();
	 
	    // 2. build query
	    Cursor cursor = 
	            db.query("user", // a. table
	            pwordColumn, // b. column names
	            " id = ?", // c. selections 
	            new String[] { username }, // d. selections args
	            null, // e. group by
	            null, // f. having
	            null, // g. order by
	            null); // h. limit
	 
	    // 3. if we got results get the first one
	    if (cursor != null)
	        cursor.moveToFirst();

	    // 5. return book
	    return cursor.getString(0);
   }
}