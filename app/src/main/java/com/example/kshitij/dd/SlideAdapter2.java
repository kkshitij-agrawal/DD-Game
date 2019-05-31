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

public class SlideAdapter2 extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    Button btn;

    public int[] images = {
            R.drawable.self,
            R.drawable.inn,
            R.drawable.oldman,
            R.drawable.fight
    };

    public String[] titles = {
            "WELCOME!",
            "A Drink for you, finest of all!",
            "Don't FORGET...",
            "Let's do this!"
    };

    public String[] descrition = {
            "You're Kriminar Battlefate, a handsome young lad, with an unfortunate history. You've been alone since you were 15, fighting your way through life. " +
                    "You're a sell sword and witch hunter, always getting in trouble with the authorities. " ,
            "As you sit down to drink, an old man approaches you. He tells you about a hidden cave, with all the riches of the witch Queen, Acacia Everbleed",
            "He gives you the witch's wail and a destiny amulet.Also,\" the caves will reveal to only those whose heart’s fire is neither too dark nor too bright.\" ",
            "You sleep at night and next morning you decide to set off for the QUEST the old man left you."
    };


    public SlideAdapter2(Context context){
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


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide2,container,false);
        RelativeLayout layoutslide = view.findViewById(R.id.slidelinearlayout2);
        ImageView imgslide = view.findViewById(R.id.slideimg2);
        TextView txttitle = view.findViewById(R.id.txttitle2);
        TextView txtdescription = view.findViewById(R.id.txtdescription2);
        TextView swipetxt = view.findViewById(R.id.swipe2);

        layoutslide.setBackgroundResource(images[position]);
        txttitle.setText(titles[position]);
        txtdescription.setText(descrition[position]);
        if(position == 3){
            swipetxt.setVisibility(View.GONE);
        }

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }


}
