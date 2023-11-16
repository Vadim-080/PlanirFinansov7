package com.example.planirfinansov6;

import static com.example.planirfinansov6.MainActivity.Key;
import static com.example.planirfinansov6.MainActivity.KeyDR;
import static com.example.planirfinansov6.MainActivity.KeyDP;
import static com.example.planirfinansov6.MainActivity.KeyDTolko;
import static com.example.planirfinansov6.MainActivity.KeyD_1;
import static com.example.planirfinansov6.MainActivity.KeyD_2;
import static com.example.planirfinansov6.MainActivity.KeyD_3;
import static com.example.planirfinansov6.MainActivity.KeyD_4;
import static com.example.planirfinansov6.MainActivity.KeyD_5;
import static com.example.planirfinansov6.MainActivity.KeyD_6;
import static com.example.planirfinansov6.MainActivity.KeyD_7;
import static com.example.planirfinansov6.MainActivity.KeyD_8;
import static com.example.planirfinansov6.MainActivity.KeyD_9;
import static com.example.planirfinansov6.MainActivity.KeyD_11;
import static com.example.planirfinansov6.MainActivity.KeyMonth;
import static com.example.planirfinansov6.MainActivity.KeyMonthD;
import static com.example.planirfinansov6.MainActivity.KeyMonthR;
import static com.example.planirfinansov6.MainActivity.KeyPrimMonth;
import static com.example.planirfinansov6.MainActivity.KeyRP;
import static com.example.planirfinansov6.MainActivity.KeyRR;
import static com.example.planirfinansov6.MainActivity.KeySumD;
import static com.example.planirfinansov6.MainActivity.KeySumMonthRP;
import static com.example.planirfinansov6.MainActivity.KeySumMonthRR;
import static com.example.planirfinansov6.MainActivity.KeySumR;
import static com.example.planirfinansov6.MainActivity.RassmatrivaemGod;
import static com.example.planirfinansov6.MainActivity.izmenMount;
import static com.example.planirfinansov6.MainActivity.summaDoxodZaMonth;
import static com.example.planirfinansov6.Kalendar2.APP_PREFERENCES;
import static com.example.planirfinansov6.Kalendar2.DateR;
import static com.example.planirfinansov6.Kalendar2.DayR;
import static com.example.planirfinansov6.Kalendar2.summaDoxodObchEtotDay;


import static com.example.planirfinansov6.Kalendar2.mSettings;
/*import static com.example.planirfinansov6.Kalendar2.vozvratnayaSVvodaData;*/
import static com.example.planirfinansov6.Kalendar2.vibranData;
import static com.example.planirfinansov6.Kalendar2.vibranDataMonth;
import static com.example.planirfinansov6.MainActivity.summaRasxodZaMonth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Vvod3 extends AppCompatActivity {

    int promVvod;
    int month;
    int chislo;
    String promVozv;
    String DayViv;
    int summaTolkoDoxodZaMonth;
    int summaDoxodRabEtotDay, summaDoxodProdEtotDay;
    int vvodD1, vvodD2, vvodD3, vvodD4, vvodD5, vvodD6, vvodD7, vvodD8, vvodD9, vvodD11;
    Typeface TypefaceDoxod;   // ШРИФТ
    Animation anim;
    TextView date, day, tv6, tv7, tv8, tv4, tv5;
    TextView nadpDoxod, nadprab, nadpprod, nadpVsegoDoxod, nadpDoxodZaMonth;
    String summaDoxodRab, summaDoxodProd;
    TextView summaDoxodDayRab, summaDoxodDayProd;
    TextView VsegoDoxod, doxodZaMont;
    EditText vvodDoxodR1, vvodDoxodR2, vvodDoxodR3, vvodDoxodR4, vvodDoxodR5, vvodDoxodP1, vvodDoxodP2, vvodDoxodP3, vvodDoxodP4, vvodDoxodP5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doxod_vvod);
        Key();

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE); // Внутри метода onCreate() вы инициализируете переменную  mSettings

        date = (TextView) findViewById(R.id.date_view);
        day = (TextView) findViewById(R.id.day_view);

        vvodDoxodR1 = (EditText) findViewById(R.id.vvod_doxod_R_1);
        vvodDoxodR2 = (EditText) findViewById(R.id.vvod_doxod_R_2);
        vvodDoxodR3 = (EditText) findViewById(R.id.vvod_doxod_R_3);
        vvodDoxodR4 = (EditText) findViewById(R.id.vvod_doxod_R_4);
        vvodDoxodR5 = (EditText) findViewById(R.id.vvod_doxod_R_5);

        vvodDoxodP1 = (EditText) findViewById(R.id.vvod_doxod_P_1);
        vvodDoxodP2 = (EditText) findViewById(R.id.vvod_doxod_P_2);
        vvodDoxodP3 = (EditText) findViewById(R.id.vvod_doxod_P_3);
        vvodDoxodP4 = (EditText) findViewById(R.id.vvod_doxod_P_4);
        vvodDoxodP5 = (EditText) findViewById(R.id.vvod_doxod_P_5);

        summaDoxodDayRab = (TextView) findViewById(R.id.summaDoxodDay_Rab_view);
        summaDoxodDayProd = (TextView) findViewById(R.id.summaDoxodDay_Prod_view);

        nadpDoxod = (TextView) findViewById(R.id.nadpDoxod_view);
        nadprab = (TextView) findViewById(R.id.nadp_rab_view);
        nadpprod = (TextView) findViewById(R.id.nadp_prod_view);
        nadpVsegoDoxod = (TextView) findViewById(R.id.nadpVsegoDoxod_view);
        nadpDoxodZaMonth = (TextView) findViewById(R.id.nadpDoxodZaMonth_view);

        VsegoDoxod = (TextView) findViewById(R.id.vsegoDoxod_view);
        doxodZaMont = (TextView) findViewById(R.id.doxodZaMont_view);

        viborShrifta();
        nadpDoxod.setTypeface(TypefaceDoxod);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim8);   // Плавное появление экрана
        tv8 = (TextView) findViewById(R.id.nadpDoxod_view);
        tv8.startAnimation(anim);
        nadprab.setTypeface(TypefaceDoxod);    // ШРИФТ
        nadpprod.setTypeface(TypefaceDoxod);    // ШРИФТ
        nadpVsegoDoxod.setTypeface(TypefaceDoxod);    // ШРИФТ
        nadpDoxodZaMonth.setTypeface(TypefaceDoxod);    // ШРИФТ

        Date segodnDate = new Date();

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
        int tekDate = Integer.parseInt(formatter1.format(segodnDate));
        if (Key >= tekDate) {
            ImageButton b1 = (ImageButton) findViewById(R.id.MonthVperedDox_view);
            b1.setEnabled(false);
            ImageButton a1 = findViewById(R.id.MonthVperedDox_view);   // ПРОЗРАЧНОСТЬ КНОПКИ
            a1.setAlpha(1f);
            a1.animate().alpha(0.2f).setDuration(1500);
        }

        if (Kalendar2.proverka == true) {

            if (vibranData.after(segodnDate)) {   // ПРОВЕРКА НЕ НАСТУПИВШЕЙ ДАТЫ
                date.setTypeface(TypefaceDoxod);   // ШРИФТ
                date.setText("ВЫБРАННАЯ ДАТА");
                anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);   // Плавное появление экрана
                tv6 = (TextView) findViewById(R.id.date_view);
                tv6.startAnimation(anim);

                day.setTypeface(TypefaceDoxod);   // ШРИФТ
                day.setText("ЕЩЕ НЕ НАСТУПИЛА");
                anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim7);   // Плавное появление экрана
                tv7 = (TextView) findViewById(R.id.day_view);
                tv7.startAnimation(anim);
                showDialogKalend(null);  // диалог окно календарь
            }


        }

        date.setTypeface(TypefaceDoxod);   // ШРИФТ
        date.setText(DateR);
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);   // Плавное появление экрана
        tv6 = (TextView) findViewById(R.id.date_view);
        tv6.startAnimation(anim);

        day.setTypeface(TypefaceDoxod);   // ШРИФТ
        day.setText(DayR);
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim7);   // Плавное появление экрана
        tv7 = (TextView) findViewById(R.id.day_view);
        tv7.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim11);
        tv5 = (TextView) findViewById(R.id.nadp_rab_view);
        tv5.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim4);
        tv4 = (TextView) findViewById(R.id.nadp_prod_view);
        tv4.startAnimation(anim);

        KeyD_1 = (double) KeyDR + 0.1;
        KeyD_2 = (double) KeyDR + 0.2;
        KeyD_3 = (double) KeyDR + 0.3;
        KeyD_4 = (double) KeyDR + 0.4;
        KeyD_5 = (double) KeyDR + 0.5;
        KeyD_6 = (double) KeyDR + 0.6;
        KeyD_7 = (double) KeyDR + 0.7;
        KeyD_8 = (double) KeyDR + 0.8;
        KeyD_9 = (double) KeyDR + 0.9;
        KeyD_11 = (double) KeyDR + 0.11;

        onResume();

        if (vvodD1 != 0) {
            /*  promVvod =vvodD1;*/
            /* razdelen();*/
            vvodDoxodR1.setText("" + vvodD1);
        }
        if (vvodD2 != 0) {
            /* promVvod =vvodD2;*/
            /*    razdelen();*/
            vvodDoxodR2.setText("" + vvodD2);
        }
        if (vvodD3 != 0) {
            vvodDoxodR3.setText("" + vvodD3);
        }
        if (vvodD4 != 0) {
            vvodDoxodR4.setText("" + vvodD4);
        }
        if (vvodD5 != 0) {
            vvodDoxodR5.setText("" + vvodD5);
        }
        if (vvodD6 != 0) {
            vvodDoxodP1.setText("" + vvodD6);
        }
        if (vvodD7 != 0) {
            vvodDoxodP2.setText("" + vvodD7);
        }
        if (vvodD8 != 0) {
            vvodDoxodP3.setText("" + vvodD8);
        }
        if (vvodD9 != 0) {
            vvodDoxodP4.setText("" + vvodD9);
        }
        if (vvodD11 != 0) {
            vvodDoxodP5.setText("" + vvodD11);
        }

        /*    doxodZaMont.setText("x" + Key);*/

    }

    public void showDialogKalend(View v) {    // Выводит диалоговое окно
        DialogKalend dialog = new DialogKalend();
        dialog.show(getSupportFragmentManager(), "custom");
    }

    public void clickSochranit(View v) {

        onResume();
        summaDoxodZaMonth = summaDoxodZaMonth - summaDoxodObchEtotDay;

// ДОХОД РАБОТА
        summaDoxodRab = "0";

        int a, b, c, d, f;

        String z1 = vvodDoxodR1.getText().toString();
        String z2 = vvodDoxodR2.getText().toString();
        String z3 = vvodDoxodR3.getText().toString();
        String z4 = vvodDoxodR4.getText().toString();
        String z5 = vvodDoxodR5.getText().toString();

        if (z1.contains("1") | z1.contains("2") | z1.contains("3") | z1.contains("4") | z1.contains("5")
                | z1.contains("6") | z1.contains("7") | z1.contains("8") | z1.contains("9")) {
            a = Integer.parseInt(vvodDoxodR1.getText().toString());
        } else {
            a = 0;
        }
        if (z2.contains("1") | z2.contains("2") | z2.contains("3") | z2.contains("4") | z2.contains("5")
                | z2.contains("6") | z2.contains("7") | z2.contains("8") | z2.contains("9")) {
            b = Integer.parseInt(vvodDoxodR2.getText().toString());
        } else {
            b = 0;
        }
        if (z3.contains("1") | z3.contains("2") | z3.contains("3") | z3.contains("4") | z3.contains("5")
                | z3.contains("6") | z3.contains("7") | z3.contains("8") | z3.contains("9")) {
            c = Integer.parseInt(vvodDoxodR3.getText().toString());
        } else {
            c = 0;
        }
        if (z4.contains("1") | z4.contains("2") | z4.contains("3") | z4.contains("4") | z4.contains("5")
                | z4.contains("6") | z4.contains("7") | z4.contains("8") | z4.contains("9")) {
            d = Integer.parseInt(vvodDoxodR4.getText().toString());
        } else {
            d = 0;
        }
        if (z5.contains("1") | z5.contains("2") | z5.contains("3") | z5.contains("4") | z5.contains("5")
                | z5.contains("6") | z5.contains("7") | z5.contains("8") | z5.contains("9")) {
            f = Integer.parseInt(vvodDoxodR5.getText().toString());
        } else {
            f = 0;
        }

        summaDoxodRab = String.valueOf((a + b + c + d + f));

        DecimalFormat s3 = new DecimalFormat();
        DecimalFormatSymbols symbols1 = DecimalFormatSymbols.getInstance();
        symbols1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s3.setDecimalFormatSymbols(symbols1);
        summaDoxodRabEtotDay = Integer.parseInt(summaDoxodRab);

        summaDoxodDayRab.setTypeface(TypefaceDoxod);   // ШРИФТ
        summaDoxodDayRab.setText("" + s3.format(summaDoxodRabEtotDay));

        vvodD1 = a;
        vvodD2 = b;
        vvodD3 = c;
        vvodD4 = d;
        vvodD5 = f;


// ДОХОД ПРОДАЖИ
        summaDoxodProd = "0";

        int q, w, e, r, t;

        String z6 = vvodDoxodP1.getText().toString();
        String z7 = vvodDoxodP2.getText().toString();
        String z8 = vvodDoxodP3.getText().toString();
        String z9 = vvodDoxodP4.getText().toString();
        String z10 = vvodDoxodP5.getText().toString();

        if (z6.contains("1") | z6.contains("2") | z6.contains("3") | z6.contains("4") | z6.contains("5")
                | z6.contains("6") | z6.contains("7") | z6.contains("8") | z6.contains("9")) {
            q = Integer.parseInt(vvodDoxodP1.getText().toString());
        } else {
            q = 0;
        }
        if (z7.contains("1") | z7.contains("2") | z7.contains("3") | z7.contains("4") | z7.contains("5")
                | z7.contains("6") | z7.contains("7") | z7.contains("8") | z7.contains("9")) {
            w = Integer.parseInt(vvodDoxodP2.getText().toString());
        } else {
            w = 0;
        }
        if (z8.contains("1") | z8.contains("2") | z8.contains("3") | z8.contains("4") | z8.contains("5")
                | z8.contains("6") | z8.contains("7") | z8.contains("8") | z8.contains("9")) {
            e = Integer.parseInt(vvodDoxodP3.getText().toString());
        } else {
            e = 0;
        }
        if (z9.contains("1") | z9.contains("2") | z9.contains("3") | z9.contains("4") | z9.contains("5")
                | z9.contains("6") | z9.contains("7") | z9.contains("8") | z9.contains("9")) {
            r = Integer.parseInt(vvodDoxodP4.getText().toString());
        } else {
            r = 0;
        }
        if (z10.contains("1") | z10.contains("2") | z10.contains("3") | z10.contains("4") | z10.contains("5")
                | z10.contains("6") | z10.contains("7") | z10.contains("8") | z10.contains("9")) {
            t = Integer.parseInt(vvodDoxodP5.getText().toString());
        } else {
            t = 0;
        }

        summaDoxodProd = String.valueOf((q + w + e + r + t));

        vvodD6 = q;
        vvodD7 = w;
        vvodD8 = e;
        vvodD9 = r;
        vvodD11 = t;

        View view = this.getCurrentFocus();   // Скрывает экранную клавиатуру
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        DecimalFormat s4 = new DecimalFormat();
        DecimalFormatSymbols symbols2 = DecimalFormatSymbols.getInstance();
        symbols2.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s4.setDecimalFormatSymbols(symbols2);
        summaDoxodProdEtotDay = Integer.parseInt(summaDoxodProd);
        summaDoxodDayProd.setTypeface(TypefaceDoxod);   // ШРИФТ
        summaDoxodDayProd.setText("" + s4.format(summaDoxodProdEtotDay));

        summaDoxodObchEtotDay = summaDoxodRabEtotDay + summaDoxodProdEtotDay;

        DecimalFormat s1 = new DecimalFormat();
        DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
        v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s1.setDecimalFormatSymbols(v1);
        int t1 = summaDoxodObchEtotDay;

        VsegoDoxod.setTypeface(TypefaceDoxod);   // ШРИФТ
        VsegoDoxod.setText("" + s1.format(t1));

        summaDoxodZaMonth = summaDoxodZaMonth + summaDoxodObchEtotDay;

        summaTolkoDoxodZaMonth = summaDoxodZaMonth + summaRasxodZaMonth;

        DecimalFormat s2 = new DecimalFormat();
        DecimalFormatSymbols v2 = DecimalFormatSymbols.getInstance();
        v2.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s2.setDecimalFormatSymbols(v2);
        int t2 = summaTolkoDoxodZaMonth;

        doxodZaMont.setTypeface(TypefaceDoxod);   // ШРИФТ
        doxodZaMont.setText("" + s2.format(t2));

        onPause();
    }

    public void clickNaRasxod(View v) {

        Intent intent = new Intent(this, RasxodVvod4.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickMenu(View v) {

        Intent intent = new Intent(this, Menu8.class);   // Переход на другой класс
        startActivity(intent);
    }

    public void clickStatistikaD(View view) {

        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Statistika5.class);
        startActivity(intent);
    }

    public void clickNazadD(View v) {

        /*  vozvratnayaSVvodaData = false;*/
        Intent intent = new Intent(this, Kalendar2.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickPrimechD(View view) {

        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Primech6.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {    // Запоминаем данные
        super.onPause();

        SharedPreferences.Editor editor1 = mSettings.edit();
        editor1.putInt(String.valueOf(KeyDR), summaDoxodRabEtotDay);
        editor1.apply();
        SharedPreferences.Editor editor2 = mSettings.edit();
        editor2.putInt(String.valueOf(KeyDP), summaDoxodProdEtotDay);
        editor2.apply();
        SharedPreferences.Editor editor3 = mSettings.edit();
        editor3.putInt(String.valueOf(KeySumD), summaDoxodObchEtotDay);
        editor3.apply();
        SharedPreferences.Editor editor4 = mSettings.edit();
        editor4.putInt(String.valueOf(KeyMonthD), summaDoxodZaMonth);
        editor4.apply();

        SharedPreferences.Editor editor5 = mSettings.edit();
        editor5.putInt(String.valueOf(KeyD_1), vvodD1);
        editor5.apply();
        SharedPreferences.Editor editor6 = mSettings.edit();
        editor6.putInt(String.valueOf(KeyD_2), vvodD2);
        editor6.apply();
        SharedPreferences.Editor editor7 = mSettings.edit();
        editor7.putInt(String.valueOf(KeyD_3), vvodD3);
        editor7.apply();
        SharedPreferences.Editor editor8 = mSettings.edit();
        editor8.putInt(String.valueOf(KeyD_4), vvodD4);
        editor8.apply();
        SharedPreferences.Editor editor9 = mSettings.edit();
        editor9.putInt(String.valueOf(KeyD_5), vvodD5);
        editor9.apply();
        SharedPreferences.Editor editor10 = mSettings.edit();
        editor10.putInt(String.valueOf(KeyD_6), vvodD6);
        editor10.apply();
        SharedPreferences.Editor editor11 = mSettings.edit();
        editor11.putInt(String.valueOf(KeyD_7), vvodD7);
        editor11.apply();
        SharedPreferences.Editor editor12 = mSettings.edit();
        editor12.putInt(String.valueOf(KeyD_8), vvodD8);
        editor12.apply();
        SharedPreferences.Editor editor13 = mSettings.edit();
        editor13.putInt(String.valueOf(KeyD_9), vvodD9);
        editor13.apply();
        SharedPreferences.Editor editor14 = mSettings.edit();
        editor14.putInt(String.valueOf(KeyD_11), vvodD11);
        editor14.apply();

        SharedPreferences.Editor editor15 = mSettings.edit();
        editor15.putInt(String.valueOf(KeyMonthR), summaRasxodZaMonth);
        editor15.apply();

        SharedPreferences.Editor editor16 = mSettings.edit();
        editor16.putInt(String.valueOf(KeyDTolko), summaTolkoDoxodZaMonth);
        editor16.apply();
    }

    @Override
    public void onResume() {    // Получаем число из памяти
        super.onResume();

        if (mSettings.contains(String.valueOf(KeyMonthR))) {
            summaRasxodZaMonth = mSettings.getInt(String.valueOf(KeyMonthR), 0);
        } else summaRasxodZaMonth = 0;

        if (mSettings.contains(String.valueOf(KeyMonthD))) {
            summaDoxodZaMonth = mSettings.getInt(String.valueOf(KeyMonthD), 0);
        } else summaDoxodZaMonth = 0;

        if (mSettings.contains(String.valueOf(KeyD_1))) {
            vvodD1 = mSettings.getInt(String.valueOf(KeyD_1), 0);
        }
        if (mSettings.contains(String.valueOf(KeyD_2))) {
            vvodD2 = mSettings.getInt(String.valueOf(KeyD_2), 0);
        }
        if (mSettings.contains(String.valueOf(KeyD_3))) {
            vvodD3 = mSettings.getInt(String.valueOf(KeyD_3), 0);
        }
        if (mSettings.contains(String.valueOf(KeyD_4))) {
            vvodD4 = mSettings.getInt(String.valueOf(KeyD_4), 0);
        }
        if (mSettings.contains(String.valueOf(KeyD_5))) {
            vvodD5 = mSettings.getInt(String.valueOf(KeyD_5), 0);
        }
        if (mSettings.contains(String.valueOf(KeyD_6))) {
            vvodD6 = mSettings.getInt(String.valueOf(KeyD_6), 0);
        }
        if (mSettings.contains(String.valueOf(KeyD_7))) {
            vvodD7 = mSettings.getInt(String.valueOf(KeyD_7), 0);
        }
        if (mSettings.contains(String.valueOf(KeyD_8))) {
            vvodD8 = mSettings.getInt(String.valueOf(KeyD_8), 0);
        }
        if (mSettings.contains(String.valueOf(KeyD_9))) {
            vvodD9 = mSettings.getInt(String.valueOf(KeyD_9), 0);
        }
        if (mSettings.contains(String.valueOf(KeyD_11))) {
            vvodD11 = mSettings.getInt(String.valueOf(KeyD_11), 0);
        }

        if (mSettings.contains(String.valueOf(KeyDR))) {
            // проверяем сначала наличие ключа PAPKA_MEMORI_SummaDey,
            // а затем извлекаем из ключа его значение
            summaDoxodRabEtotDay = mSettings.getInt(String.valueOf(KeyDR), 0);
            // Выводим на экран данные из настроек
            DecimalFormat s1 = new DecimalFormat();
            DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
            v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s1.setDecimalFormatSymbols(v1);
            int t1 = summaDoxodRabEtotDay;
            summaDoxodDayRab.setTypeface(TypefaceDoxod);   // ШРИФТ
            summaDoxodDayRab.setText("" + s1.format(t1));
        } else {
            summaDoxodRabEtotDay = 0;
        }

        if (mSettings.contains(String.valueOf(KeyDP))) {
            summaDoxodProdEtotDay = mSettings.getInt(String.valueOf(KeyDP), 0);
            DecimalFormat s1 = new DecimalFormat();
            DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
            v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s1.setDecimalFormatSymbols(v1);
            int t1 = summaDoxodProdEtotDay;
            summaDoxodDayProd.setTypeface(TypefaceDoxod);   // ШРИФТ
            summaDoxodDayProd.setText("" + s1.format(t1));
        } else {
            summaDoxodProdEtotDay = 0;
        }

        if (mSettings.contains(String.valueOf(KeyDTolko))) {
            summaTolkoDoxodZaMonth = mSettings.getInt(String.valueOf(KeyDTolko), 0);
            DecimalFormat s2 = new DecimalFormat();
            DecimalFormatSymbols v2 = DecimalFormatSymbols.getInstance();
            v2.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s2.setDecimalFormatSymbols(v2);
            int t2 = summaTolkoDoxodZaMonth;
            doxodZaMont.setTypeface(TypefaceDoxod);   // ШРИФТ
            doxodZaMont.setText("" + s2.format(t2));
        } else {
            summaTolkoDoxodZaMonth = 0;
        }


        if (mSettings.contains(String.valueOf(KeySumD))) {
            summaDoxodObchEtotDay = mSettings.getInt(String.valueOf(KeySumD), 0);
            DecimalFormat s1 = new DecimalFormat();
            DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
            v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s1.setDecimalFormatSymbols(v1);
            int t1 = summaDoxodObchEtotDay;
            VsegoDoxod.setTypeface(TypefaceDoxod);   // ШРИФТ
            VsegoDoxod.setText("" + s1.format(t1));
        } else {
            summaDoxodObchEtotDay = 0;
            VsegoDoxod.setTypeface(TypefaceDoxod);   // ШРИФТ
            VsegoDoxod.setText("0");
        }

        /*   VsegoDoxod.setText("" + KeySumD);*/
    }

    public void clickItog(View v) {

        izmenMount = 0;

        Intent intent = new Intent(this, Itog7.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickVperedDox(View v) throws ParseException {

        String Keyst = String.valueOf(Key);

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date startDate = df.parse(Keyst);

        SimpleDateFormat W1 = new SimpleDateFormat("yyyyMMdd");

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        int daysToDecrement = +1;
        c.add(Calendar.DATE, daysToDecrement);
        String dte = W1.format(c.getTime()).toString();

        Key = Integer.parseInt(dte);

        Date startDate2 = df.parse(dte);

        SimpleDateFormat W2 = new SimpleDateFormat("dd");
        chislo = Integer.parseInt(W2.format(startDate2));

        SimpleDateFormat W3 = new SimpleDateFormat("MM");
        month = Integer.parseInt(W3.format(startDate2));

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMM");
        KeyMonth = Integer.parseInt(formatter1.format(startDate2));

        SimpleDateFormat W4 = new SimpleDateFormat("EEEE", new Locale("ru"));
        DayViv = (W4.format(startDate2));

        Date();

        /* onRestart();*/

        /* final Context context = this;            // Переход на другой класс*/
        Intent intent = new Intent(this, Vvod3.class);
        startActivity(intent);
    }

    public void clickNazadDox(View v) throws ParseException {

        String Keyst = String.valueOf(Key);

        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date startDate = df.parse(Keyst);

        SimpleDateFormat W1 = new SimpleDateFormat("yyyyMMdd");

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        int daysToDecrement = -1;
        c.add(Calendar.DATE, daysToDecrement);
        String dte = W1.format(c.getTime()).toString();

        Key = Integer.parseInt(dte);
        /*   Key();*/

        Date startDate2 = df.parse(dte);

        SimpleDateFormat W2 = new SimpleDateFormat("dd");
        chislo = Integer.parseInt(W2.format(startDate2));

        SimpleDateFormat W3 = new SimpleDateFormat("MM");
        month = Integer.parseInt(W3.format(startDate2));

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMM");
        KeyMonth = Integer.parseInt(formatter1.format(startDate2));

        SimpleDateFormat W4 = new SimpleDateFormat("EEEE", new Locale("ru"));
        DayViv = (W4.format(startDate2));

        Date();

        /*  onRestart();*/

        /*   VsegoDoxod.setText("" + Key);*/

        /*  final Context context = this;            // Переход на другой класс*/
        Intent intent = new Intent(this, Vvod3.class);
        startActivity(intent);
    }

    public void Date() {

        int q = month;   // Добавьте 1 в месяц, потому что месяц индекс начинается с 0
        String month1 = null;
        switch (q) {
            case 1:
                month1 = "ЯНВАРЯ";
                break;
            case 2:
                month1 = "ФЕВРАЛЯ";
                break;
            case 3:
                month1 = "МАРТА";
                break;
            case 4:
                month1 = "АПРЕЛЯ";
                break;
            case 5:
                month1 = "МАЯ";
                break;
            case 6:
                month1 = "ИЮНЯ";
                break;
            case 7:
                month1 = "ИЮЛЯ";
                break;
            case 8:
                month1 = "АВГУСТА";
                break;
            case 9:
                month1 = "СЕНТЯБРЯ";
                break;
            case 10:
                month1 = "ОКТЯБРЯ";
                break;
            case 11:
                month1 = "НОЯБРЯ";
                break;
            case 12:
                month1 = "ДЕКАБРЯ";
                break;
        }

        DateR = (chislo + "  " + month1);
        DayR = DayViv;
    }


    public void Key() {

        KeyDR = Key;
        KeyDP = Key + 100000000;
        KeyRR = Key + 200000000;
        KeyRP = Key + 300000000;

        KeySumD = Key + 800000000;
        KeySumR = Key + 900000000;

        KeyMonthD = KeyMonth + 1000000;
        KeyMonthR = KeyMonth + 2000000;
        KeySumMonthRR = KeyMonth + 3000000;
        KeySumMonthRP = KeyMonth + 4000000;
        KeyPrimMonth = KeyMonth + 5000000;
        KeyDTolko = KeyMonth + 6000000;
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
        TypefaceDoxod = a1;
    }

    public void razdelen() {
        DecimalFormat s1 = new DecimalFormat();
        DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
        v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s1.setDecimalFormatSymbols(v1);
        int t1 = promVvod;
        promVozv = s1.format(t1);
        summaDoxodDayProd.setText("" + s1.format(t1));

    }

}


 /*if (vibranDataMonth.before(segodnDate)) {    // ПРОВЕРКА ПРОШЕДШЕГО МЕСЯЦА
                date.setTypeface(TypefaceDoxod);   // ШРИФТ
                date.setText("ВЫ ВЫБРАЛИ ПРОШЕДШИЙ МЕСЯЦ");
                anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);   // Плавное появление экрана "НЕ ТОТ МЕСЯЦ"
                tv6 = (TextView) findViewById(R.id.date_view);
                tv6.startAnimation(anim);
                showDialogPredMonth(null);  // диалог ввод за предидущий месяц
            }*/

   /* public void showDialogPredMonth (View v) {    // Выводит диалоговое окно
        DialogPredMonth dialog = new DialogPredMonth();
        dialog.show(getSupportFragmentManager(), "custom");
    }*/