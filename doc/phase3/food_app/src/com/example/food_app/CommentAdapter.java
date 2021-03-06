package com.example.food_app;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CommentAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;
    private final ArrayList<String> foods;
    
    public CommentAdapter(Context context, ArrayList<String> allreviews,  ArrayList<String> dishnames) {
        super(context, R.layout.comment_row, allreviews);
        
        this.context = context;
        this.values = allreviews;
        this.foods = dishnames;
    }
    
    //will create inflater and populate rows
    public View getView(int position, View convertView, ViewGroup parent) {
        //Create Inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        //Get rowView
        View rowView = inflater.inflate(R.layout.comment_row, parent, false);
        
        //Get the textview from rowView
        TextView comment = (TextView) rowView.findViewById(R.id.description);
        TextView food = (TextView) rowView.findViewById(R.id.food_name);
        
        //Set the text
        comment.setText(values.get(position));
        food.setText(foods.get(position));
        
        return rowView;
    }

}
