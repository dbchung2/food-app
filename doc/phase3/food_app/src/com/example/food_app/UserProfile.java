package com.example.food_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class UserProfile extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
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
	

}
