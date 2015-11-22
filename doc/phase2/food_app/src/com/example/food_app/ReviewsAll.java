package com.example.food_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;
import com.example.food_app.DatabaseClasses.Review;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ReviewsAll extends Activity {
    MySQLiteHelper db = new MySQLiteHelper(this);
    String did;
    /* assume when entered, data is already parsed and passed to this class from sql - will
     * implement a parser if needed.
     */
    //required data: dish name(string), restaurant name(string), list of rating (array of numbers),
    //list of comments/descriptions(array of strings)
    
    ListView comment;
    String username;
    ArrayList<Review> allReviews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = getIntent().getStringExtra("username");
        did = this.getIntent().getStringExtra("did");
        //Testing rating value
        /*ArrayList<Integer> ratings = new ArrayList<Integer>();
        ratings.add(2);
        ratings.add(4);*/

        populateList();
    }
    
    public void populateList(){
    	  setContentView(R.layout.activity_reviews);

        ArrayList<String> allrevs = new ArrayList<String>();
        allrevs = db.rawQuery("select desc from review where did = "+did);
        allReviews = db.getAllReviews();


        comment = (ListView)findViewById(R.id.comments);
        comment.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                Intent intent = new Intent(arg1.getContext(), ReviewView.class);
                intent.putExtra("username", username);
                intent.putExtra("review", allReviews.get(position));
                startActivity(intent);
            }
        });
        //To get all reviews


        //parse to list of strings - test later
       /* ArrayList<String> allreviews = new ArrayList<String>();
        ArrayList<String> dishnames = new ArrayList<String>();
        
        for (int i = 0; i < allrevs.size(); i++){
            allreviews.add(allrevs.get(i).getDesc());
            dishnames.add(allrevs.get(i).getDid());
        }*/
        
        //Find list locationcomment = (ListView) findViewById(R.id.comments);
        
		if(allrevs!=null){

			final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allrevs);
			comment.setAdapter(adapter);

		}
	
}
    
    protected void onRestart() {
		super.onRestart();  // Always call the superclass method first
		populateList();
		// Activity being restarted from stopped state
}
    
	public void submit(View view) {
	Intent intent = new Intent(this, AddReview.class);
		intent.putExtra("username", username);
      intent.putExtra("did", did);
		startActivity(intent);
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
