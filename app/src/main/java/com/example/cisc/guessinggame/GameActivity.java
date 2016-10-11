package com.example.cisc.guessinggame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Random rand = new Random();
    int  ourRandom = rand.nextInt(3);

    Button button1 =(Button) findViewById(R.id.button1);
    Button button2 =(Button) findViewById(R.id.button2);
    Button button3 =(Button) findViewById(R.id.button3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        button1.setText("1");
        button2.setText("2");
        button3.setText("3");

    }

    @Override
    public void onClick(View v) {

        int answerGiven = 0;

        switch (v.getId()){

            case R.id.button1:

                answerGiven = Integer.parseInt("" + button1.getText());
                if (answerGiven == ourRandom){
                    Toast.makeText(getApplicationContext(), "Well Done!",Toast.LENGTH_LONG);
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry, incorrect", Toast.LENGTH_LONG);
                }
                break;

            case R.id.button2:
                //same as previous case but using the next button
                answerGiven = Integer.parseInt("" +
                        button2.getText());
                if(answerGiven==ourRandom) {
                    Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Sorry that's wrong", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.button3:
                //same as previous case but using the next button
                answerGiven = Integer.parseInt("" +
                        button3.getText());
                if(answerGiven==ourRandom) {
                    Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Sorry that's wrong", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
