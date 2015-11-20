package com.example.food_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_app.DatabaseClasses.Restaurant;

/**
 * Created by Matt on 2015-11-18.
 */
public class RestaurantView extends Activity {
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_view);
        TextView rname =  (TextView) findViewById (R.id.rNameText);
        TextView rAddress =  (TextView) findViewById (R.id.rAddressText);
        TextView rCode =  (TextView) findViewById (R.id.rCodeText);

        Restaurant thisRest = ((Restaurant) getIntent().getExtras().getSerializable("resto"));
        rname.setText(thisRest.getRname());
        rAddress.setText(thisRest.getAddress());
        rCode.setText(thisRest.getPostalCode());
        final String rid = thisRest.getRid();
        
        
        
        Button add_dish = (Button)findViewById(R.id.add_dish_to_rest);
        add_dish.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View v) {
				Intent dish = new Intent(RestaurantView.this, AddDish.class);
				dish.putExtra("rid", rid);
				startActivity(dish);
			}
		});
        

    }
}
