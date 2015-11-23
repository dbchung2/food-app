package com.example.food_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.food_app.DatabaseClasses.MySQLiteHelper;

import java.util.ArrayList;

/**
 * Created by Matt on 2015-11-22.
 */
public class SpentView extends Activity {
    MySQLiteHelper db = new MySQLiteHelper(this);
    String username;
    ArrayList<String> cats;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spent);
        username = getIntent().getStringExtra("username");
        populateList();

    }
    public void populateList(){

        setContentView(R.layout.activity_spent);
        String cat = this.getIntent().getStringExtra("cat");
        cats = db.getSpentByCategory(username, cat);

        listView = (ListView)findViewById(R.id.listView1);

        //Insert Array here
        if(cats!=null){
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cats);
            listView.setAdapter(adapter);
        }
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

}
