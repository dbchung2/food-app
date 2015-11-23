package com.example.food_app;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class AddToWishlist extends Activity {
	MySQLiteHelper db = new MySQLiteHelper(this);
	Button submit;
	EditText dish, rest;
	String username;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			username = getIntent().getStringExtra("username");

			super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_to_wishlist);
		// Show the Up button in the action bar.
		setupActionBar();
		dish = (EditText)findViewById(R.id.nameOfDish);
		rest = (EditText)findViewById(R.id.restaurantName);
		submit = (Button)findViewById(R.id.submitToWishlist);
		
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
				//Add dish based on info given by user
				db.addWishlist(dish.getText().toString(), username);
				Toast.makeText(getApplicationContext(),
											"Item added to wishlist!",
											Toast.LENGTH_SHORT).show();
				finish();
				
			}
		});
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
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
