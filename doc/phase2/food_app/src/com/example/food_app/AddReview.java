package com.example.food_app;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnClickListener;

import java.util.regex.Pattern;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class AddReview extends Activity {
    final Context context = this;
	MySQLiteHelper db = new MySQLiteHelper(this);
	String username;
	String did;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adding_review);
		username = getIntent().getStringExtra("username");
		
		did = this.getIntent().getStringExtra("did");
		//get all text fields
		final EditText price = (EditText) findViewById(R.id.price);
		
		
		final RatingBar rating = (RatingBar) findViewById(R.id.rating);
		rating.setStepSize(1);
		final EditText description = (EditText) findViewById(R.id.description);
		Button sub = (Button)findViewById(R.id.submitReview);
		
		
		sub.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
				db.addReview(username, did, description.getText().toString(),
						String.valueOf(rating.getRating()), "");

				Toast.makeText(getApplicationContext(),
											"Review added!",
											Toast.LENGTH_SHORT).show();
				Intent reviews = new Intent(AddReview.this, ReviewsAll.class);
					reviews.putExtra("username", username);
					reviews.putExtra("did", did);
	        	startActivity(reviews);
				
			}
		});
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
		intent.putExtra("username", username);
		startActivity(intent);
	}
	

}
