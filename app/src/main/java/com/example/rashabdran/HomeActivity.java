package com.example.rashabdran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void skin(View view) {
        Intent i;
        i = new Intent(this,skincareActivity.class);
        startActivity(i);

    }

    public void skinCare(View view) {
        Intent i;
        i = new Intent(this,skincareActivity.class);
        startActivity(i);

    }
}