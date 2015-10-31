package com.example.food_app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class TestScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_screen);
		
		String sql_test = "testing sql"; //replace value of this variable with sql table - has to be passed though 
		
		TextView testing = (TextView) findViewById(R.id.testing);
		testing.setText(sql_test); //Place Holder replaced with dish name
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_screen, menu);
		return true;
	}

}
