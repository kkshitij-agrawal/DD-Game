package com.example.kshitij.dd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class five_left extends AppCompatActivity {

    GlobalClass globalClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_left);

        globalClass = (GlobalClass) getApplicationContext();

//        final int five_l = R.id.five_left;
        final int six = R.id.six;

        globalClass.setCounter(50);

        Button left = findViewById(R.id.next_five_left);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globalClass.setCounter(six);

                Intent intent = new Intent(five_left.this,levels.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.hold);
            }
        });


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
