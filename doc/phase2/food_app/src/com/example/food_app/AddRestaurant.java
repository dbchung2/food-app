package com.example.food_app;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddRestaurant extends Activity {
	MySQLiteHelper db = new MySQLiteHelper(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_restaurant);
		
        Button add = (Button) findViewById(R.id.addbutton);
        final EditText name = (EditText) findViewById(R.id.restnames);
        final EditText address = (EditText) findViewById(R.id.address);
        final EditText postal_code = (EditText) findViewById(R.id.postal_code);
        
        add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String sname = name.getText().toString();
		        String saddress = address.getText().toString();
		        String spostal_code = postal_code.getText().toString();
		        
		        if (sname != null || saddress != null || spostal_code != null) {
		        	db.addRestaurant(sname, saddress, spostal_code);

			    	Intent intent = new Intent(AddRestaurant.this, RestaurantsAll.class);
			    	startActivity(intent);
		        } else {
		        	Intent restaurant = new Intent(AddRestaurant.this, AddRestaurant.class);
		        	startActivity(restaurant);
		        }
		        
			}					
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.restaurant, menu);
		return true;
	}

}
