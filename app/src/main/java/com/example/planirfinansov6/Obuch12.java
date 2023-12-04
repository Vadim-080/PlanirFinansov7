package com.example.planirfinansov6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Obuch12 extends AppCompatActivity {

    TextView nadpObuch, nadp_1, nadp_2, nadp_3, nadp_4, nadp_5;
    Typeface TypefaceObuch;   // ШРИФТ
    TextView tv1, tv2, tv3, tv4, tv5, tv7;
    Animation anim;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obuch);

        nadpObuch = (TextView) findViewById(R.id.nadpObuch_view);
        nadp_1 = (TextView) findViewById(R.id.nadp_1);
        nadp_2 = (TextView) findViewById(R.id.nadp_2);
        nadp_3 = (TextView) findViewById(R.id.nadp_3);
        nadp_4 = (TextView) findViewById(R.id.nadp_4);
        nadp_5 = (TextView) findViewById(R.id.nadp_5);

        viborShrifta();
        nadpObuch.setTypeface(TypefaceObuch);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);
        tv7 = (TextView) findViewById(R.id.nadpObuch_view);
        tv7.startAnimation(anim);
        nadp_1.setTypeface(TypefaceObuch);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim14);
        tv1 = (TextView) findViewById(R.id.nadp_1);
        tv1.startAnimation(anim);
        nadp_2.setTypeface(TypefaceObuch);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim15);
        tv2 = (TextView) findViewById(R.id.nadp_2);
        tv2.startAnimation(anim);
        nadp_3.setTypeface(TypefaceObuch);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim16);
        tv3 = (TextView) findViewById(R.id.nadp_3);
        tv3.startAnimation(anim);
        nadp_4.setTypeface(TypefaceObuch);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim17);
        tv4 = (TextView) findViewById(R.id.nadp_4);
        tv4.startAnimation(anim);
        nadp_5.setTypeface(TypefaceObuch);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim18);
        tv5 = (TextView) findViewById(R.id.nadp_5);
        tv5.startAnimation(anim);
    }

    public void click1 (View view) {
        Intent myWebLink = new Intent(Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("http://diplom-college.ru/a/kimb/files/23892/26230/Petrovskaya_V._Parikmakherskoe_iskusstvo._Uroki_masterstva.pdf"));
        startActivity(myWebLink);
    }

    public void click2 (View view) {
        Intent myWebLink = new Intent(Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://ktopis.68edu.ru/files/547.pdf?ysclid=lowx6dbzk7210203699"));
        startActivity(myWebLink);
    }

    public void click3 (View view) {
        Intent myWebLink = new Intent(Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("http://www.plam.ru/hobbirem/professija_parikmaher_uchebnoe_posobie/p6.php?ysclid=lowxcb3023436632798"));
        startActivity(myWebLink);
    }

    public void click4 (View view) {
        Intent myWebLink = new Intent(Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://nikitochkin.com/ru/blog/5-tehnik-strizki-kotorye-dolzen-znat-kazdyj-parikmaher"));
        startActivity(myWebLink);
    }

    public void click5 (View view) {
        Intent myWebLink = new Intent(Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://hairgood.ru/categoriya/strijki.html?ysclid=lowxg723lq179160775"));
        startActivity(myWebLink);
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
        TypefaceObuch = a1;
    }
    public void clickVixod(View view) {
        this.finishAffinity();
    }  // СВЕРТЫВАЕТ ПРИЛОЖЕНИЕ

}


