package com.example.food_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;
import com.example.food_app.DatabaseClasses.Review;

/**
 * Created by Matt on 2015-11-21.
 */
public class ReviewView extends Activity {
    MySQLiteHelper db = new MySQLiteHelper(this);

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_view);
        Review review = (Review) this.getIntent().getSerializableExtra("review");
        String dishName = db.rawQuery("select dishName from dish where did = "+review.getDid()).get(0);
        TextView dName =  (TextView) findViewById (R.id.reviewDishName);
        TextView dDesc =  (TextView) findViewById (R.id.reviewDesc);
        TextView dRating =  (TextView) findViewById (R.id.reviewRating);
        TextView dUsername =  (TextView) findViewById (R.id.reviewUsername);
        dName.setText(dishName);
        dDesc.setText(review.getDesc());
        dRating.setText(review.getRating());
        dUsername.setText(review.getUsername());

    }
}
