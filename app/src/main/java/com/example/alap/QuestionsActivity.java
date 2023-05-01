package com.example.alap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    ImageView ivQuestion;
    int currentQuestion = 0;
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private int[] questionImages = {
            R.drawable.clock,
            R.drawable.difpic,
            R.drawable.shapes,
            R.drawable.dial,
            R.drawable.table,
            R.drawable.rain,

    };

    String questions[] = {
            "What time is it in the clock??",
            "Which Picture is different from others?",
            "Which shape is different from others",
            "Which part incompletes the clock?",
            "12*4 = ?",
            "Rahim has to go for buying a shirt but it's raining outside and he" +
                    "doesn't have umbrella.Weather forecasts says it will stop in" +
                    "1 hours. Then what can he do? ",




    };
    String answers[] = {"10 am/pm","D","C","Minute & Hour Dial","48","Wait for 2 hour"};
    String opt[] = {
            "10 am/pm","12 am/pm","7 am/pm","9 am/pm",
            "A","B","C","D",
            "A","B","C","D",
            "No Dial","Second & Hour Dial","Second & Minute Dial","Minute & Hour Dial",
            "46","35","48","50",
            "Wait for 1 hour","Order online","Buy a umbrella","Sleep",

    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);


        final TextView score = (TextView)findViewById(R.id.textView4);
        Intent intent = getIntent();



        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        ivQuestion = findViewById(R.id.ivQuestion);
        tv=(TextView) findViewById(R.id.tvque);

        ivQuestion.setImageResource(questionImages[flag]);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // currentQuestion++;

                //if (currentQuestion >= questionImages.length) {
                //    currentQuestion = 0;
                //}
               // ivQuestion.setImageResource(questionImages[currentQuestion]);


                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;

                }
                else {
                    wrong++;

                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {

                    ivQuestion.setImageResource(questionImages[flag]);
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}