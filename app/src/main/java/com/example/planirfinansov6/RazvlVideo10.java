package com.example.planirfinansov6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RazvlVideo10 extends AppCompatActivity {

    TextView nadpRazvl;
    Typeface TypefaceRazvl;   // ШРИФТ

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        nadpRazvl = (TextView) findViewById(R.id.nadpRazvl_view);
        viborShrifta();
        nadpRazvl.setTypeface(TypefaceRazvl);    // ШРИФТ
    }

    public void  clickMenu(View v) {

        Intent intent = new Intent(this, Menu8.class);   // Переход на другой класс
        startActivity(intent);
    }
    public void clickVixod(View view) {
        this.finishAffinity();
    }  // СВЕРТЫВАЕТ ПРИЛОЖЕНИЕ

    public void clickVestnik(View view) {
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://dzen.ru/parikmaher"));
        startActivity(myWebLink);
    }

    public void clickVK(View view) {
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://vk.com/vestnik.parikmaherov?ysclid=lnn3ptntab743283840"));
        startActivity(myWebLink);
    }

    public void clickForum(View view) {
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://parikmaher.net.ru/forums/"));
        startActivity(myWebLink);
    }

    public void clickPropar(View view) {
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://www.pro-parikmahera.ru/?ysclid=lod1u73xik173567955"));
        startActivity(myWebLink);
    }

    public void clickMagaz1(View view) {
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://mustang-professional.ru/?utm_source=yandex&utm_medium=cpc&utm_campaign=poisk_obshie_zaprosu&utm_content=text2&utm_term=сайты%20для%20парикмахеров&yclid=17585137685274558463"));
        startActivity(myWebLink);
    }

    public void clickIst1(View view) {
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://dzen.ru/a/YZL6hBHw81stqk8-"));
        startActivity(myWebLink);
    }

    public void clickTv(View view) {
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://parikmaher.net.ru/videos/?ysclid=lod2e8rw7l485634835"));
        startActivity(myWebLink);
    }
    public void clickVid1(View view) {
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://rutube.ru/plst/183885/?ysclid=lod2jl7kyg113354505"));
        startActivity(myWebLink);
    }

    public void clickVid2(View view) {
        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        myWebLink.setData(Uri.parse("https://www.istockphoto.com/ru/видео-клипы/парикмахер"));
        startActivity(myWebLink);
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

}


