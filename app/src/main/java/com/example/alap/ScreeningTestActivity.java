package com.example.alap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class ScreeningTestActivity extends AppCompatActivity {

    private TextView countdownText;
    private Button startButton;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening_test);

        Button startbutton=(Button)findViewById(R.id.button);
        countdownText = findViewById(R.id.countdown_text);
        timeLeftInMillis = 10000;

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        };


        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            
            

            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),QuestionsActivity.class);
                startActivity(intent);
                countDownTimer.start();
            }
        });

    }

    private void updateCountdownText() {
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format("%02d", seconds);
        countdownText.setText(timeLeftFormatted);
    }
}