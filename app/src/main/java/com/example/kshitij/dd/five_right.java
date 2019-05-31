package com.example.kshitij.dd;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.os.Vibrator;
import android.widget.Toast;

public class five_right extends AppCompatActivity implements SensorEventListener {

    GlobalClass globalClass;
    MediaPlayer mediaPlayer2;
    MediaPlayer mediaPlayer3;

    private SensorManager sensorMan;
    private Sensor accelerometer;
    private SensorEventListener eventlistener;

    private float[] mGravity;
    private float mAccel;
    private float mAccelCurrent;
    private float mAccelLast;

    Button right;

    int flag =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_right);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        globalClass = (GlobalClass) getApplicationContext();


        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
//                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);

            }

            public void onFinish() {
                if(flag == 1){
                Intent intent = new Intent(five_right.this,die2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.hold);
                Toast.makeText(five_right.this, "DIE BITCH", Toast.LENGTH_SHORT).show();}
            }
        }.start();



//        final int five_r = R.id.five_right;
        final int six = R.id.six;

        globalClass.setCounter(51);

        mediaPlayer3 = MediaPlayer.create(getApplicationContext(),R.raw.scream);
        mediaPlayer3.start();

        //Accelerometer related Code
        sensorMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;

        //Code for accelerometer
        sensorMan.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);




        right = findViewById(R.id.next_five_right);

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {0, 1500, 500, 1000, 200, 1000, 500, 2000, 100};

        v.vibrate(pattern,-1);

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globalClass.setCounter(six);
                globalClass.setCompass_use(6);

                mediaPlayer2.release();
                Intent intent = new Intent(five_right.this,levels.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.hold);
            }
        });

    }

    public void onSensorChanged(SensorEvent event) {


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
            if (mAccel > 25) {
//                Toast.makeText(getApplicationContext(), "HO RHA HAI", Toast.LENGTH_SHORT).show();
                right.setVisibility(View.VISIBLE);
                flag = 0;
                mediaPlayer2 = MediaPlayer.create(getApplicationContext(),R.raw.next_sound);
                mediaPlayer2.start();

            } else {
//                Toast.makeText(getApplicationContext(), "NATHI", Toast.LENGTH_SHORT).show();
            }


        }

    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

        sensorMan.unregisterListener(this);

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.cancel();
        Intent i = new Intent(five_right.this,MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in,R.anim.hold);
        finish();
    }
}
