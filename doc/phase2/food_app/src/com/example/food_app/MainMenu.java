package com.example.food_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

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
	
	public void goToMain(View view) {
		Intent intent = new Intent(this, MainMenu.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}

	public void goToWishlist(View view) {

		Intent intent = new Intent(this, WishlistAll.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}

	public void goToSearch(View view) {
		Intent intent = new Intent(this, Search.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}
	
	public void goToSpent(View view) {
		Intent intent = new Intent(this, Spent.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}
	
	public void goToAddDishes(View view) {
		Intent intent = new Intent(this, AddDish.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}
	
	public void goToDishView(View view) {
		Intent intent = new Intent(this, DishView.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}
	
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
	/*
	public void goToAllReviews(View view) {
		Intent intent = new Intent(this, ReviewsAll.class);
		startActivity(intent);
	}
	
	
	public void goToRestaurant(View view) {
		Intent intent = new Intent(this, RestaurantsAll.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}
*/
}
