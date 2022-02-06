package com.example.sheetal.hp;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }


    //Arrays
    public int[] slide_image = {
            R.drawable.mom_ch,
            R.drawable.mom_ch,
            R.drawable.mom_ch
    };

    public String[] slide_headings = {"SELF LOVE", "GROWTH", "NURTURE"};

    public String[] slide_desc = {"You are pregnant and you are powerful. You are bold and you are beautiful. Go forward in your boldness, in your beauty and in your contentedness. Trust your body to birth and know that the collective power of women worldwide will be with you.",
            "Birth is an opportunity to transcend. To rise above what we are accustomed to, reach deeper inside ourselves than we are familiar with, and to see not only what we are truly made of, but the strength we can access in and through birth.",
            "A mother’s joy begins when new life is stirring inside… when a tiny heartbeat is heard for the very first time, and a playful kick reminds her that she is never alone"};


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (ConstraintLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slidelayout, container, false);

        ImageView slide_image_view = (ImageView) view.findViewById(R.id.img);
        TextView slideHeading = (TextView) view.findViewById(R.id.text1);
        TextView slideDesc = (TextView) view.findViewById(R.id.text2);

        slide_image_view.setImageResource(slide_image[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout) object);

    }

}
