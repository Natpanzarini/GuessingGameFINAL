package com.example.cisc.guessinggame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Random rand = new Random();
    int r = rand.nextInt(3) + 1;
    int ourRandom = r;

    Animation wobble;

    Button button1;
    Button button2;
    Button button3;

    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView textScore;
    TextView textLevel;

    int correctAnswer;
    int answerGiven;
    int currentLevel = 1;
    int totalGuesses = 1;

    public static int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        wobble = AnimationUtils.loadAnimation(this, R.anim.wobble);

        button1 =(Button) findViewById(R.id.button1);
        button2 =(Button) findViewById(R.id.button2);
        button3 =(Button) findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        textScore =(TextView) findViewById(R.id.textScore);
        textScore.setText("Score: " + points);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button1:
                answerGiven = Integer.parseInt("" + button1.getText());
                if (answerGiven == ourRandom)
                {
                    button1.startAnimation(wobble);
                    Toast.makeText(getApplicationContext(), "Well Done!",Toast.LENGTH_SHORT).show();
                    updateScoreAndLevel(totalGuesses);
                    Intent i;
                    i = new Intent(this, GameActivity2.class);
                    startActivity(i);
                } else
                {
                    Toast.makeText(getApplicationContext(), "Sorry, incorrect", Toast.LENGTH_SHORT).show();
                    totalGuesses++;
                    button1.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.button2:
                answerGiven = Integer.parseInt("" + button2.getText());
                if(answerGiven==ourRandom)
                {
                    button2.startAnimation(wobble);
                    Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_SHORT).show();
                    updateScoreAndLevel(totalGuesses);
                    Intent i;
                    i = new Intent(this, GameActivity2.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(getApplicationContext(),"Sorry that's wrong", Toast.LENGTH_SHORT).show();
                    totalGuesses++;
                    button2.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.button3:
                answerGiven = Integer.parseInt("" + button3.getText());
                if(answerGiven==ourRandom)
                {
                    button3.startAnimation(wobble);
                    Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_SHORT).show();
                    updateScoreAndLevel(totalGuesses);
                    Intent i;
                    i = new Intent(this, GameActivity2.class);
                    startActivity(i);
                }else
                {
                    Toast.makeText(getApplicationContext(),"Sorry that's wrong", Toast.LENGTH_SHORT).show();
                    totalGuesses++;
                    button3.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }

    void updateScoreAndLevel(int totalGuesses)
    {
        if(totalGuesses == 1)
        {
            points+=3;
            textScore.setText("Score: " + points);
        }else if(totalGuesses == 2)
        {
            points+=2;
            textScore.setText("Score: " + points);
        }else
        {
            points++;
            textScore.setText("Score: " + points);
        }
    }
}
