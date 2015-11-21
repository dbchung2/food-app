package com.example.food_app;

import java.util.ArrayList;
import java.util.Locale;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.content.Intent;

public class Search extends Activity {
	String username;
	String type; // This is the type of search the user wants to perform: Restaurants, Location, Category or Price.
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		username = getIntent().getStringExtra("username");
		populateList();
	}

	protected void onRestart() {
		super.onRestart();  // Always call the superclass method first
		populateList();
		// Activity being restarted from stopped state
	}

	public void populateList(){
		setContentView(R.layout.activity_wishlist);
		listView = (ListView)findViewById(R.id.listView1);
		
		ArrayList<String> category_search = new ArrayList<String>();
		
		category_search.add("Restaurants");
		category_search.add("Location");
		category_search.add("Category");
		category_search.add("Price");
		

		//Insert Array here
		if(category_search!=null){
				final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, category_search);
				listView.setAdapter(adapter);
				
				
				// Implement the search feature - currently search within the above list, change to the most relevant search result.
				final EditText inputSearch = (EditText) findViewById(R.id.editText1);
				
				listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
				{
						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3) { 
							switch(position){
								case 0: // Click on restaurant
									Intent intent = new Intent(arg1.getContext(), RestaurantsAll.class);
									intent.putExtra("username", username);
									startActivity(intent);
									break;
									
								case 1: // Click on location
									Intent intent2 = new Intent(arg1.getContext(), RestaurantsAll.class); 
									intent2.putExtra("username", username);
									startActivity(intent2);
									break;
									
								case 2: // Click on category
									Intent intent3 = new Intent(arg1.getContext(), RestaurantsAll.class);
									intent3.putExtra("username", username);
									startActivity(intent3);
									break;
									
								case 3: // Click on price
									Intent intent4 = new Intent(arg1.getContext(), RestaurantsAll.class);
									intent4.putExtra("username", username);
									startActivity(intent4);
									break;
							}
						}
				});
				
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

		listView.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View view,
	           int position, long id) {

				    if(position == 0)
				    {
				    	Intent intent = new Intent(Search.this, RestaurantsAll.class);
				    	startActivity(intent);
				    }
	
				    if(position == 1)
				    {
				    	setContentView(R.layout.activity_dish_view);
				    }
				    if(position == 2)
				    {
	
				    	setContentView(R.layout.activity_wishlist);
				    }
	
				    if(position == 3)
				    {
	
				    	setContentView(R.layout.activity_restaurant);
				    }
		        }
			
		});;

		


}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	public void goToAddDishes(View view) {
		Intent intent = new Intent(this, AddDish.class);
		intent.putExtra("username", username);
		startActivity(intent);
	}
	

}
