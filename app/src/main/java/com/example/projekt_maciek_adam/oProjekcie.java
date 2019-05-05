package com.example.projekt_maciek_adam;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import static com.example.projekt_maciek_adam.MainActivity.LOGOWANIE;

public class oProjekcie extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_projekcie);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        b1 = (Button)findViewById(R.id.kalkuator);
        if(LOGOWANIE.equals("TRUE")){
            Log.d("Error", "Zmienna Logowanie: "+LOGOWANIE);
        } else Log.d("Error", "Zmienna Logowanie: " + LOGOWANIE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.layout.activity_main:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
