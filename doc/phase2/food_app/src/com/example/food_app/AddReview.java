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
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnClickListener;

import java.util.regex.Pattern;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class AddReview extends Activity {
    final Context context = this;
	MySQLiteHelper db = new MySQLiteHelper(this);
	String username;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adding_review);
		username = getIntent().getStringExtra("username");
		
		//get all text fields
		final EditText restname = (EditText) findViewById(R.id.restname);
		final EditText dishname = (EditText) findViewById(R.id.dishname);
		final EditText price = (EditText) findViewById(R.id.price);
		final EditText rating = (EditText) findViewById(R.id.rating);
		final EditText category = (EditText) findViewById(R.id.category);
		final EditText description = (EditText) findViewById(R.id.description);
		Button sub = (Button)findViewById(R.id.submitReview);
		
		sub.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
				db.addReview(username, dishname.getText().toString(), description.getText().toString(), 
						rating.getText().toString());

				Toast.makeText(getApplicationContext(),
											"Review added!",
											Toast.LENGTH_SHORT).show();
				Intent mainMenu = new Intent(AddReview.this, MainMenu.class);
	        	startActivity(mainMenu);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_review, menu);
		return true;
	}
	

}
