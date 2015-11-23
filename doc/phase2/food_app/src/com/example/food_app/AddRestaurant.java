package com.example.food_app;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddRestaurant extends Activity {
	MySQLiteHelper db = new MySQLiteHelper(this);
		String username;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			 username = this.getIntent().getStringExtra("username");
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
								intent.putExtra("username", username);

								startActivity(intent);
		        } else {
		        	Intent restaurant = new Intent(AddRestaurant.this, AddRestaurant.class);
							restaurant.putExtra("username", username);
								startActivity(restaurant);
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
		intent.putExtra("username", username);
		startActivity(intent);
	}

}
