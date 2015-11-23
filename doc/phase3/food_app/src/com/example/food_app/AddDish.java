package com.example.food_app;

import android.app.Activity;
import android.os.Bundle;
import com.example.food_app.DatabaseClasses.MySQLiteHelper;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnClickListener;

/**
 * Created by Matt on 2015-11-01.
 */
public class AddDish extends Activity {
	String dishName, category, avg_rating;
	Double price;
	String username;
	MySQLiteHelper db = new MySQLiteHelper(this);
	
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);
        
        final String rid = getIntent().getExtras().getString("rid");
        username = getIntent().getStringExtra("username");
        Button submit_add = (Button)findViewById(R.id.submitToAddDish);

		
        submit_add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
					dishName = ((EditText)findViewById(R.id.menuname)).getText().toString();
					price = Double.parseDouble(((EditText)findViewById(R.id.addDishPrice)).getText().toString());
					category = ((EditText) findViewById(R.id.category)).getText().toString();
				//Add dish based on info given by user
				db.addDish(rid, dishName, category, price);

				
				
				Toast.makeText(getApplicationContext(),
											"Dish Added!",
											Toast.LENGTH_SHORT).show();
				finish();
				
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
