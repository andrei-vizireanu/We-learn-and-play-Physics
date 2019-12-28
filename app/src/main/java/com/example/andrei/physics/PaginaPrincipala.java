package com.example.andrei.physics;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaginaPrincipala extends AppCompatActivity {
    DBManager dbManager;
    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principala);

        dbManager=new DBManager(this);
        insert();

    }

    public void apasa(View v)
    {
        Intent i = new Intent(getBaseContext(), Clasa.class);
        this.finish();
        startActivity(i);
    }
    public void insert()
    {
        dbManager.Delete(null,null);
        dbManager.Delete2(null,null);

        ContentValues values= new ContentValues();
        ContentValues values2= new ContentValues();

        BufferedReader reader = null;
        try
        {
            AssetManager assetManager = getAssets();
            InputStream input = assetManager.open("test.txt");
            reader = new BufferedReader(new InputStreamReader(input));
            String line;

            while ((line = reader.readLine()) != null)
            {
                StringTokenizer st=new StringTokenizer(line,";");
                values.put(DBManager.ColIntrebare,st.nextToken());

                String r1=st.nextToken();
                String r2=st.nextToken();
                String r3=st.nextToken();
                String r4=st.nextToken();
                int c=Integer.parseInt(st.nextToken());
                int clasa=Integer.parseInt(st.nextToken());
                values.put(DBManager.ColClasa,clasa);
                long ID=dbManager.insert(values);
                System.out.println(ID);
                //System.out.println(c);
                if(c==1)
                {
                values2.put(DBManager.ColRaspuns,r1);
                values2.put(DBManager.ColRaspunsCorect,"1");
                values2.put(DBManager.ColIDIntrebare,ID);
                dbManager.insert2(values2);
                values2.put(DBManager.ColRaspuns,r2);
                values2.put(DBManager.ColRaspunsCorect,"0");
                values2.put(DBManager.ColIDIntrebare,ID);
                dbManager.insert2(values2);
                values2.put(DBManager.ColRaspuns,r3);
                values2.put(DBManager.ColRaspunsCorect,"0");
                values2.put(DBManager.ColIDIntrebare,ID);
                dbManager.insert2(values2);
                values2.put(DBManager.ColRaspuns,r4);
                values2.put(DBManager.ColRaspunsCorect,"0");
                values2.put(DBManager.ColIDIntrebare,ID);
                dbManager.insert2(values2);
                }
                else if(c==2)
                {

                        values2.put(DBManager.ColRaspuns,r1);
                        values2.put(DBManager.ColRaspunsCorect,"0");
                        values2.put(DBManager.ColIDIntrebare,ID);
                        dbManager.insert2(values2);
                        values2.put(DBManager.ColRaspuns,r2);
                        values2.put(DBManager.ColRaspunsCorect,"1");
                        values2.put(DBManager.ColIDIntrebare,ID);
                        dbManager.insert2(values2);
                        values2.put(DBManager.ColRaspuns,r3);
                        values2.put(DBManager.ColRaspunsCorect,"0");
                        values2.put(DBManager.ColIDIntrebare,ID);
                        dbManager.insert2(values2);
                        values2.put(DBManager.ColRaspuns,r4);
                        values2.put(DBManager.ColRaspunsCorect,"0");
                        values2.put(DBManager.ColIDIntrebare,ID);
                        dbManager.insert2(values2);

                }
                else if(c==3)
                {

                    values2.put(DBManager.ColRaspuns,r1);
                    values2.put(DBManager.ColRaspunsCorect,"0");
                    values2.put(DBManager.ColIDIntrebare,ID);
                    dbManager.insert2(values2);
                    values2.put(DBManager.ColRaspuns,r2);
                    values2.put(DBManager.ColRaspunsCorect,"0");
                    values2.put(DBManager.ColIDIntrebare,ID);
                    dbManager.insert2(values2);
                    values2.put(DBManager.ColRaspuns,r3);
                    values2.put(DBManager.ColRaspunsCorect,"1");
                    values2.put(DBManager.ColIDIntrebare,ID);
                    dbManager.insert2(values2);
                    values2.put(DBManager.ColRaspuns,r4);
                    values2.put(DBManager.ColRaspunsCorect,"0");
                    values2.put(DBManager.ColIDIntrebare,ID);
                    dbManager.insert2(values2);

                }
                else if(c==4)
                {

                    values2.put(DBManager.ColRaspuns,r1);
                    values2.put(DBManager.ColRaspunsCorect,"0");
                    values2.put(DBManager.ColIDIntrebare,ID);
                    dbManager.insert2(values2);
                    values2.put(DBManager.ColRaspuns,r2);
                    values2.put(DBManager.ColRaspunsCorect,"0");
                    values2.put(DBManager.ColIDIntrebare,ID);
                    dbManager.insert2(values2);
                    values2.put(DBManager.ColRaspuns,r3);
                    values2.put(DBManager.ColRaspunsCorect,"0");
                    values2.put(DBManager.ColIDIntrebare,ID);
                    dbManager.insert2(values2);
                    values2.put(DBManager.ColRaspuns,r4);
                    values2.put(DBManager.ColRaspunsCorect,"1");
                    values2.put(DBManager.ColIDIntrebare,ID);
                    dbManager.insert2(values2);

                }

            }

        }
        catch (FileNotFoundException e)
        {
            Toast.makeText(this, "a" , Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }




    }
}
