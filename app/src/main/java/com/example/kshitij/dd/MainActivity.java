package com.example.kshitij.dd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.mtp.MtpStorageInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button rules;
    TextView answerView;

    GlobalClass globalClass;

    MediaPlayer mediaPlayer;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music);
        mediaPlayer.start();
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(globalClass.getCounter() == 50){
                    Intent intent = new Intent(MainActivity.this,five_left.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in,R.anim.hold);
                }
                else if(globalClass.getCounter() == 51) {
                    Intent intent = new Intent(MainActivity.this,five_right.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in,R.anim.hold);
                }

                else{
                Intent intent = new Intent(MainActivity.this, levels.class);
                startActivity(intent);
//                intent.putExtra("key",counter);
//                startActivityForResult(intent,42);
                overridePendingTransition(R.anim.fade_in, R.anim.hold);}
            }
        });

//            loadData();
//            updateData();

        rules = findViewById(R.id.rules);

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,rules.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.hold);
            }
        });

    }
//        Toast.makeText(this, number, Toast.LENGTH_SHORT).show();


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        switch(requestCode){
//            case 42:
//                int answer = data.getIntExtra("result",0);
//                TextView answerview = (TextView) findViewById(R.id.answer_text);
//                answerview.setText(answer);
//                break;
//        }
//    }


    @Override
    protected void onStart() {
        super.onStart();

        globalClass =(GlobalClass) getApplicationContext();

        answerView = findViewById(R.id.answer_text);
        int a = globalClass.getCounter();
        String b = Integer.toString(a);
        answerView.setText(b);

    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT,answerView.getText().toString());
        
        editor.apply();

        Toast.makeText(globalClass, "GAME SAVED", Toast.LENGTH_SHORT).show();

    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        String temp = sharedPreferences.getString(TEXT,"-1");
        String empty = "-1";
        if(temp.equals(empty)){
            number = 0;
        }
        else{
//            if(!TEXT.equals(empty))
                number = Integer.parseInt(temp);
        }

       Toast.makeText(this, number, Toast.LENGTH_SHORT).show();
    }

    public void updateData(){
        String tmp = Integer.toString(number);
        answerView.setText(tmp);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        {

            mediaPlayer.stop();
            mediaPlayer.release();
            saveData();
            finishAffinity();
        }
    }
}
