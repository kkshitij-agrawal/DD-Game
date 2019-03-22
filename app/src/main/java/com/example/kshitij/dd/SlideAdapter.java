package com.example.kshitij.dd;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    Button btn;

    public int[] images = {
            R.drawable.left,
            R.drawable.right
    };

    public String[] titles = {
            "LEFT PATH",
            "RIGHT PATH"
    };

    public String[] descrition = {
            "No sound. Dead. Silent. Only trickling of water, drip drop.",
            "It's glowing, as if calling you. Suddenly, you hear a wailing sound! Screeching through cave"
    };

    public int[] background = {
            Color.rgb(0,0,0),
            Color.rgb(255,255,255)
    };

    public SlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (RelativeLayout)o);
    }

    GlobalClass globalClass = new GlobalClass();

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        RelativeLayout layoutslide = view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = view.findViewById(R.id.slideimg);
        TextView txttitle = view.findViewById(R.id.txttitle);
        TextView txtdescription = view.findViewById(R.id.txtdescription);

        layoutslide.setBackgroundResource(images[position]);
        txttitle.setText(titles[position]);
        txtdescription.setText(descrition[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                globalClass.setPosition(position);

                Toast.makeText(context, "Pos = " + globalClass.getPosition(), Toast.LENGTH_SHORT).show();

                load(position);

            }
        });

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }

    public void load(int pos){

        if(pos == 0)

            context.startActivity(new Intent(context,five_left.class));
        else if(pos == 1)
            context.startActivity(new Intent(context,five_right.class));
    }


}
