package com.example.kshitij.dd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.q42.android.scrollingimageview.ScrollingImageView;

public class levels extends AppCompatActivity {

    private View contentView;
    GlobalClass globalClass = new GlobalClass();

    private ViewPager viewPager;
    private SlideAdapter slideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        final GlobalClass globalClass = (GlobalClass) getApplicationContext();

        if(globalClass.getFlag() == 0) {
            globalClass.setFlag(1);
            globalClass.setCounter(0);
        }

//        Toast.makeText(levels.this, "1"+counter, Toast.LENGTH_SHORT).show();

//        Intent intent = getIntent();
//        counter = intent.getIntExtra("key",0);


//        Bundle bundle = getIntent().getExtras();
//        if(bundle != null){
//            int counter = bundle.getInt("key");
//        }


        final int one = R.id.one;
        final int one_sub = R.id.one_sub;
        final int two = R.id.two;
        final int three = R.id.three;
        final int three_sub = R.id.three_sub;
        final int four = R.id.four;
        final int six = R.id.six;


        Button n_one = findViewById(R.id.next_one);
        Button n_two = findViewById(R.id.next_two);
        Button n_three = findViewById(R.id.next_three);

        final Button inv_btn = findViewById(R.id.inv);
        inv_btn.setVisibility(View.VISIBLE);
        inv_btn.setBackgroundColor(Color.TRANSPARENT);

        final Button inv_btn2 = findViewById(R.id.inv_2);
        inv_btn2.setVisibility(View.VISIBLE);
        inv_btn2.setBackgroundColor(Color.TRANSPARENT);


        if(globalClass.getCounter() == 0)
        {
            // INITIAL STORYLINE HERE

        globalClass.setCounter(one);
        contentView = findViewById(globalClass.getCounter());
        contentView.setVisibility(View.VISIBLE);
        }
        else{
            contentView = findViewById(globalClass.getCounter());
            contentView.setVisibility(View.VISIBLE);
        }

        //General case
        //if next button clicked
        // prev = getCounter;
        // setCounter(getCounter+1);



        //Next button of first card pressed
        n_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalClass.setCounter(one_sub);

                contentView.animate()
                        .alpha(0.5f)
                        .setDuration(2000);
                contentView.setVisibility(View.GONE);

                contentView = findViewById(globalClass.getCounter());

                contentView.setAlpha(0f);
                contentView.setVisibility(View.VISIBLE);

                contentView.animate()
                        .alpha(1f)
                        .setDuration(2000);

                }
        });

        //Skip the Sub part of First card with a tap
        inv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globalClass.setCounter(two);

                contentView.animate()
                        .alpha(0.5f)
                        .setDuration(2000);
                contentView.setVisibility(View.GONE);

                contentView = findViewById(globalClass.getCounter());

                contentView.setAlpha(0f);
                contentView.setVisibility(View.VISIBLE);

                contentView.animate()
                        .alpha(1f)
                        .setDuration(2000);

            }
        });

        //Next button of Second card pressed
        n_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globalClass.setCounter(three);

                contentView.animate()
                        .alpha(0.5f)
                        .setDuration(2000);
                contentView.setVisibility(View.GONE);

                contentView = findViewById(globalClass.getCounter());

                contentView.setAlpha(0f);
                contentView.setVisibility(View.VISIBLE);

                contentView.animate()
                        .alpha(1f)
                        .setDuration(2000);

            }
        });

        //Next button of Third card pressed
        n_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globalClass.setCounter(three_sub);

                contentView.animate()
                        .alpha(0.5f)
                        .setDuration(2000);
                contentView.setVisibility(View.GONE);

                contentView = findViewById(globalClass.getCounter());

                contentView.setAlpha(0f);
                contentView.setVisibility(View.VISIBLE);

                contentView.animate()
                        .alpha(1f)
                        .setDuration(2000);

            }
        });

        //Skip the Sub part of Third card with a tap
        inv_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globalClass.setCounter(four);

                contentView.animate()
                        .alpha(0.5f)
                        .setDuration(2000);
                contentView.setVisibility(View.GONE);

                contentView = findViewById(globalClass.getCounter());

                contentView.setAlpha(0f);
                contentView.setVisibility(View.VISIBLE);

                contentView.animate()
                        .alpha(1f)
                        .setDuration(2000);



            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        slideAdapter = new SlideAdapter(this);
        viewPager.setAdapter(slideAdapter);


//        if(globalClass.getPosition() == 0)
//        {
//            globalClass.setCounter(five_l);
//
//            contentView.animate()
//                    .alpha(0.5f)
//                    .setDuration(2000);
//            contentView.setVisibility(View.GONE);
//
//            contentView = findViewById(globalClass.getCounter());
//
//            contentView.setAlpha(0f);
//            contentView.setVisibility(View.VISIBLE);
//
//            contentView.animate()
//                    .alpha(1f)
//                    .setDuration(2000);
//
//        }
//        else if(globalClass.getPosition() == 1)
//        {
//            globalClass.setCounter(five_r);
//
//                contentView.animate()
//                        .alpha(0.5f)
//                        .setDuration(2000);
//                contentView.setVisibility(View.GONE);
//
//                contentView = findViewById(globalClass.getCounter());
//
//                contentView.setAlpha(0f);
//                contentView.setVisibility(View.VISIBLE);
//
//                contentView.animate()
//                        .alpha(1f)
//                        .setDuration(2000);
//
//                Toast.makeText(levels.this, "HERE", Toast.LENGTH_SHORT).show();
//            }



    }

//    public void saveData(){
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putInt(INT,counter);
//        editor.putString(,contentView.getVisibility());
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Intent intent = new Intent();
//        intent.putExtra("result",counter);
//        setResult(Activity.RESULT_OK,intent);
//        finish();
        Intent i = new Intent(levels.this,MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in,R.anim.hold);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.cancel();
//        contentView = findViewById(save);
//        Toast.makeText(levels.this, "START " + counter, Toast.LENGTH_SHORT).show();
//        contentView.setVisibility(View.VISIBLE);
    }
}
