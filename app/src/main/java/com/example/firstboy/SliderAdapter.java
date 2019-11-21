package com.example.firstboy;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.conta_01,
            R.drawable.conta_02
    };

    public String[] slide_head = {
            "Abra sua conta\nagora mesmo.",
            "O Banco do Brasil\nsempre com você."
    };

    public String[] slide_sub_head = {
            "Você abre sua conta de forma\nrápida e com toda segurança\ndo Banco do Brasil.",
            "Use a sua conta onde e do jeito\nque você preferir: celular,\ntablet ou smartwatch."
    };

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view;

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if(position < 2) {

            view = layoutInflater.inflate(R.layout.slide_layout, container, false);
            ImageView img = view.findViewById(R.id.imageViewSlide);
            TextView sldH = view.findViewById(R.id.slideHead);
            TextView sldSH = view.findViewById(R.id.slideSubHead);

            img.setImageResource(slide_images[position]);
            sldH.setText(slide_head[position]);
            sldSH.setText(slide_sub_head[position]);

        }else{
            view = layoutInflater.inflate(R.layout.slide_third, container, false);
        }

        container.addView(view);
        return view;
    };

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
