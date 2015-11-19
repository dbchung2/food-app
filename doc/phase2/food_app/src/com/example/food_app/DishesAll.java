package com.example.food_app;

import android.os.Bundle;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class DishesAll extends Activity {
	ListView listView;
	String username;
	MySQLiteHelper db = new MySQLiteHelper(this);


	@Override
	protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				username = getIntent().getStringExtra("username");
				populateList();
	}
	
	protected void onRestart() {
		super.onRestart();  // Always call the superclass method first
	populateList();
		// Activity being restarted from stopped state
}

		public void addDish(View view) {
				Intent intent = new Intent(this, AddDish.class);
				startActivity(intent);
		}
	public void populateList(){
		setContentView(R.layout.activity_dishes_all);
		
		ArrayList<String> dishArray = new ArrayList<String>();
		dishArray = db.getAttributeArray("dish", "dishName");
		
  	listView = (ListView)findViewById(R.id.listView_dish1);

		//Insert Array here
		if(dishArray!=null){
				final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dishArray);
				listView.setAdapter(adapter);
				
				/*
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
				});*/
		}
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.restaurant, menu);
		return true;
	}

	//public void searchRestuarant(View view) {
		//Method to search the restaurant list
	//	String[] restuarant = {"pizza","coke"}; // get the restuarant list form the database
		//EditText name = (EditText)findViewById(R.id.restuarant_name);
		//String string_name = name.toString();
		//for (int i=0; i< restuarant.length; i++) {
		//    if (restuarant[i].startsWith(string_name)){
		//    	
		//    	}
		//    }
		    	
	//	}
}


