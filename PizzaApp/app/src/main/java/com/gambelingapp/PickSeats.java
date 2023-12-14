package com.gambelingapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;


public class PickSeats extends AppCompatActivity implements View.OnClickListener {
    String choice=null;
    int numberOfDiners = 0;

    Button next,skip;
    ImageButton s1, s2, s3, s4, s5, s6, s7, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_seats);
        next= findViewById(R.id.Next);
        skip= findViewById(R.id.Skip);
        s1 = findViewById(R.id.Seat1);
        s2 = findViewById(R.id.Seat2);
        s3 = findViewById(R.id.Seat3);
        s4 = findViewById(R.id.Seat4);
        s5 = findViewById(R.id.Seat5);
        s6 = findViewById(R.id.Seat6);
        s7 = findViewById(R.id.Seat7);
        t1 = findViewById(R.id.Table1);
        t2 = findViewById(R.id.Table2);
        t3 = findViewById(R.id.Table3);
        t4 = findViewById(R.id.Table4);
        t5 = findViewById(R.id.Table5);
        t6 = findViewById(R.id.Table6);
        t7 = findViewById(R.id.Table7);
        t8 = findViewById(R.id.Table8);
        t9 = findViewById(R.id.Table9);
        t10 = findViewById(R.id.Table10);
        t11 = findViewById(R.id.Table11);
        t12 = findViewById(R.id.Table12);
        t13 = findViewById(R.id.Table13);
        s1.setOnClickListener(this);
        s2.setOnClickListener(this);
        s3.setOnClickListener(this);
        s4.setOnClickListener(this);
        s5.setOnClickListener(this);
        s6.setOnClickListener(this);
        s7.setOnClickListener(this);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);
        t5.setOnClickListener(this);
        t6.setOnClickListener(this);
        t7.setOnClickListener(this);
        t8.setOnClickListener(this);
        t8.setOnClickListener(this);
        t9.setOnClickListener(this);
        t10.setOnClickListener(this);
        t11.setOnClickListener(this);
        t12.setOnClickListener(this);
        t13.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == next) {
            if (choice!=null) {
                Intent i = new Intent(getApplicationContext(), BookReservation.class);
                i.putExtra("Diners", numberOfDiners);
                startActivity(i);
            }
            //todo: else - dialog box saying "pick table or skip this step"
        }
        if (v == skip) {
            Intent i = new Intent(getApplicationContext(), Menu.class);
            i.putExtra("Diners",-1);
            startActivity(i);
        }
        if (v == s1) {
            choice = "s1";
            numberOfDiners = 1;
        }
        if (v == s2) {
            choice = "s2";
            numberOfDiners = 1;
        }
        if (v == s3) {
            choice = "s3";
            numberOfDiners = 1;
        }
        if (v == s4) {
            choice = "s4";
            numberOfDiners = 1;
        }
        if (v == s5) {
            choice = "s5";
            numberOfDiners = 1;
        }
        if (v == s6) {
            choice = "s6";
            numberOfDiners = 1;
        }
        if (v == s7) {
            choice = "s7";
            numberOfDiners = 1;
        }
        if (v == t1) {
            choice = "t1";
            numberOfDiners = 4;
        }
        if (v == t2) {
            choice = "t2";
            numberOfDiners = 4;
        }
        if (v == t3) {
            choice = "t3";
            numberOfDiners = 4;
        }
        if (v == t4) {
            choice = "t4";
            numberOfDiners = 4;
        }
        if (v == t5) {
            choice = "t5";
            numberOfDiners = 4;
        }
        if (v == t6) {
            choice = "t6";
            numberOfDiners = 4;
        }
        if (v == t7) {
            choice = "t7";
            numberOfDiners = 6;
        }
        if (v == t8) {
            choice = "t8";
            numberOfDiners = 2;
        }
        if (v == t9) {
            choice = "t9";
            numberOfDiners = 2;
        }
        if (v == t10) {
            choice = "t10";
            numberOfDiners = 2;
        }
        if (v == t11) {
            choice = "t11";
            numberOfDiners = 2;
        }
        if (v == t12) {
            choice = "t12";
            numberOfDiners = 4;
        }
        if (v == t13) {
            choice = "t13";
            numberOfDiners = 4;
        }
    }
}