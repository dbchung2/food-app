package com.example.food_app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;
import com.example.food_app.DatabaseClasses.Restaurant;

public class RestaurantsAll extends Activity {

		ListView listView;
		String username;
		ArrayList<String> restArray = new ArrayList<String>();
		MySQLiteHelper db = new MySQLiteHelper(this);
		ArrayList<Restaurant> allRests = new ArrayList<Restaurant>();
		@Override
	protected void onCreate(Bundle savedInstanceState) {

			final Context context = this;
		  allRests = db.getAllRestaurants();
			restArray = db.getAttributeArray("restaurant", "rname");
			//int i=0;
			//int size = allRests.size();
			//while(i<size){
			//		restArray.add(allRests.get(i).getRname());
			//}
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
				setContentView(R.layout.activity_restaurant);
				


				listView = (ListView)findViewById(R.id.listView_restuarant1);
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
						
						
						//Implement the search feature
						final EditText inputSearch = (EditText) findViewById(R.id.restaurant_name1);
						
						//get search text
						inputSearch.addTextChangedListener(new TextWatcher() {
				 
							@Override
							public void afterTextChanged(Editable arg0) {
								// TODO Auto-generated method stub
								String text = inputSearch.getText().toString().toLowerCase(Locale.getDefault());
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
	
	public void addRest(View view) {
		Intent intent = new Intent(this, AddRestaurant.class);
			intent.putExtra("username", username);
		startActivity(intent);
	}

}


