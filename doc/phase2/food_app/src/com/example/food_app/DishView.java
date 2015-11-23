package com.example.food_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.food_app.DatabaseClasses.Dish;
import com.example.food_app.DatabaseClasses.MySQLiteHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Matt on 2015-11-19.
 */
public class DishView extends Activity {
    String did;
    String username;
    MySQLiteHelper db = new MySQLiteHelper(this);
    Dish thisDish;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = this.getIntent().getStringExtra("username");
        setContentView(R.layout.activity_dish_view);
        
     // Commented out to test the flow of app
        
         thisDish = (Dish)this.getIntent().getSerializableExtra("dish");
        did = thisDish.getDid();
        TextView dName =  (TextView) findViewById (R.id.dishNameText);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.dishViewRating);
        TextView category = (TextView) findViewById(R.id.dishViewCategory);
        TextView price = (TextView) findViewById(R.id.dishViewPrice);
        price.setText(String.valueOf(thisDish.getPrice()));
        category.setText(thisDish.getCategory());

        ratingBar.setRating(db.getAvgRating(thisDish.getDid()));
        dName.setText(thisDish.getDishName());
    }


    public void goToReviews(View view) {
        //Go to reviews for this dish
        Intent intent = new Intent(this, ReviewsAll.class);
        intent.putExtra("did", did);
        intent.putExtra("username", username);
        startActivity(intent);
    }
    public void ateIt(View view){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String now = dateFormat.format(date);
        db.addSpent(username, thisDish.getDid(), now, thisDish.getCategory());
        Button ateButton = (Button)findViewById(R.id.dishViewAteIt);
        ateButton.setVisibility(View.GONE);
    }
    public void addToWish(View view) {
        db.addWishlist(did, username);
        Button addButton = (Button) findViewById(R.id.addToWishlist);
        addButton.setVisibility(View.GONE);
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, R.id.menu_action, Menu.NONE, "Go to Main Menu");

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) { 
		switch (item.getItemId()) {
			case R.id.menu_action:
				goToMenu();
					return true;
				default:
					return super.onOptionsItemSelected(item);
		   }
	}
			
	public void goToMenu() {
		Intent intent = new Intent(this, MainMenu.class);
		startActivity(intent);
	}
}
