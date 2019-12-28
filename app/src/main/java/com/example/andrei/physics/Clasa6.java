package com.example.andrei.physics;

import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import pl.droidsonroids.gif.GifImageView;

public class Clasa6 extends AppCompatActivity {
private int n=2,nri=0,nr,y,puncte,r;
    private Button[] bt;
    private TextView intr;
    private DBManager dbManager;
    int nrclasei;
    Intrebare[] intreb=new Intrebare[5000];
    TextView clasa;
    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasa6);

        nrclasei = getIntent().getExtras().getInt("nr");

        getIntrebari();


        nri = 0;

        clasa=(TextView)findViewById(R.id.textView5);
        if(nrclasei==6)
            clasa.setText("Clasa a VI-a");
        else if(nrclasei==7)
            clasa.setText("Clasa a VII-a");
        else if(nrclasei==8)
            clasa.setText("Clasa a VIII-a");
        else if(nrclasei==9)
            clasa.setText("Clasa a IX-a");
        else if(nrclasei==10)
            clasa.setText("Clasa a X-a");
        bt=new Button[4];
        bt[0]=(Button)findViewById(R.id.button4);
        bt[1]=(Button)findViewById(R.id.button7);
        bt[2]=(Button)findViewById(R.id.button8);
        bt[3]=(Button)findViewById(R.id.button9);
        bt[0].getBackground().setColorFilter(0xaaeeeeee, PorterDuff.Mode.MULTIPLY);
        bt[1].getBackground().setColorFilter(0xaaeeeeee, PorterDuff.Mode.MULTIPLY);
        bt[2].getBackground().setColorFilter(0xaaeeeeee, PorterDuff.Mode.MULTIPLY);
        bt[3].getBackground().setColorFilter(0xaaeeeeee, PorterDuff.Mode.MULTIPLY);
        intr=(TextView) findViewById(R.id.textView4);

        GifImageView gandire=(GifImageView) findViewById(R.id.gandire);
        gandire.setVisibility(View.VISIBLE);

        GifImageView gresit=(GifImageView) findViewById(R.id.gresit);
        gresit.setVisibility(View.INVISIBLE);

        GifImageView corect=(GifImageView) findViewById(R.id.corect);
        corect.setVisibility(View.INVISIBLE);

        ImageView viata1= (ImageView) findViewById(R.id.viata1);
        viata1.setVisibility(View.VISIBLE);

        ImageView viata2= (ImageView) findViewById(R.id.viata2);
        viata2.setVisibility(View.VISIBLE);

        intr.setText(intreb[nri].getIntrebare());

        bt[0].setText(intreb[nri].getRaspuns1());
        bt[1].setText(intreb[nri].getRaspuns2());
        bt[2].setText(intreb[nri].getRaspuns3());
        bt[3].setText(intreb[nri].getRaspuns4());
}
  public void apasa2(View v)
  {
      if(v.getId()==bt[intreb[nri].getCorect()-1].getId() && r==0 && y==0)
      {
          GifImageView corect=(GifImageView) findViewById(R.id.corect);
          corect.setVisibility(View.VISIBLE);

          GifImageView gandire=(GifImageView) findViewById(R.id.gandire);
          gandire.setVisibility(View.INVISIBLE);

          GifImageView gresit=(GifImageView) findViewById(R.id.gresit);
          gresit.setVisibility(View.INVISIBLE);

          puncte=puncte+10;
          r=1;
          TextView nv = (TextView) findViewById(R.id.textView8);
          nv.setText("Corect, treci mai departe!");
          y=1; //y se schimba ca sa se stie daca s-a raspuns corect la intrebare.
          if(n>=1)
          {
              bt[0].setVisibility(View.INVISIBLE);
              bt[1].setVisibility(View.INVISIBLE);
              bt[2].setVisibility(View.INVISIBLE);
              bt[3].setVisibility(View.INVISIBLE);
              bt[intreb[nri].getCorect()-1].setVisibility(View.VISIBLE);
              bt[intreb[nri].getCorect()-1].getBackground().setColorFilter(0xdd00ff00, PorterDuff.Mode.MULTIPLY);;
          }
      }
      else if(n>0 && r==0)
      {
          n--;
          if(n>=1)
          {
              TextView nv=(TextView) findViewById(R.id.textView8);
              nv.setText("Mai incearcă!");

              GifImageView gandire=(GifImageView) findViewById(R.id.gandire);
              gandire.setVisibility(View.INVISIBLE);

              GifImageView gresit=(GifImageView) findViewById(R.id.gresit);
              gresit.setVisibility(View.VISIBLE);

              new CountDownTimer(3200, 1000) {

                  public void onTick(long millisUntilFinished)
                  {
                  }

                  public void onFinish()
                  {
                      if(n>0 && y!=1)
                      {
                          GifImageView gandire=(GifImageView) findViewById(R.id.gandire);
                          gandire.setVisibility(View.VISIBLE);

                          GifImageView gresit=(GifImageView) findViewById(R.id.gresit);
                          gresit.setVisibility(View.INVISIBLE);

                          TextView nv=(TextView) findViewById(R.id.textView8);
                          nv.setText("");
                      }
                  }
              }
              .start();
              ImageView viata1= (ImageView) findViewById(R.id.viata1);
              viata1.setVisibility(View.INVISIBLE);

          }
          else if(n==0)
          {
              TextView nv=(TextView) findViewById(R.id.textView8);
              nv.setText("Nu mai ai vieți, varianta corectă este cea cu roşu.");

              bt[0].setVisibility(View.INVISIBLE);
              bt[1].setVisibility(View.INVISIBLE);
              bt[2].setVisibility(View.INVISIBLE);
              bt[3].setVisibility(View.INVISIBLE);
              bt[intreb[nri].getCorect()-1].setVisibility(View.VISIBLE);
              bt[intreb[nri].getCorect()-1].getBackground().setColorFilter(0xffff0000, PorterDuff.Mode.MULTIPLY);;
              y=1;

              GifImageView gandire=(GifImageView) findViewById(R.id.gandire);
              gandire.setVisibility(View.INVISIBLE);

              GifImageView gresit=(GifImageView) findViewById(R.id.gresit);
              gresit.setVisibility(View.VISIBLE);

              ImageView viata2= (ImageView) findViewById(R.id.viata2);
              viata2.setVisibility(View.INVISIBLE);
          }
      }
  }
    public void next(View v)
    {
        bt[intreb[nri].getCorect()-1].getBackground().setColorFilter(0xaaeeeeee, PorterDuff.Mode.MULTIPLY);
        if(y==1)
        {
            nri++;
        }
        if(nri==10 )
        {
            Intent i = new Intent(getBaseContext(), PaginaFinala.class);
            i.putExtra("punctaj", puncte);
            this.finish();
            startActivity(i);
            puncte=0;
        }
        else if(y==1)
        {

            n=2;
            r=0;
            y=0;

            TextView nrin=(TextView) findViewById(R.id.textView3);
            nrin.setText("Întrebarea "+(nri+1)+"/10:");

            GifImageView gandire=(GifImageView) findViewById(R.id.gandire);
            gandire.setVisibility(View.VISIBLE);

            GifImageView gresit=(GifImageView) findViewById(R.id.gresit);
            gresit.setVisibility(View.INVISIBLE);

            GifImageView corect=(GifImageView) findViewById(R.id.corect);
            corect.setVisibility(View.INVISIBLE);

            intr.setText(intreb[nri].getIntrebare());
            bt[0].setText(intreb[nri].getRaspuns1());
            bt[1].setText(intreb[nri].getRaspuns2());
            bt[2].setText(intreb[nri].getRaspuns3());
            bt[3].setText(intreb[nri].getRaspuns4());
            bt[0].setVisibility(View.VISIBLE);
            bt[1].setVisibility(View.VISIBLE);
            bt[2].setVisibility(View.VISIBLE);
            bt[3].setVisibility(View.VISIBLE);

            int e=0;

            if(intreb[nri].getRaspuns1().equals(" "))
                bt[0].setVisibility(View.INVISIBLE);
            else e++;
            if(intreb[nri].getRaspuns2().equals(" "))
                bt[1].setVisibility(View.INVISIBLE);
            else e++;
            if(intreb[nri].getRaspuns3().equals(" "))
                bt[2].setVisibility(View.INVISIBLE);
            else e++;
            if(intreb[nri].getRaspuns4().equals(" "))
                bt[3].setVisibility(View.INVISIBLE);
            else e++;
            if(e==2)
            {
                ImageView viata1= (ImageView) findViewById(R.id.viata1);
                viata1.setVisibility(View.INVISIBLE);

                ImageView viata2= (ImageView) findViewById(R.id.viata2);
                viata2.setVisibility(View.VISIBLE);
            }
            else
            {
                ImageView viata1= (ImageView) findViewById(R.id.viata1);
                viata1.setVisibility(View.VISIBLE);

                ImageView viata2= (ImageView) findViewById(R.id.viata2);
                viata2.setVisibility(View.VISIBLE);
            }
            TextView a=(TextView) findViewById(R.id.textView8);
            a.setText("");
        }
    }

    private void getIntrebari()
    {

        dbManager=new DBManager(this);
        String[] SelectionsArgs1={""+nrclasei};
        Cursor cursor=dbManager.query(null,"clasa=?",SelectionsArgs1,"RANDOM()");
        int i=0, c=0, j,t;
        String[] raspunsuri=new String[4];
        if(cursor.moveToFirst())
        {
            do
            {
                t=0;
                String[] SelectionsArgs={""+cursor.getInt(0)};
                Cursor cursor1=dbManager.query2(null,"id_intrebare=?",SelectionsArgs,"RANDOM()");
                if(cursor1.moveToFirst())
                {

                    do
                    {
                        raspunsuri[t]=cursor1.getString(1);
                        int corect=Integer.parseInt(cursor1.getString(3));
                        if (corect==1)
                        {
                            c=t+1;
                        } System.out.println(cursor1.getString(1)+" "+cursor1.getString(3)+" "+t+" "+c);
                        t++;

                    }
                    while(cursor1.moveToNext());
                }
                intreb[i]=new Intrebare(cursor.getString(1),"","","","",1);
                for(j=0;j<t;j++)
                {
                    switch (j)
                    {
                        case 0: intreb[i].setRaspuns1(raspunsuri[j]);
                        case 1: intreb[i].setRaspuns2(raspunsuri[j]);
                        case 2: intreb[i].setRaspuns3(raspunsuri[j]);
                        case 3: intreb[i].setRaspuns4(raspunsuri[j]);
                    }
                }
                intreb[i].setCorect(c);
                i++;
            }
            while(cursor.moveToNext());
            nr=i;
        }
        for(i=0;i<nr;i++)
        {
            System.out.println(intreb[i].getIntrebare());
        }
    }
    public void meniu(View v)
    {
        r=0;
        Intent i = new Intent(getBaseContext(), Clasa.class);
        this.finish();
        startActivity(i);
    }
}