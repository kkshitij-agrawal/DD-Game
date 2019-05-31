package com.example.kshitij.dd;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class rules extends AppCompatActivity {

    private ViewPager viewPager2;
    private SlideAdapter2 slideAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager2 = (ViewPager) findViewById(R.id.viewpager2);
        slideAdapter2 = new SlideAdapter2(this);
        viewPager2.setAdapter(slideAdapter2);
    }
}
