package com.example.food_app;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.food_app.DatabaseClasses.Dish;
import com.example.food_app.DatabaseClasses.MySQLiteHelper;

//for search
import android.text.Editable;
import android.text.TextWatcher;
import java.util.Locale;

public class WishlistAll extends Activity {
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

		
		// Instead of dishes this now populates a list of restaurants the user wants to visit and clicking the restaurant name will
		// show their wish dish. Currently shows dishes though.
		public void populateList(){
				setContentView(R.layout.activity_wishlist);

				dishIdArray = db.getWishlistIds(username);
				dishArray = db.convertIdsToDish(dishIdArray);
				ArrayList<String> wishlistNames = db.convertIdsToNames(dishIdArray);



				listView = (ListView)findViewById(R.id.listView1);

				//Insert Array here
				if(dishIdArray!=null){
						final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wishlistNames);
						listView.setAdapter(adapter);
						
						
						//Implement the search feature
						final EditText inputSearch = (EditText) findViewById(R.id.editText1);
						
						//get search text
						inputSearch.addTextChangedListener(new TextWatcher() {

								@Override public void afterTextChanged(Editable arg0) {
										// TODO Auto-generated method stub
										String text = inputSearch.getText().toString()
												.toLowerCase(Locale.getDefault());
										adapter.getFilter().filter(text.toString());
								}

								@Override
								public void beforeTextChanged(CharSequence arg0, int arg1,
										int arg2, int arg3) {
										// TODO Auto-generated method stub
								}

								@Override
								public void onTextChanged(CharSequence arg0, int arg1, int arg2,
										int arg3) {
										// TODO Auto-generated method stub
								}
						});
				
				}
				
			listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					switch(position) {
					case 0: Intent newActivity = new Intent(WishlistAll.this, WishListItemView.class);
				  newActivity.putExtra("username", username);
					newActivity.putExtra("dish", dishArray.get(position));
					startActivity(newActivity);
					}
				}
			});
				
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
	
	public void searchWishlist(View view) {
		//Method to search the Wish list
	}

	public void submitDish(View view) {
		Intent intent = new Intent(this, AddToWishlist.class);
			intent.putExtra("username", username);
		startActivity(intent);
	}
	
	public void goToAddDishes(View view) {
		Intent intent = new Intent(this, AddDish.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}

}
