package me.farhanarnob.materialdesign;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> country;
    ArrayAdapter<String> arrayAdapter;
    private AppCompatSpinner appCompatSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setBackgroundColor(Color.RED);

        // initializing
        countryListInitializingAndAddSomeValue();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, country);
        appCompatSpinner = (AppCompatSpinner) findViewById(R.id.spinner_toolbar);


        // add adapter to the spinner list
        appCompatSpinner.setAdapter(arrayAdapter);

        

        //giving custom toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);


    }

    private void countryListInitializingAndAddSomeValue() {
        country = new ArrayList<>();
        country.add("Bangladesh");
        country.add("India");
        country.add("Bhutan");
        country.add("Maldip");
    }

    //giving menu into the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_for_activity_main_page, menu);
        return true;
    }

    // menu item click option has been added here.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_about_us:
                Toast.makeText(MainActivity.this, "You have been clicked about us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_setting:
                Toast.makeText(MainActivity.this, "You have been clicked setting", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
