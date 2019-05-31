package com.example.kshitij.dd;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class die2 extends AppCompatActivity {

    Button invisible;
    GlobalClass globalClass = new GlobalClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_die2);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        invisible = findViewById(R.id.inv4);
        invisible.setVisibility(View.VISIBLE);
        invisible.setBackgroundColor(Color.TRANSPARENT);

        invisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(die2.this,MainActivity.class);
                globalClass.setCounter(0);
                globalClass.setFlag(0);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.hold);
            }
        });
    }
}
