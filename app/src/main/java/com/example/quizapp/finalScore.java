package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finalScore extends AppCompatActivity {
    public int pointsFinal = questions.points;
    public TextView finalPoints;
    public Button goHomeButton;
    public int numberOfClicks = 0;
    public Vibrator vibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);
        final Vibrator vibe = (Vibrator) finalScore.this.getSystemService(Context.VIBRATOR_SERVICE);
        finalPoints = findViewById(R.id.textView5);
        finalPoints.setText(String.valueOf(pointsFinal));
        goHomeButton = findViewById(R.id.button8);
        goHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(100);
                goHome();
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
    public void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}