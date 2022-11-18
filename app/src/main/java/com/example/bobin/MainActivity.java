package com.example.bobin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void explain (View view) {
        Intent intent =new Intent(MainActivity.this,explain.class);
        startActivity(intent);
    }
    public void single (View view) {
        Intent intent =new Intent(MainActivity.this,bobin.class);
        startActivity(intent);
    }
    public void multi (View view) {
        Intent intent =new Intent(MainActivity.this,multi.class);
        startActivity(intent);
    }
}
