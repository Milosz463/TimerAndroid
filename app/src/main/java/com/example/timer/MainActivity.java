package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textViewCzas;
TextView textViewWynik;
Button buttonStart;
Button buttonPauza;
Button buttonReset;
Button buttonZapisz;
String czasDowyswietlenia;
String zapisaneCzasy="zapisane czasy:";
int sekundy=0;
boolean czyDziala=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCzas=findViewById(R.id.TextViewSigma);
        textViewWynik=findViewById(R.id.textView);
        buttonStart=findViewById(R.id.button5);
        buttonPauza=findViewById(R.id.button6);
        buttonReset=findViewById(R.id.button7);
        buttonZapisz=findViewById(R.id.button8);

        idzieCzas();
        buttonStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyDziala=true;
                    }
                }
        );
        buttonReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sekundy=0;
                    }
                }
        );
        buttonPauza.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyDziala=false;
                    }
                }
        );
        buttonZapisz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zapisaneCzasy=zapisaneCzasy+czasDowyswietlenia+"\n";
                        textViewWynik.setText(zapisaneCzasy);
                    }
                }
        );
    }

    private void idzieCzas(){
        Handler handler=new Handler();
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if(czyDziala) {

                            sekundy++;
                            int g60 = sekundy / 3600;
                            int s60 = sekundy % 60;
                            int m60 = (sekundy - g60 * 3600) / 60;
                            czasDowyswietlenia = String.format("%02d:%02d:%02d", g60, m60, s60);
                            textViewCzas.setText(String.valueOf(sekundy));

                            textViewCzas.setText(czasDowyswietlenia); }
                            handler.postDelayed(this, 1000);

                    }
                }
        );
    }
}