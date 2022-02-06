package com.example.sheetal.hp;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DietSLideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public DietSLideAdapter(Context context) {
        this.context = context;
    }


    //Arrays
    public int[] slide_image = {
            R.drawable.mom_ch,
            R.drawable.mom_ch,
            R.drawable.mom_ch,
            R.drawable.mom_ch
    };

    public String[] slide_headings = {"Must Vaccines", "Say no to these vaccines", "Maybe Vaccines", "For More Info"};

    public String[] slide_desc = {"Influenza-you need a flu shot every fall! \n Tetanus- in the early part of the third trimester ",
            "Human papillomavirus \n Measles, mumps, rupella \n Varicella \nZoster",
            "Hepatitis A (if specific risk factor for it) \nHepatitis B (if specific risk factor for it)\n Hib\nPneumococcal\nMeningococcal",
            "Consult your healthcare provider to determine your level of risk for infection and your need for this vaccine\n"};


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
        View view = layoutInflater.inflate(R.layout.dietslidelayout, container, false);

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
