package com.example.food_app;

import android.app.Activity;
import android.os.Bundle;
import com.example.food_app.DatabaseClasses.MySQLiteHelper;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnClickListener;

/**
 * Created by Matt on 2015-11-01.
 */
public class add_dish extends Activity {
	String menuName, rest_id, avg_rating;
	MySQLiteHelper db = new MySQLiteHelper(this);
	
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);
        
        menuName = ((EditText)findViewById(R.id.menuname)).getText().toString();
        rest_id = ((EditText)findViewById(R.id.restid)).getText().toString();
        avg_rating = ((EditText)findViewById(R.id.avgRating)).getText().toString();
        
        
        Button submit_add = (Button)findViewById(R.id.submitToAddDish);
		
        submit_add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
				//Add dish based on info given by user
				
				db.addDish(rest_id, menuName, avg_rating);
				
				System.out.println("damn.....");
				Toast.makeText(getApplicationContext(),
											"Item added to wishlist!",
											Toast.LENGTH_SHORT).show();
				finish();
				
			}
		});
        
        
    }
}
