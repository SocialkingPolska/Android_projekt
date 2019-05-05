package com.example.projekt_maciek_adam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    public static String LOGOWANIE = "FALSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Logowanie = (Button) findViewById(R.id.zaloguj);
        Button Kalkulator = (Button) findViewById(R.id.kalkuator);
        Button O_Projekcie = (Button) findViewById(R.id.o_projekcie);


        Logowanie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Logowanie.class);
                startActivity(intent);
            }
        });

        Kalkulator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Kalkulator.class);
                startActivity(intent);
            }
        });

        O_Projekcie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, oProjekcie.class);
                startActivity(intent);
            }
        });


        if(LOGOWANIE.equals("TRUE")){
            Kalkulator.setEnabled(true);
            Log.d("Error", "Zmienna Logowanie: " + LOGOWANIE);
        } else {
            Kalkulator.setEnabled(false);
            Log.d("Error", "Zmienna Logowanie: " + LOGOWANIE);
        }
    }


    public void gotoEnd(View view) {
        new AlertDialog.Builder(this)
                .setMessage("Czy chcesz wyłączyć aplikację?")
                .setCancelable(false)
                .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Nie", null)
                .show();
    }


}
