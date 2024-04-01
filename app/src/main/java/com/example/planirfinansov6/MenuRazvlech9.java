package com.example.planirfinansov6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuRazvlech9 extends AppCompatActivity {

    TextView nadpRazvl, nadp_1, nadp_2, nadp_3;
    Typeface TypefaceRazvl;   // ШРИФТ
    TextView tv1, tv2, tv3, tv7;
    Animation anim;

    androidx.constraintlayout.widget.ConstraintLayout ConstraintLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menurazvlech);

// СКРЫВАЕМ ВЕРХНЮЮ И НИЖНЮЮ СТРОКИ НАВИГАЦИИ
        ConstraintLayout = findViewById(R.id.ConstraintLayout_menurazvlech);
        int currentVis = ConstraintLayout.getSystemUiVisibility();
        int newVis;
        if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE) == View.SYSTEM_UI_FLAG_LOW_PROFILE) {
            newVis = View.SYSTEM_UI_FLAG_VISIBLE;
        } else {
            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        ConstraintLayout.setSystemUiVisibility(newVis);

        nadpRazvl = (TextView) findViewById(R.id.nadpRazvl_view);
        nadp_1 = (TextView) findViewById(R.id.nadp_1);
        nadp_2 = (TextView) findViewById(R.id.nadp_2);
        nadp_3 = (TextView) findViewById(R.id.nadp_3);

        viborShrifta();
        nadpRazvl.setTypeface(TypefaceRazvl);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);
        tv7 = (TextView) findViewById(R.id.nadpRazvl_view);
        tv7.startAnimation(anim);
        nadp_1.setTypeface(TypefaceRazvl);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim14);
        tv1 = (TextView) findViewById(R.id.nadp_1);
        tv1.startAnimation(anim);
        nadp_2.setTypeface(TypefaceRazvl);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim15);
        tv2 = (TextView) findViewById(R.id.nadp_2);
        tv2.startAnimation(anim);
        nadp_3.setTypeface(TypefaceRazvl);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim16);
        tv3 = (TextView) findViewById(R.id.nadp_3);
        tv3.startAnimation(anim);
    }

    public void clickVideo(View v) {
        Intent intent = new Intent(this, RazvlVideo10.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickObuch(View v) {
        Intent intent = new Intent(this, Obuch12.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickTest(View v) {
        Intent intent = new Intent(this, Test11.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void  clickMenu(View v) {
        Intent intent = new Intent(this, Menu8.class);   // Переход на другой класс
        startActivity(intent);
    }

    public void viborShrifta() {
        byte a = (byte) (Math.random() * 5); // Случайное число от 0 до 4
        Typeface a1 = null;

        if (a == 0) {
            a1 = getResources().getFont(R.font.pacifico_regular);
        }
        if (a == 1) {
            a1 = getResources().getFont(R.font.komi);
        }
        if (a == 2) {
            a1 = getResources().getFont(R.font.qwe);
        }
        if (a == 3) {
            a1 = getResources().getFont(R.font.vanowitsch);
        }
        if (a == 4) {
            a1 = getResources().getFont(R.font.ocker);
        }
        TypefaceRazvl = a1;
    }
    public void clickVixod(View view) {
        this.finishAffinity();
    }  // СВЕРТЫВАЕТ ПРИЛОЖЕНИЕ

}


