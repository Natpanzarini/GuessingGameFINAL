package com.example.cisc.guessinggame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String dataName = "MyData";
    String intName = "MyString";
    int defaultInt = 0;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    int hiScore = 0;
    TextView textScore;

        private SoundPool soundPool;
        int sample1 = -1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            prefs = getSharedPreferences(dataName,MODE_PRIVATE);
            editor = prefs.edit();
            hiScore = prefs.getInt(intName, defaultInt);

        if(GameActivity.points > hiScore) {
            hiScore = GameActivity.points;
            editor.putInt(intName, hiScore);
            editor.commit();
            Toast.makeText(getApplicationContext(), "New Hi-score!!", Toast.LENGTH_LONG).show();
        }else{
            textScore =(TextView) findViewById(R.id.textScore);
            textScore.setText("Score: " + GameActivity.points);
        }

        TextView textHighScore =(TextView) findViewById(R.id.textHighScore);
        textHighScore.setText("High Score: "+ hiScore);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        try {
            //Create objects of the 2 required classes
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;
            //create our one fx in memory ready for use
            descriptor = assetManager.openFd("StartSound.wav");
            sample1 = soundPool.load(descriptor, 0);
        } catch (IOException e) {
            Context context = getApplicationContext();
            CharSequence text = "Not Found";
            int duration = Toast.LENGTH_SHORT;
        }
    }

    @Override
    public void onClick(View v) {
        //Play sample 1
        soundPool.play(sample1, 1, 1, 0, 0, 1);
        Intent i;
        i = new Intent(this, GameActivity.class);
        startActivity(i);
        }
    }
