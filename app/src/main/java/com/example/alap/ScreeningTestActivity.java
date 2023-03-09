package com.example.alap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class ScreeningTestActivity extends AppCompatActivity {
    ArrayList<String> fruitname = new ArrayList<>();
    ArrayList<String> newCelebNames = new ArrayList<>();
    HashMap<String, String> map = new HashMap<>();
    int index;
    Random random;
    String[] answers = new String[4];
    Button btn1, btn2, btn3, btn4, btnRestart;
    int points = 0;
    TextView tvPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening_test);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btnRestart = findViewById(R.id.btnRestart);
        tvPoints = findViewById(R.id.tvPoints);
        fruitname.add("jackfruit");
        fruitname.add("Mango");
        fruitname.add("Lichi");
        fruitname.add("Strawberry");
        fruitname.add("Guava");
        fruitname.add("Blackberry");
        fruitname.add("Banana");
        index = 0;
        Collections.shuffle(fruitname);
        random = new Random();
        generateQuestions(index);
    }
    private void generateQuestions(int index) {
        newCelebNames = (ArrayList<String>) fruitname.clone();
        newCelebNames.remove(index);
        Collections.shuffle(newCelebNames);
        int correctAnswerPosition = random.nextInt(4);
        for(int i=0; i < 4; i++){
            if(i == correctAnswerPosition){
                answers[i] = fruitname.get(index);
            } else{
                answers[i] = newCelebNames.get(i);
            }
        }
        btn1.setText(answers[0]);
        btn2.setText(answers[1]);
        btn3.setText(answers[2]);
        btn4.setText(answers[3]);
        btnRestart.setVisibility(View.GONE);
    }
    public void answerSelected(View view) {
        String answer = ((Button) view).getText().toString();
        if(answer.equals(fruitname.get(index))){
            points++;
            tvPoints.setText(points + "/7");
        }
        index++;
        if(index > fruitname.size() - 1){
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
            btnRestart.setVisibility(View.VISIBLE);
        } else{
            generateQuestions(index);
        }
    }
    public void restart(View view) {
        if(index > 6){
            index = 0;
            points = 0;
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
            tvPoints.setText(points + "/7");
            Collections.shuffle(fruitname);
        }
        generateQuestions(index);
    }

}