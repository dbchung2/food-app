package com.example.food_app;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class AddToWishlist extends Activity {
	MySQLiteHelper db = new MySQLiteHelper(this);
	Button submit;
	EditText dish, rest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
				db.addWishlist("matt",  dish.toString());
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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_to_wishlist, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
