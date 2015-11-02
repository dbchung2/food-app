package com.example.food_app;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.food_app.DatabaseClasses.Dish;
import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class Wishlist extends Activity {
		MySQLiteHelper db = new MySQLiteHelper(this);
    final Context context = this;
    ArrayList<String> dishIdArray;
		ArrayList<Dish> dishArray = new ArrayList<Dish>();
		ListView listView;
		String username;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			username = getIntent().getStringExtra("username");
			super.onCreate(savedInstanceState);
		  populateList();
	}

		protected void onRestart() {
				super.onRestart();  // Always call the superclass method first
			populateList();
				// Activity being restarted from stopped state
		}

		public void populateList(){
				setContentView(R.layout.activity_wishlist);
				if(db.getWishlist(username) != null){
						dishIdArray = db.getWishlist(username);
				}

				listView = (ListView)findViewById(R.id.listView1);

				//Insert Array here
				if(dishIdArray!=null){
						ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dishIdArray);
						listView.setAdapter(adapter);
				}
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wishlist, menu);
		return true;
	}
	
	public void searchWishlist(View view) {
		//Method to search the Wish list
	}

		public void submitDish(View view) {
		Intent intent = new Intent(this, AddToWishlist.class);
			intent.putExtra("username", username);
		startActivity(intent);
	}

}
