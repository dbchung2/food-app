package com.example.food_app;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {
	String username;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);


		username = getIntent().getStringExtra("username");
		//pass username to next views
		
		//next_action();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	public void goToWishlist(View view) {
		Intent intent = new Intent(this, Wishlist.class);
		startActivity(intent);
	}
	
	public void goToReview(View view) {
		Intent intent = new Intent(this, AddReview.class);
		intent.putExtra("username", username);
		startActivity(intent);
	
	//public void next_action() {
		//Button Restaurants;
		//Button dishes;
		
		//Restaurants = (Button) findViewById(R.id.Restaurants);
		//dishes = (Button) findViewById(R.id.dishes);

		
			//@SuppressLint("NewApi")
			//@Override
			//public void onClick(View arg0) {
			//	setContentView(R.layout.activity_wishlist);
			//}					
		//});
	}
}
