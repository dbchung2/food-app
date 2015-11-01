package com.example.food_app;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class AddReview extends Activity {
    final Context context = this;
	MySQLiteHelper db = new MySQLiteHelper(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adding_review);
		System.out.println("Hello world");
		addListenerOnButton();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_review, menu);
		return true;
	}
	
	
	public void add_dish(View view){
		Intent intent = getIntent();
		
		//get all text fields
		EditText restname = (EditText) findViewById(R.id.restname);
		EditText dishname = (EditText) findViewById(R.id.dishname);
		EditText price = (EditText) findViewById(R.id.price);
		EditText rating = (EditText) findViewById(R.id.rating);
		EditText category = (EditText) findViewById(R.id.category);
		EditText description = (EditText) findViewById(R.id.description);
		
		//check for valid data types (ie. price is in 0.00 format and rating is a number 1-5) 
		//insert to SQL table here - will implement 
		
		//switch screens - create a field where if data is not valid returns to this screen <-when backbone is done
		//for now automatically go to main menu screen
		Intent move = new Intent(AddReview.this, MainMenu.class); 
		startActivity(move);
		finish();
	}
	public void addListenerOnButton() {
		db.addUser("matt", "mattpass", "Matthew", "Mcwaters");
		Button test;
		test = (Button) findViewById(R.id.test);

		test.setOnClickListener(new OnClickListener() {
			
			
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
					
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);
				alertDialogBuilder.setTitle(db.getUser("matt").getPassword());
				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}

		});

	}
	

}
