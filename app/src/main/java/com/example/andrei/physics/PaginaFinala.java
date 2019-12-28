package com.example.andrei.physics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PaginaFinala extends AppCompatActivity {
    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_finala);
        int b = getIntent().getExtras().getInt("punctaj");
        TextView a=(TextView) findViewById(R.id.textView9);
        a.setText(""+b);

    }
    public void apasa(View v)
    {
        Intent i = new Intent(getBaseContext(), Clasa.class);
        finish();
        startActivity(i);
    }
}
