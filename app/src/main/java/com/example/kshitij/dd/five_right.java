package com.example.kshitij.dd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Vibrator;

public class five_right extends AppCompatActivity {

    GlobalClass globalClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_right);

        globalClass = (GlobalClass) getApplicationContext();

//        final int five_r = R.id.five_right;
        final int six = R.id.six;

        globalClass.setCounter(51);

        Button right = findViewById(R.id.next_five_right);

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {0, 1500, 500, 1000, 200, 1000, 500, 2000, 100};

        v.vibrate(pattern,-1);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globalClass.setCounter(six);

                Intent intent = new Intent(five_right.this,levels.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.hold);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.cancel();

        Intent i = new Intent(five_right.this,MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in,R.anim.hold);
        finish();
    }
}
