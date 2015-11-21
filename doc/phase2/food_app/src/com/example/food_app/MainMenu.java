package com.example.food_app;

import android.os.Bundle;

import java.util.ArrayList;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainMenu extends Activity {
	 String username;
	 GridView gv;
     Context context;    
     ArrayList foodName;    
     MySQLiteHelper db = new MySQLiteHelper(this);
     
     // Temporary values to test front end - will replace with back end values (currently can't do due to a bug).
     public static String [] dishList={"Pancakes", "Big Mac"};
     public static String [] restList={"iHop", "McDonalds"};
     public static int [] foodImages={R.drawable.food1, R.drawable.food2};
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);


		username = getIntent().getStringExtra("username");
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this, dishList, foodImages, restList));

		gridview.setOnItemClickListener(new OnItemClickListener() {
		        public void onItemClick(AdapterView<?> parent, View v,
		                int position, long id) {
		        	 Intent i = new Intent(getApplicationContext(), DishView.class);
		        	 i.putExtra("username", username);
		        	 i.putExtra("dishname", dishList[position]);
		             startActivity(i);
		        }
		    });
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
	
	public void goToAddReview(View view) {
		Intent intent = new Intent(this, AddReview.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}
	
	public void goToDishView(View view) {
		Intent intent = new Intent(this, DishView.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}
	
	public void goToAddRestaurant(View view) {
		Intent intent = new Intent(this, AddRestaurant.class);
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
	
*/	
	public void goToRestaurant(View view) {
		Intent intent = new Intent(this, RestaurantsAll.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}

}

