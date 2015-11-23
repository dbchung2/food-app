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
		ArrayList<String> categories;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spent);
			username = getIntent().getStringExtra("username");
			populateList();

	}
		public void populateList(){

				setContentView(R.layout.activity_spent);
			  categories =   db.rawQuery(
						"select DISTINCT category from spent where username = " + username+ " order by category");

				cats = db.getSpentTitles(username);

				listView = (ListView)findViewById(R.id.listView1);
				listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
				{
						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
						{
								Intent intent = new Intent(arg1.getContext(), SpentView.class);
								intent.putExtra("username", username);
								intent.putExtra("cat", categories.get(position));
								startActivity(intent);
						}
				});
				//Insert Array here
				if(cats!=null){
						final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cats);
						listView.setAdapter(adapter);
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
