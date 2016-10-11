package com.example.cisc.guessinggame;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SoundPool soundPool;
    int sample1 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Intent i;
        i = new Intent(this, GameActivity.class);
        startActivity(i);
        switch (v.getId()) {
            case R.id.button://when the first button is pressed
                //Play sample 1
                soundPool.play(sample1, 1, 1, 0, 0, 1);
                break;
        }
    }
}
