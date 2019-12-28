package com.example.andrei.physics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Help extends AppCompatActivity {
    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }
    public void meniu(View v)
    {
        Intent i = new Intent(getBaseContext(), Clasa.class);
        this.finish();
        startActivity(i);
    }
}
