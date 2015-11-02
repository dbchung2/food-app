package com.example.food_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class LoginScreen extends Activity {
	MySQLiteHelper db = new MySQLiteHelper(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);
        
        Button login = (Button) findViewById(R.id.login);
        Button register = (Button) findViewById(R.id.register);
        final EditText e1 = (EditText) findViewById(R.id.username);
        final EditText e2 = (EditText) findViewById(R.id.password);
        
        login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				 String username = e1.getText().toString();
	        	 Intent login = new Intent(LoginScreen.this, LoginScreen.class);
	        	 Intent main = new Intent(LoginScreen.this, MainMenu.class);
	        	 String password="";
	        	 if(db.getUser(username)!=null){
		        	  password = db.getUser(username).getPassword();
	        	 }
	        	 else{
	        		 startActivity(login);
					 finish();
	        	 }
				 
				 if (password.equals(e2.getText().toString())) {
					 main.putExtra("username", username);
					 startActivity(main);
					 finish();
					 
				 } else {
					 startActivity(login);
					 finish();
				 }
			}					
		});
        
        register.setOnClickListener(new OnClickListener() {

						@Override public void onClick(View arg0) {

								String username = e1.getText().toString();
								Intent login = new Intent(LoginScreen.this, LoginScreen.class);
								Intent main = new Intent(LoginScreen.this, MainMenu.class);
								String password = e2.getText().toString();


								if (username == null || password == null) {
										startActivity(login);
										finish();

								} else if (db.getUser(username) != null) {
										startActivity(login);
										finish();
								} else {
										db.addUser(username, password, "FirstName", "LastName");
										main.putExtra("username", username);

										startActivity(main);
										finish();
								}

						}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_screen, menu);
		return true;
	}

}
