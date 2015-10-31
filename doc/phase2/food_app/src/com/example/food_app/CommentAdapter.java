package com.example.food_app;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CommentAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final ArrayList<String> commentsArrayList;
	
	public CommentAdapter(Context context, ArrayList<String> commentsArrayList) {
		super(context, R.layout.comment_row, commentsArrayList);
		
		this.context = context;
		this.commentsArrayList = commentsArrayList;
	}
	
	//will create inflater and populate rows
	/*public View getView(int position, View convertView, ViewGroup parent) {
		
	}*/

}
