package com.example.food_app;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        
        Button login = (Button) findViewById(R.id.login);
        Button register = (Button) findViewById(R.id.register);
        final EditText e1 = (EditText) findViewById(R.id.username);
        final EditText e2 = (EditText) findViewById(R.id.password);
        
        login.setOnClickListener(new OnClickListener() {
			
        	String username = e1.getText().toString();
			@SuppressLint("NewApi")
			@Override
			public void onClick(View arg0) {
				 Intent move = new Intent(LoginScreen.this, MainMenu.class);
				 move.putExtra("username", username);
				 startActivity(move); 
                 finish();
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
