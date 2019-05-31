package com.example.kshitij.dd;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.speech.RecognitionService;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.CollapsibleActionView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.q42.android.scrollingimageview.ScrollingImageView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;

public class levels extends AppCompatActivity implements SensorEventListener {
//
//    MediaPlayer mediaPlayer;
//    MediaPlayer mediaPlayer2;

    private View contentView;
    GlobalClass globalClass = new GlobalClass();

    private ViewPager viewPager;
    private SlideAdapter slideAdapter;

    private SensorManager sensorMan;
    private Sensor accelerometer;
    private Sensor magneticField;
    private Sensor light;
    private SensorEventListener eventlistener;

    private float[] mGravity;
    private float[] mGravity2 = new float[3];
    private float[] mGeomagnetic2 = new float[3];

    private float azimuth = 0f;
    private float correctAzimuth = 0f;
    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;


     Button n_one ;
     Button n_two ;
     Button n_three;
     Button n_six;

     TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final GlobalClass globalClass = (GlobalClass) getApplicationContext();

        if(globalClass.getFlag() == 0) {
            globalClass.setFlag(1);
            globalClass.setCounter(0);
        }

        final int one = R.id.one;
        final int one_sub = R.id.one_sub;
        final int two = R.id.two;
        final int three = R.id.three;
        final int three_sub = R.id.three_sub;
        final int four = R.id.four;
        final int six = R.id.six;

//        mediaPlayer2 = MediaPlayer.create(getApplicationContext(),R.raw.next_sound);

        n_one = findViewById(R.id.next_one);
        n_two = findViewById(R.id.next_two);
        n_three = findViewById(R.id.next_three);
        n_six = findViewById(R.id.next_six);

        final Button inv_btn = findViewById(R.id.inv);
        inv_btn.setVisibility(View.VISIBLE);
        inv_btn.setBackgroundColor(Color.TRANSPARENT);

        final Button inv_btn2 = findViewById(R.id.inv_2);
        inv_btn2.setVisibility(View.VISIBLE);
        inv_btn2.setBackgroundColor(Color.TRANSPARENT);

        //Accelerometer related code
        sensorMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magneticField = sensorMan.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;

        light = sensorMan.getDefaultSensor(Sensor.TYPE_LIGHT);

        //Code for accelerometer
        sensorMan.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        sensorMan.registerListener(this, magneticField, SensorManager.SENSOR_DELAY_UI);
        sensorMan.registerListener(levels.this, light, SensorManager.SENSOR_DELAY_UI);

        if(globalClass.getCounter() == 0)
        {

        globalClass.setCounter(one);
        contentView = findViewById(globalClass.getCounter());
        contentView.setVisibility(View.VISIBLE);
        }
        else{
            contentView = findViewById(globalClass.getCounter());
            contentView.setVisibility(View.VISIBLE);
        }

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

                sensorMan.unregisterListener(levels.this);

//                mediaPlayer2.release();

                globalClass.setCompass_use(1);

            }
        });

        number = (TextView) findViewById(R.id.number);

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

        float curBrightness = 0;

        try{
            curBrightness = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
        }catch (Settings.SettingNotFoundException e){
            e.printStackTrace();
        }

        number.setText("VAL " + curBrightness);

        if(curBrightness>120 && curBrightness<140 && globalClass.getCounter() == two){
//            mediaPlayer2.start();
            n_two.setVisibility(View.VISIBLE);
        }


        //Next button of Second card pressed
        n_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



//                mediaPlayer2.release();

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

                globalClass.setCompass_use(3);

            }
        });


        //Next button of Third card pressed
        n_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                sensorManager.unregisterListener(levels.this);

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

//                mediaPlayer2.release();

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

        if(globalClass.getCounter() == six){
            globalClass.setCounter(0);
            globalClass.setFlag(0);

        }

    }

//    public void saveData(){
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putInt(INT,counter);
//        editor.putString(,contentView.getVisibility());
//    }



    @Override
    public void onSensorChanged(SensorEvent event) {
//        if (globalClass.getCompass_use() == 0 3) {
            final float alpha = 0.97f;
            synchronized (this) {
                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

                    mGravity = event.values.clone();
                    // Shake detection
                    float x = mGravity[0];
                    float y = mGravity[1];
                    float z = mGravity[2];
                    mAccelLast = mAccelCurrent;
                    mAccelCurrent = (float) Math.sqrt(x * x + y * y + z * z);
                    float delta = mAccelCurrent - mAccelLast;
                    mAccel = mAccel * 0.9f + delta;
                    // Make this higher or lower according to how much
                    // motion you want to detect
//                    if (mAccel < 3 && globalClass.getCompass_use() == 6) {
////                Toast.makeText(getApplicationContext(), "HO RHA HAI", Toast.LENGTH_SHORT).show();
//                        n_six.setVisibility(View.VISIBLE);
//                        mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.next_sound);
//                        mediaPlayer2.start();
//
//                    }

                    mGravity2[0] = alpha * mGravity2[0] + (1 - alpha) * event.values[0];
                    mGravity2[1] = alpha * mGravity2[1] + (1 - alpha) * event.values[1];
                    mGravity2[2] = alpha * mGravity2[2] + (1 - alpha) * event.values[2];

                }

                if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                    mGeomagnetic2[0] = alpha * mGeomagnetic2[0] + (1 - alpha) * event.values[0];
                    mGeomagnetic2[1] = alpha * mGeomagnetic2[1] + (1 - alpha) * event.values[1];
                    mGeomagnetic2[2] = alpha * mGeomagnetic2[2] + (1 - alpha) * event.values[2];
                }

                //Light Toast
                if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
//                    Toast.makeText(getApplicationContext(), "LIGHT" + String.valueOf(event.values[0]), Toast.LENGTH_SHORT).show();

                    if (event.values[0] > 100) {
                        n_three.setVisibility(View.VISIBLE);
//                        mediaPlayer2.start();
                    }
                }


                float R[] = new float[9];
                float I[] = new float[9];
                boolean success = SensorManager.getRotationMatrix(R, I, mGravity2, mGeomagnetic2);
                if (success) {
                    float orientation[] = new float[3];
                    SensorManager.getOrientation(R, orientation);
                    azimuth = (float) Math.toDegrees(orientation[0]);
                    azimuth = (int) (azimuth + 360) % 360;

                }

                //Compass Toast
                if (azimuth > 0 && azimuth < 20 && globalClass.getCompass_use() == 0) {
                    n_one.setVisibility(View.VISIBLE);
//                    mediaPlayer3 = MediaPlayer.create(getApplicationContext(), R.raw.next_sound);
//                        mediaPlayer2.start();
//                    Toast.makeText(getApplicationContext(), String.valueOf(azimuth), Toast.LENGTH_SHORT).show();
                    sensorMan.unregisterListener(this);
                }

            }
        }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Intent intent = new Intent();
//        intent.putExtra("result",counter);
//        setResult(Activity.RESULT_OK,intent);
//        finish();

        sensorMan.unregisterListener(this);

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
