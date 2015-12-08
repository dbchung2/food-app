package com.example.food_app;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import com.example.food_app.DatabaseClasses.MySQLiteHelper;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
	private ImageView image;
		private static int LOAD_IMAGE_RESULTS = 1;

		@Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);
        
        final String rid = getIntent().getExtras().getString("rid");
				image = (ImageView)findViewById(R.id.imageView);
        username = getIntent().getStringExtra("username");
        Button submit_add = (Button)findViewById(R.id.submitToAddDish);

		
        submit_add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
					dishName = ((EditText)findViewById(R.id.menuname)).getText().toString();
					price = Double.parseDouble(((EditText)findViewById(R.id.addDishPrice)).getText().toString());
					category = ((EditText) findViewById(R.id.category)).getText().toString();
				//Add dish based on info given by user
				db.addDish(rid, dishName, category, price, ((BitmapDrawable)image.getDrawable()).getBitmap());

				
				
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

	public void addImage(View view){
			Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(i, LOAD_IMAGE_RESULTS);
	}
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
				super.onActivityResult(requestCode, resultCode, data);

				// Here we need to check if the activity that was triggers was the Image Gallery.
				// If it is the requestCode will match the LOAD_IMAGE_RESULTS value.
				// If the resultCode is RESULT_OK and there is some data we know that an image was picked.
				if (requestCode == LOAD_IMAGE_RESULTS && resultCode == RESULT_OK && data != null) {
						// Let's read picked image data - its URI
						Uri pickedImage = data.getData();
						// Let's read picked image path using content resolver
						String[] filePath = { MediaStore.Images.Media.DATA };
						Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
						cursor.moveToFirst();
						String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

						// Now we need to set the GUI ImageView data with data read from the picked file.
						image.setImageBitmap(BitmapFactory.decodeFile(imagePath));

						// At the end remember to close the cursor or you will end with the RuntimeException!
						cursor.close();
				}
		}

}
