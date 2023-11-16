package com.example.planirfinansov6;

import static com.example.planirfinansov6.Kalendar2.APP_PREFERENCES;
import static com.example.planirfinansov6.Kalendar2.mSettings;

import static com.example.planirfinansov6.Kalendar2.monthPrim;
/*import static com.example.planirfinansov6.Kalendar2.vozvratnayaSVvodaData;*/
import static com.example.planirfinansov6.MainActivity.izmenMount;
import static com.example.planirfinansov6.MainActivity.KeyPrimMonth;
import static com.example.planirfinansov6.MainActivity.RassmatrivaemGod;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Primech6 extends AppCompatActivity {

    Typeface TypefacePrim;   // ШРИФТ
    TextView tv1, tv2;
    TextView nadpPrim;
    Animation anim;
    String PrimMonth;
    TextView datePrim;
    EditText textPrim;
    ImageButton buSochranitPrim;
    int poslCifrMount;



    /* public static boolean qq;*/

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primech);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE); // Внутри метода onCreate() вы инициализируете переменную  mSettings
        viborShrifta();

        nadpPrim = findViewById(R.id.nadpPrim_view);
        datePrim = findViewById(R.id.datePrim_view);
        textPrim = findViewById(R.id.textPrim_view);
        buSochranitPrim = findViewById(R.id.buSochranitPrim);

        KeyPrimMonth = KeyPrimMonth - izmenMount;

        onResume();
        textPrim.setText("" + PrimMonth);  // Текст что написано в Заметке

        nadpPrim.setTypeface(TypefacePrim);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);   // Плавное появление экрана
        tv2 = (TextView) findViewById(R.id.nadpPrim_view);
        tv2.startAnimation(anim);

        datePrim.setTypeface(TypefacePrim);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim7);   // Плавное появление экрана
        tv1 = findViewById(R.id.datePrim_view);
        tv1.startAnimation(anim);

        Date segodnDate1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy");
        int tekGod = Integer.parseInt(formatter1.format(segodnDate1));

        if (RassmatrivaemGod == tekGod) {

            datePrim.setText("" + monthPrim);
        } else {
            datePrim.setText("" + monthPrim+"  "+RassmatrivaemGod);
        }
    }

    public void clickSochranitPrim(View v) {

        PrimMonth = textPrim.getText().toString();
        onPause();
        View view = this.getCurrentFocus();   // Скрывает экранную клавиатуру
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void clickKalendPr(View v) {

        izmenMount = 0;
        /* vozvratnayaSVvodaData = false;*/
        Intent intent = new Intent(this, Kalendar2.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickStatistikaPr(View view) {

        izmenMount = 0;

        Date segodnDate1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy");
        RassmatrivaemGod = Integer.parseInt(formatter1.format(segodnDate1));

        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Statistika5.class);
        startActivity(intent);
    }

    public void clickMenu(View v) {

        izmenMount = 0;
        final Context context = this;            // Переход на другой класс
        Intent intent = new Intent(context, Menu8.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {    // Запоминаем данные
        super.onPause();

        SharedPreferences.Editor editor1 = mSettings.edit();
        editor1.putString(String.valueOf(KeyPrimMonth), PrimMonth);
        editor1.apply();
    }

    @Override
    public void onResume() {    // Получаем число из памяти
        super.onResume();

        if (mSettings.contains(String.valueOf(KeyPrimMonth))) {
            PrimMonth = mSettings.getString(String.valueOf(KeyPrimMonth), String.valueOf(0));
        } else {
            PrimMonth = "";
        }
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
        TypefacePrim = a1;
    }

    public void clickMonthNazad(View v) {

        izmenMount = 1;
        nomerMount();
        if (poslCifrMount == 1) {
            izmenMount = 89;
            RassmatrivaemGod = RassmatrivaemGod - 1;
        }
        final Context context = this;            // Переход на другой класс
        Intent intent = new Intent(context, Primech6.class);
        startActivity(intent);
    }

    public void clickMonthVpered(View v) {

        izmenMount = (-1);
        nomerMount();
        if (poslCifrMount == 12) {
            izmenMount = -89;
            RassmatrivaemGod = RassmatrivaemGod + 1;
        }
        final Context context = this;            // Переход на другой класс
        Intent intent = new Intent(context, Primech6.class);
        startActivity(intent);
    }

    public void nomerMount() {

        String number = String.valueOf(KeyPrimMonth);
        poslCifrMount = Integer.parseInt(number.substring(number.length() - 2, number.length()));

        int q = poslCifrMount - izmenMount;
        String month2 = null;
        switch (q) {
            case 0:
                month2 = "ДЕКАБРЬ";
                break;
            case 1:
                month2 = "ЯНВАРЬ";
                break;
            case 2:
                month2 = "ФЕВРАЛЬ";
                break;
            case 3:
                month2 = "МАРТ";
                break;
            case 4:
                month2 = "АПРЕЛЬ";
                break;
            case 5:
                month2 = "МАЙ";
                break;
            case 6:
                month2 = "ИЮНЬ";
                break;
            case 7:
                month2 = "ИЮЛЬ";
                break;
            case 8:
                month2 = "АВГУСТ";
                break;
            case 9:
                month2 = "СЕНТЯБРЬ";
                break;
            case 10:
                month2 = "ОКТЯБРЬ";
                break;
            case 11:
                month2 = "НОЯБРЬ";
                break;
            case 12:
                month2 = "ДЕКАБРЬ";
                break;
            case 13:
                month2 = "ЯНВАРЬ";
                break;
        }
        monthPrim = month2;
    }

}

