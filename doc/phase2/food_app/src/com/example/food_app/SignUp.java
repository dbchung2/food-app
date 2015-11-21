package com.example.food_app;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

public class SignUp extends Activity {
MySQLiteHelper db = new MySQLiteHelper(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		// Show the Up button in the action bar.
		setupActionBar();
		
		final Button signUpButton = (Button) findViewById(R.id.signUpButton);
		final EditText user = (EditText) findViewById(R.id.usernameField);
		final EditText passwd = (EditText) findViewById(R.id.passwordField);
		final EditText fname = (EditText) findViewById(R.id.firstName);
		final EditText lname = (EditText) findViewById(R.id.lastName);
		
		signUpButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String uName = user.getText().toString();
				String pWord = passwd.getText().toString();
				String firstName = fname.getText().toString();
				String lastName = lname.getText().toString();
				
				if (uName.matches("") || pWord.matches("")) {
	        		 Toast.makeText(getApplicationContext(),
								"Please enter a username and password!",
								Toast.LENGTH_SHORT).show();
				} else if (db.getUser(uName) != null) {
	        		 Toast.makeText(getApplicationContext(),
								"Username taken!",
								Toast.LENGTH_SHORT).show();
				}else if (firstName.matches("") || lastName.matches("")) {
	        		 Toast.makeText(getApplicationContext(),
								"Please enter your name!",
								Toast.LENGTH_SHORT).show();
				} else {
					if (pWord.length() >= 5 && pWord.matches(".*\\d+.*")) {
						db.addUser(uName, pWord, firstName, lastName);
						//main.putExtra("username", username);
						Toast.makeText(getApplicationContext(),
								"Registration successful! Please login.",
								Toast.LENGTH_SHORT).show();
						finish();
					} else {
						Toast.makeText(getApplicationContext(),
								"Password must be at least 5 characters and contain a number!",
								Toast.LENGTH_SHORT).show();
					}
				}
			
			}	
		});
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
