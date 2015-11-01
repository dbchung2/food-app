package com.example.food_app;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Wishlist extends Activity {
	//MySQLiteHelper db = new MySQLiteHelper(this);
    //final Context context = this;
    //ArrayList<String> dishIdArray;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wishlist);
		//dishIdArray = db.getWishlist("matt");

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
		startActivity(intent);
	}

}