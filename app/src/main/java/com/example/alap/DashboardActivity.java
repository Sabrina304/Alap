package com.example.alap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {
    CardView articleCard;
    CardView checkCard;
    CardView reminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        articleCard = findViewById(R.id.articleCard);
        articleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ArticleActivity.class);
                startActivity(intent);

            }
        });

        checkCard = findViewById(R.id.checkCard);
        checkCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CheckyourselfActivity.class);
                startActivity(intent);
            }
        });





    }
}