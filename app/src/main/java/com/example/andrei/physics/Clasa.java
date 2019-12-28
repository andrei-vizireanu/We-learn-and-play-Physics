package com.example.andrei.physics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Clasa extends AppCompatActivity {
    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasa);
    }
    public void apasa(View v)
    {
        Intent i = new Intent(getBaseContext(), Clasa6.class);
        i.putExtra("nr", 6);
        this.finish();
        startActivity(i);
    }
    public void apasa4(View v)
    {
        Intent i = new Intent(getBaseContext(), Clasa6.class);
        i.putExtra("nr", 7);
        startActivity(i);
        this.finish();
    }
    public void apasa5(View v)
    {
        Intent i = new Intent(getBaseContext(), Clasa6.class);
        i.putExtra("nr", 8);
        startActivity(i);
        this.finish();
    }
    public void apasa6(View v)
    {
        Intent i = new Intent(getBaseContext(), Clasa6.class);
        i.putExtra("nr", 9);
        startActivity(i);
        this.finish();
    }
    public void apasa7(View v)
    {
        Intent i = new Intent(getBaseContext(), Clasa6.class);
        i.putExtra("nr", 10);
        startActivity(i);
        this.finish();
    }
    public void apasa2(View v)
    {
        this.finish();
        System.exit(0);
    }
    public void apasa3(View v)
    {
        Intent i = new Intent(getBaseContext(), Help.class);
        this.finish();
        startActivity(i);
    }
}