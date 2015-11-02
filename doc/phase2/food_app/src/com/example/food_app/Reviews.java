package com.example.food_app;

import java.util.ArrayList;
import java.util.List;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;
import com.example.food_app.DatabaseClasses.Review;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class Reviews extends Activity {
    MySQLiteHelper db = new MySQLiteHelper(this);
    /* assume when entered, data is already parsed and passed to this class from sql - will
     * implement a parser if needed.
     */
    //required data: dish name(string), restaurant name(string), list of rating (array of numbers),
    //list of comments/descriptions(array of strings)
    
    ListView comment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        
        //Testing rating value
        ArrayList<Integer> ratings = new ArrayList<Integer>();
        ratings.add(2);
        ratings.add(4);

        //To get all reviews
        ArrayList<Review> allrevs = db.getAllReviews();
        
        //parse to list of strings - test later
        ArrayList<String> allreviews = new ArrayList<String>();
        
        for (int i = 0; i < allrevs.size(); i++){
            allreviews.add(allrevs.get(i).getDesc());
        	//allreviews.add("test");
        }
        
        //Intent intent = getIntent();
        
        //find text that needs to be changed and set it to given required data
        //For phase 3 use
        /*TextView dish_name = (TextView) findViewById(R.id.food_name_rev);
        dish_name.setText("Dish Place Holder"); //Place Holder replaced with dish name
        TextView rest = (TextView) findViewById(R.id.restaurant_name_rev);
        rest.setText("Rest Place Holder"); //Place Holder replaced with restaurant name
        TextView rating = (TextView) findViewById(R.id.rating_rev);
        rating.setText("rating: 10"); //Place Holder replaced with avg rating name*/
        
        //For working with the listview
        //Find list location
        comment = (ListView) findViewById(R.id.comments);
        
        //set adapter here
        CommentAdapter adapter = new CommentAdapter(this, allreviews);
        
        comment.setAdapter(adapter);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reviews, menu);
        return true;
    }
    
    //function that will calculate the average of the rating array
    //for phase 3
    public int avg_rating(ArrayList<Integer> ratings) {
        int sum = 0;
        for (int i=0; i < ratings.size(); i++) {
            sum += ratings.get(i);
        }
        return (sum/ratings.size());
    }
    

}