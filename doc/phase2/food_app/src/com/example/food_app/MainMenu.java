package com.example.food_app;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Locale;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;
import com.example.food_app.DatabaseClasses.Restaurant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class MainMenu extends Activity {
	ListView listView;
	String username;
	ArrayList<String> restArray = new ArrayList<String>();
	MySQLiteHelper db = new MySQLiteHelper(this);
	ArrayList<Restaurant> allRests = new ArrayList<Restaurant>();

	@Override
protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final Context context = this;
	  allRests = db.getAllRestaurants();
		restArray = db.getAttributeArray("restaurant", "rname");
		//int i=0;
		//int size = allRests.size();
		//while(i<size){
		//		restArray.add(allRests.get(i).getRname());
		//}
		username = getIntent().getStringExtra("username");
	  populateList();
}


	protected void onRestart() {
			super.onRestart();  // Always call the superclass method first
		populateList();
			// Activity being restarted from stopped state
	}

	public void populateList(){
			setContentView(R.layout.activity_main_menu);
			


			listView = (ListView)findViewById(R.id.listView_restuarants);
			listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
			{
					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
					{
							Intent intent = new Intent(arg1.getContext(), RestaurantView.class);
							intent.putExtra("username", username);
							intent.putExtra("resto", allRests.get(position));
							startActivity(intent);
					}
			});

			//Insert Array here
			if(restArray!=null){
					final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, restArray);
					listView.setAdapter(adapter);
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
		startActivity(intent);
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

