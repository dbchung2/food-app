package com.example.food_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.view.LayoutInflater;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

public class LoginScreen extends Activity {
	MySQLiteHelper db = new MySQLiteHelper(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_screen);
        
        final Button login_butt = (Button) findViewById(R.id.login);
        final EditText e1 = (EditText) findViewById(R.id.username);
        final EditText e2 = (EditText) findViewById(R.id.password);
        
       
        login_butt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 String username = e1.getText().toString();
	        	 Intent main = new Intent(LoginScreen.this, MainMenu.class);
	        	 String password = "";
	        	 
	        	 if (username.matches("") || db.getUser(username)==null){
	        		 Toast.makeText(getApplicationContext(),
								"User not found!",
								Toast.LENGTH_SHORT).show();
				} else {
					password = db.getUser(username).getPassword();
					if (password.equals(e2.getText().toString()) && !(password.matches(""))) {
						 main.putExtra("username", username);
						 startActivity(main);
						 finish();
					} else {
		        		 Toast.makeText(getApplicationContext(),
									"Invalid password!",
									Toast.LENGTH_SHORT).show();
					}
				}

			}});
	} 


}
