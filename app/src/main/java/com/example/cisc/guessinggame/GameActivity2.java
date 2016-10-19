package com.example.cisc.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    Animation wobble;
    TextView textScore;

    int correctAnswer;
    int answerGiven;
    int currentLevel = 1;
    int totalGuesses = 1;

    Random rand = new Random();
    int r = rand.nextInt(5) + 1;
    int ourRandom = r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        wobble = AnimationUtils.loadAnimation(this, R.anim.wobble);

        button1 =(Button) findViewById(R.id.button1);
        button2 =(Button) findViewById(R.id.button2);
        button3 =(Button) findViewById(R.id.button3);
        button4 =(Button) findViewById(R.id.button4);
        button5 =(Button) findViewById(R.id.button5);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

        textScore =(TextView) findViewById(R.id.textScore);
        textScore.setText("Score: " + GameActivity.points);


    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.button1:
                answerGiven = Integer.parseInt("" + button1.getText());
                if (answerGiven == ourRandom) {
                    button1.startAnimation(wobble);
                    Toast.makeText(getApplicationContext(), "Well Done!", Toast.LENGTH_SHORT).show();
                    updateScoreAndLevel(totalGuesses);
                    Intent i;
                    i = new Intent(this, GameActivity3.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry, incorrect", Toast.LENGTH_SHORT).show();
                    totalGuesses++;
                    button1.setVisibility(View.INVISIBLE);
                }
                break;
        }
        switch (v.getId()) {
            case R.id.button2:
                answerGiven = Integer.parseInt("" + button2.getText());
                if (answerGiven == ourRandom) {
                    button2.startAnimation(wobble);
                    Toast.makeText(getApplicationContext(), "Well Done!", Toast.LENGTH_SHORT).show();
                    updateScoreAndLevel(totalGuesses);
                    Intent i;
                    i = new Intent(this, GameActivity3.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry, incorrect", Toast.LENGTH_SHORT).show();
                    totalGuesses++;
                    button2.setVisibility(View.INVISIBLE);
                }
                break;
        }
        switch (v.getId()) {
            case R.id.button3:
                answerGiven = Integer.parseInt("" + button3.getText());
                if (answerGiven == ourRandom) {
                    button3.startAnimation(wobble);
                    Toast.makeText(getApplicationContext(), "Well Done!", Toast.LENGTH_SHORT).show();
                    updateScoreAndLevel(totalGuesses);
                    Intent i;
                    i = new Intent(this, GameActivity3.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry, incorrect", Toast.LENGTH_SHORT).show();
                    totalGuesses++;
                    button3.setVisibility(View.INVISIBLE);
                }
                break;
        }
        switch (v.getId()) {
            case R.id.button4:
                answerGiven = Integer.parseInt("" + button4.getText());
                if (answerGiven == ourRandom) {
                    button4.startAnimation(wobble);
                    Toast.makeText(getApplicationContext(), "Well Done!", Toast.LENGTH_SHORT).show();
                    updateScoreAndLevel(totalGuesses);
                    Intent i;
                    i = new Intent(this, GameActivity3.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry, incorrect", Toast.LENGTH_SHORT).show();
                    totalGuesses++;
                    button4.setVisibility(View.INVISIBLE);
                }
                break;
        }
        switch (v.getId()) {
            case R.id.button5:
                answerGiven = Integer.parseInt("" + button5.getText());
                if (answerGiven == ourRandom) {
                    button5.startAnimation(wobble);
                    Toast.makeText(getApplicationContext(), "Well Done!", Toast.LENGTH_SHORT).show();
                    updateScoreAndLevel(totalGuesses);
                    Intent i;
                    i = new Intent(this, GameActivity3.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry, incorrect", Toast.LENGTH_SHORT).show();
                    totalGuesses++;
                    button5.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }

    void updateScoreAndLevel(int totalGuesses)
    {
        if (totalGuesses == 1) {
            GameActivity.points += 5;
            textScore.setText("Score: " +GameActivity.points);
        } else if (totalGuesses == 2) {
            GameActivity.points += 4;
            textScore.setText("Score: " + GameActivity.points);
        } else if (totalGuesses == 3){
            GameActivity.points += 3;
            textScore.setText("Score: " + GameActivity.points);
        } else if (totalGuesses == 4){
            GameActivity.points += 2;
            textScore.setText("Score: " + GameActivity.points);
        } else {
            GameActivity.points++;
            textScore.setText("Score: " + GameActivity.points);
        }
    }
}
