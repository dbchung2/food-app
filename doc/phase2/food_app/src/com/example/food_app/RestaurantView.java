package com.example.food_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

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

    }
}
