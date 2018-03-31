package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalScore;
    boolean qOne;
    boolean qTwo;
    boolean qThree;
    boolean qFour;
    boolean qFive;
    boolean qSix;
    boolean qSeven;
    boolean qEight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayScore(View view){
        totalScore = 0;
        calculateScore();
        Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
        intent.putExtra("score", String.valueOf(totalScore));
        intent.putExtra("qOneAnswer", qOne);
        intent.putExtra("qTwoAnswer", qTwo);
        intent.putExtra("qThreeAnswer", qThree);
        intent.putExtra("qFourAnswer", qFour);
        intent.putExtra("qFiveAnswer", qFive);
        intent.putExtra("qSixAnswer", qSix);
        intent.putExtra("qSevenAnswer", qSeven);
        intent.putExtra("qEightAnswer", qEight);
        startActivity(intent);
    }

    private void calculateScore(){
        getQuestionOneScore();
        getQuestionTwoScore();
        getQuestionThreeScore();
        getQuestionFourScore();
        getQuestionFiveScore();
        getQuestionSixScore();
        getQuestionSevenScore();
        getQuestionEightScore();
    }
    private void getQuestionOneScore(){

        RadioButton borough = (RadioButton)findViewById(R.id.fiveBoroughs);
        boolean correctAnswer = borough.isChecked();
        if(correctAnswer){
            qOne = true;
            totalScore += 1;
        }
        else {
            qOne = false;
        }
    }
    private void getQuestionTwoScore(){

        EditText questionTwo = (EditText) findViewById(R.id.island);
        String answer = questionTwo.getText().toString().toLowerCase();
        if(answer.equals("bronx") || answer.equals("bronx ") || answer.equals("the bronx") || answer.equals("the bronx ")){
            qTwo = true;
            totalScore += 1;
        }
        else {
            qTwo = false;
        }
    }

    private void getQuestionThreeScore(){
        CheckBox optionSubway = (CheckBox) findViewById(R.id.subwayCheckBox);
        CheckBox optionTram = (CheckBox) findViewById(R.id.tramCheckBox);
        CheckBox optionMaglev = (CheckBox) findViewById(R.id.maglevCheckBox);
        CheckBox optionBus = (CheckBox) findViewById(R.id.busCheckBox);
        CheckBox optionFerry = (CheckBox) findViewById(R.id.ferryCheckBox);

        if(optionSubway.isChecked() && optionTram.isChecked() && !optionMaglev.isChecked() && optionBus.isChecked() && optionFerry.isChecked()){
            qThree = true;
            totalScore += 1;
        }
        else {
            qThree = false;
        }
    }

    private void getQuestionFourScore() {
        CheckBox optionG = (CheckBox) findViewById(R.id.gline);
        CheckBox optionH = (CheckBox) findViewById(R.id.hline);
        CheckBox optionV = (CheckBox) findViewById(R.id.vline);
        CheckBox optionZ = (CheckBox) findViewById(R.id.zline);

        if (optionG.isChecked() && !optionH.isChecked() && !optionV.isChecked() && optionZ.isChecked()) {
            qFour = true;
            totalScore += 1;
        }
        else{
            qFour = false;
        }
    }

    private void getQuestionFiveScore(){
        RadioButton store = (RadioButton)findViewById(R.id.walmart);
        boolean correctAnswer = store.isChecked();
        if(correctAnswer){
            qFive = true;
            totalScore += 1;
        }
        else {
            qFive = false;
        }
    }

    private void getQuestionSixScore(){
        RadioButton lifeForm = (RadioButton)findViewById(R.id.lifeFormTrue);
        boolean correctAnswer = lifeForm.isChecked();
        if(correctAnswer){
            qSix = true;
            totalScore += 1;
        }
        else {
            qSix = false;
        }
    }

    private void getQuestionSevenScore(){
        RadioButton plantTree = (RadioButton)findViewById(R.id.treeTrue);
        boolean correctAnswer = plantTree.isChecked();
        if(correctAnswer){
            qSeven = true;
            totalScore += 1;
        }
        else {
            qSeven = false;
        }
    }

    private void getQuestionEightScore(){
        RadioButton languageQ = (RadioButton)findViewById(R.id.langFalse);
        boolean correctAnswer = languageQ.isChecked();
        if(correctAnswer){
            qEight = true;
            totalScore += 1;
        }
        else {
            qEight = false;
        }
    }
}
