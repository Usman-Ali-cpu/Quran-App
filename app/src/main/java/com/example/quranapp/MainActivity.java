package com.example.quranapp;
import data.QuranArabicText;
import data.Data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText surrahnotext;
    EditText ayyatnotext;
    Button search;
    TextView displayText;
    Button next;
    Button previous;
    int ayyatindex =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surrahnotext = findViewById(R.id.surrahNo);
        ayyatnotext = findViewById(R.id.ayyatno);
        displayText = findViewById(R.id.displaytext);
        search = findViewById(R.id.btn1);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.prev);





        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int surrah = Integer.parseInt(surrahnotext.getText().toString());


                int ayyat = Integer.parseInt(ayyatnotext.getText().toString());
                QuranArabicText quran = new QuranArabicText();
                Data qdata = new Data();
                int surrahindex = 0;
                if(surrah >= 1 && surrah <=114){
                    surrahindex = qdata.SSP[surrah-1];
                }
                ayyatindex = surrahindex + ayyat;
                displayText.setText(quran.QuranArabicText[ayyatindex]);

            }
        });
        next.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                QuranArabicText quran = new QuranArabicText();
                Data qdata = new Data();
                ayyatindex++;
                displayText.setText(quran.QuranArabicText[ayyatindex]);
            }
        });

        previous.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                QuranArabicText quran = new QuranArabicText();
                Data qdata = new Data();
                ayyatindex--;
                displayText.setText(quran.QuranArabicText[ayyatindex]);
            }
        });










    }

}