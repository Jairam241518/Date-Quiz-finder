package com.example.quizapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.time.LocalDate;


public class questions extends AppCompatActivity {
    public Random rand = new Random();
    public Button startButton;
    public View v;
    public TextView monthTextView;
    public TextView pointsTextView;
    public Button optionOne;
    public Button optionTwo;
    public Button optionThree;
    public Button optionFour;
    public int j;
    public static int points;
    public Button endGameButton;
    public View screenView;
    public int numberOfClicks;
    public Vibrator vibe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        final Vibrator vibe = (Vibrator) questions.this.getSystemService(Context.VIBRATOR_SERVICE);

        monthTextView = findViewById(R.id.textView3);
        pointsTextView = findViewById(R.id.textView4);
        optionOne = findViewById(R.id.button2);
        optionTwo = findViewById(R.id.button3);
        optionThree = findViewById(R.id.button4);
        screenView = findViewById(R.id.background);
        optionFour = findViewById(R.id.button5);
        endGameButton = findViewById(R.id.button7);
        startButton = findViewById(R.id.button6);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(100);
                points=0;
                pointsTextView.setText(String.valueOf(0));
                startButton.setText("Restart");
                randomDateGenerator1();
            }
        });
    }
    @Override
    public void onBackPressed(){
        numberOfClicks++;
        if (numberOfClicks==100){
            super.onBackPressed();
        }
    }
    public void randomDateGenerator1(){
        LocalDate date = LocalDate.now();
        LocalDate randomDate1 = date.minusDays(rand.nextInt(36500));
        LocalDate randomDate2 = date.plusDays(rand.nextInt(36500));
        do{
            randomDate2 = date.plusDays(rand.nextInt(36500));
        }
        while(randomDate2.getDayOfWeek() == randomDate1.getDayOfWeek());
        LocalDate randomDate4 = date.plusDays(rand.nextInt(36500));
        do{
            randomDate4 = date.plusDays(rand.nextInt(36500));
        }
        while (randomDate4.getDayOfWeek() == randomDate1.getDayOfWeek() || randomDate4.getDayOfWeek() == randomDate2.getDayOfWeek());
        LocalDate randomDate3 = date.plusDays(rand.nextInt(36500));
        do{
            randomDate3 = date.plusDays(rand.nextInt(36500));
        }
        while(randomDate3.getDayOfWeek() == randomDate1.getDayOfWeek() || randomDate3.getDayOfWeek() == randomDate2.getDayOfWeek() || randomDate3.getDayOfWeek() == randomDate4.getDayOfWeek());
        int i = rand.nextInt(2);
        if(i == 0){
            monthTextView.setText(String.valueOf(randomDate1));
        }
        else{
            monthTextView.setText(String.valueOf(randomDate2));
        }
        j = rand.nextInt(4);
        switch (j){
            case 0:{
                if(i==0){
                    optionOne.setText(String.valueOf(randomDate1.getDayOfWeek()));
                    optionTwo.setText(String.valueOf(randomDate2.getDayOfWeek()));
                    optionThree.setText(String.valueOf(randomDate3.getDayOfWeek()));
                    optionFour.setText(String.valueOf(randomDate4.getDayOfWeek()));
                }
                else{
                    optionOne.setText(String.valueOf(randomDate2.getDayOfWeek()));
                    optionTwo.setText(String.valueOf(randomDate1.getDayOfWeek()));
                    optionThree.setText(String.valueOf(randomDate3.getDayOfWeek()));
                    optionFour.setText(String.valueOf(randomDate4.getDayOfWeek()));
                }
                break;
            }
            case 1:{
                if(i==0){
                    optionOne.setText(String.valueOf(randomDate2.getDayOfWeek()));
                    optionTwo.setText(String.valueOf(randomDate1.getDayOfWeek()));
                    optionThree.setText(String.valueOf(randomDate3.getDayOfWeek()));
                    optionFour.setText(String.valueOf(randomDate4.getDayOfWeek()));
                }
                else{
                    optionOne.setText(String.valueOf(randomDate1.getDayOfWeek()));
                    optionTwo.setText(String.valueOf(randomDate2.getDayOfWeek()));
                    optionThree.setText(String.valueOf(randomDate3.getDayOfWeek()));
                    optionFour.setText(String.valueOf(randomDate4.getDayOfWeek()));
                }
                break;

            }
            case 2:{
                if(i==0){
                    optionOne.setText(String.valueOf(randomDate3.getDayOfWeek()));
                    optionTwo.setText(String.valueOf(randomDate2.getDayOfWeek()));
                    optionThree.setText(String.valueOf(randomDate1.getDayOfWeek()));
                    optionFour.setText(String.valueOf(randomDate4.getDayOfWeek()));
                }
                else{
                    optionOne.setText(String.valueOf(randomDate3.getDayOfWeek()));
                    optionTwo.setText(String.valueOf(randomDate1.getDayOfWeek()));
                    optionThree.setText(String.valueOf(randomDate2.getDayOfWeek()));
                    optionFour.setText(String.valueOf(randomDate4.getDayOfWeek()));
                }
                break;
            }
            case 3:{
                if(i==0){
                    optionOne.setText(String.valueOf(randomDate4.getDayOfWeek()));
                    optionTwo.setText(String.valueOf(randomDate2.getDayOfWeek()));
                    optionThree.setText(String.valueOf(randomDate3.getDayOfWeek()));
                    optionFour.setText(String.valueOf(randomDate1.getDayOfWeek()));
                }
                else{
                    optionOne.setText(String.valueOf(randomDate4.getDayOfWeek()));
                    optionTwo.setText(String.valueOf(randomDate1.getDayOfWeek()));
                    optionThree.setText(String.valueOf(randomDate3.getDayOfWeek()));
                    optionFour.setText(String.valueOf(randomDate2.getDayOfWeek()));
                }
                break;
            }
        }
        answerChecker();
        endGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endGame();
            }
        });
    }
    public void answerChecker(){
        switch (j){
            case 0:{
                optionOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xff0000ff);
                        points = points+1;
                        randomDateGenerator1();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionThree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionFour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                break;
            }
            case 1:{
                optionOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xff0000ff);
                        points = points+1;
                        randomDateGenerator1();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionThree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionFour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                break;
            }
            case 2:{
                optionOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionThree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xff0000ff);
                        points = points+1;
                        randomDateGenerator1();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionFour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                break;
            }
            case 3:{
                optionOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionThree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xffffff00);
                        endGame();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                optionFour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        screenView.setBackgroundColor(0xff0000ff);
                        points = points+1;
                        randomDateGenerator1();
                        pointsTextView.setText(String.valueOf(points));
                    }
                });
                break;
            }

        }



    }
    public void endGame(){
        Intent intent = new Intent(this, finalScore.class);
        startActivity(intent);
    }




}
