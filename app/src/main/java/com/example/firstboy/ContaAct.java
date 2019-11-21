package com.example.firstboy;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContaAct extends AppCompatActivity {

    private ViewPager SliderViewPager;
    private LinearLayout DotLayout;

    private TextView[] dots;

    private SliderAdapter sliderAdapter;

    private ImageButton btn;

    private Button slideThirdBtn;

    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_conta);

        SliderViewPager = findViewById(R.id.slideViewPager);
        DotLayout = findViewById(R.id.dotsLayout);

        sliderAdapter = new SliderAdapter(this);

        SliderViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        SliderViewPager.addOnPageChangeListener(viewListener);

        btn = findViewById(R.id.btnBackToNovo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContaAct.this, NovoAct.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
            }
        });

    }



    public void addDotsIndicator(int position){

        dots = new TextView[3];
        DotLayout.removeAllViews();

        for(int i = 0; i < dots.length; i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.slideDotsUnSelColor));
            dots[i].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            DotLayout.addView(dots[i]);
        }

        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.slideDotsSelColor));
        }

    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


    public void jumpTopPage(View view) {
        Intent i = new Intent(ContaAct.this, AbrirContaAct.class);
        startActivity(i);
    }
}
