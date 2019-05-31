package com.example.kshitij.dd;

import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Locale;

public class five_left extends AppCompatActivity {

    GlobalClass globalClass;
    MediaPlayer mediaPlayer;
    Button left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_left);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        globalClass = (GlobalClass) getApplicationContext();

//        final int five_l = R.id.five_left;
        final int six = R.id.six;

        globalClass.setCounter(50);

        left = findViewById(R.id.next_five_left);
        Button mic = findViewById(R.id.mic);


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globalClass.setCounter(six);
                globalClass.setCompass_use(6);

                mediaPlayer.release();
                Intent intent = new Intent(five_left.this,levels.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.hold);
            }
        });


    }

    public void getSpeechInput(View view){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        startActivityForResult(intent,10);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if(resultCode == RESULT_OK && data != null){
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Intent intent = new Intent(five_left.this,die.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in,R.anim.hold);
                }
                else{
                    left.setVisibility(View.VISIBLE);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.next_sound);
                    mediaPlayer.start();
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(five_left.this,MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in,R.anim.hold);
        finish();
    }
}
