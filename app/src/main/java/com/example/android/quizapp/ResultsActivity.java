package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();

        String userScore = intent.getStringExtra("score");
        TextView scoreDisplay = (TextView)findViewById(R.id.score);
        scoreDisplay.setText(userScore);

        LinearLayout qOneAnswer = (LinearLayout)findViewById(R.id.answerOneDisplay);
        LinearLayout qTwoAnswer = (LinearLayout) findViewById(R.id.answerTwoDisplay);
        LinearLayout qThreeAnswer = (LinearLayout) findViewById(R.id.answerThreeDisplay);
        LinearLayout qFourAnswer = (LinearLayout) findViewById(R.id.answerFourDisplay);
        LinearLayout qFiveAnswer = (LinearLayout) findViewById(R.id.answerFiveDisplay);
        LinearLayout qSixAnswer = (LinearLayout) findViewById(R.id.answerSixDisplay);
        LinearLayout qSevenAnswer = (LinearLayout) findViewById(R.id.answerSevenDisplay);
        LinearLayout qEightAnswer = (LinearLayout) findViewById(R.id.answerEightDisplay);

        displayResult(intent, qOneAnswer, "qOneAnswer");
        displayResult(intent, qTwoAnswer, "qTwoAnswer");
        displayResult(intent, qThreeAnswer, "qThreeAnswer");
        displayResult(intent, qFourAnswer, "qFourAnswer");
        displayResult(intent, qFiveAnswer, "qFiveAnswer");
        displayResult(intent, qSixAnswer, "qSixAnswer");
        displayResult(intent, qSevenAnswer, "qSevenAnswer");
        displayResult(intent, qEightAnswer, "qEightAnswer");
    }

    private void displayResult(Intent intent, LinearLayout layout, String name){

        Boolean result = intent.getBooleanExtra(name, false);
        if(result){
            layout.setBackgroundColor(Color.parseColor("#73AF03"));
        }
        else{
            layout.setBackgroundColor(Color.parseColor("#FF595E"));
        }
    }

    public void restartQuiz(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
