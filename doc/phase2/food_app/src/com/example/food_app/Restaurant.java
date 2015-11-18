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
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class Restaurant extends Activity {
	MySQLiteHelper db = new MySQLiteHelper(this);
    final Context context = this;
    
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
				setContentView(R.layout.activity_restaurant);
				
				ArrayList<String> restArray = new ArrayList<String>();
				restArray = db.getAllRestNames();
				
				listView = (ListView)findViewById(R.id.listView_restuarant1);	

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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.restaurant, menu);
		return true;
	}
	
	public void addRest(View view) {
		Intent intent = new Intent(this, AddRestaurant.class);
			intent.putExtra("username", username);
		startActivity(intent);
	}
}


