package com.example.food_app;

import android.os.Bundle;

import java.util.ArrayList;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class Restaurant extends Activity {
	ListView listView;
		MySQLiteHelper db = new MySQLiteHelper(this);


	@Override
	protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_restaurant);
				listView = (ListView)findViewById(R.id.listView_restuarant1);
				//Insert Array here
				ArrayList<String> restaurantInfo = new ArrayList<String>();
				ArrayList<com.example.food_app.DatabaseClasses.Restaurant> allRestaurants = db.getAllRestaurants();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, restaurantInfo);
        listView.setAdapter(adapter);
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


