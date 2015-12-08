package com.example.food_app;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

import com.example.food_app.DatabaseClasses.Dish;
import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class WishListItemView extends Activity {
		MySQLiteHelper db = new MySQLiteHelper(this);

		String username;
	String dishName;
		Dish thisDish;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wish_list_item_view);
		// Show the Up button in the action bar.
		setupActionBar();
		
		//Set textview of Dish Name
		username = getIntent().getStringExtra("username");
		thisDish = (Dish) getIntent().getSerializableExtra("dish");

		TextView restName = (TextView) findViewById(R.id.wishListRestName);
		TextView foodField = (TextView) findViewById(R.id.wishListFoodName);
		RatingBar ratingBar = (RatingBar) findViewById(R.id.wishlistRating);
	  ImageView img = (ImageView) findViewById(R.id.wishImageView);
			img.setImageBitmap(BitmapFactory
					.decodeByteArray(thisDish.getImg(), 0, thisDish.getImg().length));
		ratingBar.setRating(db.getAvgRating(thisDish.getDid()));
		foodField.setText(thisDish.getDishName());
		restName.setText(db.getRestaurant(thisDish.getRid()).getRname());
		Button ateItButton = (Button) findViewById(R.id.removeFromWishlist);
		ateItButton.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
				  db.removeFromWishlist(username, thisDish.getDid());
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
