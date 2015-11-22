package com.example.food_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.food_app.DatabaseClasses.Dish;
import com.example.food_app.DatabaseClasses.MySQLiteHelper;

/**
 * Created by Matt on 2015-11-19.
 */
public class DishView extends Activity {
    String did;
    String username;
    MySQLiteHelper db = new MySQLiteHelper(this);

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = this.getIntent().getStringExtra("username");
        setContentView(R.layout.activity_dish_view);
        
     // Commented out to test the flow of app
        
        Dish thisDish = (Dish)this.getIntent().getSerializableExtra("dish");
        did = thisDish.getDid();
        TextView dName =  (TextView) findViewById (R.id.dishNameText);
        TextView dAverageRating =  (TextView) findViewById (R.id.averageRatingText);
        dName.setText(thisDish.getDishName());
        dAverageRating.setText(thisDish.getAvgRating());
    }


    public void goToReviews(View view) {
        //Go to reviews for this dish
        Intent intent = new Intent(this, ReviewsAll.class);
        intent.putExtra("did", did);
        intent.putExtra("username", username);
        startActivity(intent);
    }
    
    public void addToWish(View view) {
        db.addWishlist(did, username);
        Button addButton = (Button) findViewById(R.id.addToWishlist);
        addButton.setVisibility(View.GONE);
    }
}
