package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    public int numberOfClicks = 0;
    public int resetPoints  = questions.points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vibe.vibrate(100);
                openQuiz();
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
    public void openQuiz(){
        resetPoints = 0;
        Intent intent = new Intent(this, questions.class);
        startActivity(intent);
    }
}