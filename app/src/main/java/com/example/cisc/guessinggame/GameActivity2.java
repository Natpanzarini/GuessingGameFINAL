package com.example.cisc.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    TextView textScore;

    int correctAnswer;
    int answerGiven;
    int currentLevel = 1;
    int totalGuesses = 1;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

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


    }

    @Override
    public void onClick(View v)
    {

    }

    void updateScoreAndLevel(int totalGuesses)
    {
        if (totalGuesses == 1) {
            points += 3;
            textScore.setText("Score: " + points);
        } else if (totalGuesses == 2) {
            points += 2;
            textScore.setText("Score: " + points);
        } else {
            points++;
            textScore.setText("Score: " + points);
        }
    }
}
