package com.example.projekt_maciek_adam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.projekt_maciek_adam.MainActivity.LOGOWANIE;

public class Logowanie extends AppCompatActivity {

    Button b1,b2;
    EditText ed1,ed2;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        b1 = (Button)findViewById(R.id.logowanie_log);
        b2 = (Button)findViewById(R.id.logout);
        ed1 = (EditText)findViewById(R.id.konto);
        ed2 = (EditText)findViewById(R.id.haslo);
        t1 = (TextView)findViewById(R.id.textView2);
        t2 = (TextView)findViewById(R.id.textView3);

        if(LOGOWANIE.equals("TRUE")){
            t1.setVisibility(View.GONE);
            t2.setVisibility(View.GONE);
            ed1.setVisibility(View.GONE);
            ed2.setVisibility(View.GONE);
            b1.setVisibility(View.GONE);
        } else {
            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
            ed1.setVisibility(View.VISIBLE);
            ed2.setVisibility(View.VISIBLE);
            b1.setVisibility(View.VISIBLE);
        }

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(LOGOWANIE.equals("TRUE")){
                    LOGOWANIE = "FALSE";
                    Intent intent = new Intent(Logowanie.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("admin") &&
                   ed2.getText().toString().equals("admin")) {
                    Toast.makeText(Logowanie.this, "Hasło prawidłowe", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Logowanie.this, MainActivity.class);
                    startActivity(intent);
                    LOGOWANIE = "TRUE";
                    Log.d("Error", "Zmienna Logowanie: "+LOGOWANIE);
                }else{
                    Toast.makeText(Logowanie.this, "Hasło złe", Toast.LENGTH_SHORT).show();
                    LOGOWANIE = "FALSE";
                    Log.d("Error", "Zmienna Logowanie: "+LOGOWANIE);
                }
            }
        });

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

    public void gotoEnd(View view) {
        new AlertDialog.Builder(this)
                .setMessage("Czy chcesz wyłączyć aplikację?")
                .setCancelable(false)
                .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Logowanie.super.onBackPressed();
                    }
                })
                .setNegativeButton("Nie", null)
                .show();
    }
}
