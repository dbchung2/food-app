package com.example.food_app;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

import java.util.ArrayList;
import java.util.Locale;

public class Spent extends Activity {
		MySQLiteHelper db = new MySQLiteHelper(this);
		String username;
  ArrayList<String> cats;
		ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spent);
			username = getIntent().getStringExtra("username");

	}
		public void populateList(){

				setContentView(R.layout.activity_spent);

				cats = db.getCategories(username);

				listView = (ListView)findViewById(R.id.listView1);

				//Insert Array here
				if(cats!=null){
						final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cats);
						listView.setAdapter(adapter);


						//Implement the search feature
						if(cats!=null){
								final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cats);
								listView.setAdapter(adapter1);


								//Implement the search feature
								final EditText inputSearch = (EditText) findViewById(R.id.dish_name1);

								//get search text
								inputSearch.addTextChangedListener(new TextWatcher() {

										@Override
										public void afterTextChanged(Editable arg0) {
												// TODO Auto-generated method stub
												String text = inputSearch.getText().toString().toLowerCase(
														Locale.getDefault());
												adapter1.getFilter().filter(text.toString());
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
