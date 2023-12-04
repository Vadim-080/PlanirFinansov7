package com.example.planirfinansov6;

import static com.example.planirfinansov6.Kalendar2.APP_PREFERENCES;
import static com.example.planirfinansov6.Kalendar2.mSettings;
import static com.example.planirfinansov6.Kalendar2.monthPrim;
import static com.example.planirfinansov6.MainActivity.KeyDTolko;
import static com.example.planirfinansov6.MainActivity.KeyMonthD;
import static com.example.planirfinansov6.MainActivity.KeyMonthR;
import static com.example.planirfinansov6.MainActivity.KeyPrimMonth;
import static com.example.planirfinansov6.MainActivity.RassmatrivaemGod;
import static com.example.planirfinansov6.MainActivity.izmenMount;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Itog7 extends AppCompatActivity {
    Typeface TypefaceItog;   // ШРИФТ
    TextView tv1, tv2, tv3, tv4, tv5;
    TextView nadpItog, dateItog, nadp_dox, nadp_ras, nadp_prib;
    Animation anim;
    String PrimMonth;
    int poslCifrMount;
    int doxZaMonth, rasxZaMonth, itogZaMonth;
    TextView pokazDoxZaMonth, pokazRasZaMonth, pokazItogZaMonth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itog);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE); // Внутри метода onCreate() вы инициализируете переменную  mSettings
        viborShrifta();

        nadpItog = findViewById(R.id.nadpItog_view);
        dateItog = findViewById(R.id.dateItog_view);
        nadp_dox = findViewById(R.id.nadp_dox_view);
        nadp_ras = findViewById(R.id.nadp_ras_view);
        nadp_prib = findViewById(R.id.nadp_prib_view);
        pokazDoxZaMonth = (TextView) findViewById(R.id.pokazDoxZaMonth_view);
        pokazRasZaMonth = (TextView) findViewById(R.id.pokazRasZaMonth_view);
        pokazItogZaMonth = (TextView) findViewById(R.id.pokazItogZaMonth_view);

        KeyPrimMonth = KeyPrimMonth - izmenMount;

        KeyDTolko = KeyDTolko - izmenMount;
        KeyMonthR = KeyMonthR - izmenMount;
        KeyMonthD = KeyMonthD - izmenMount;

        Date segodnDate = new Date();

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMM");
        int tekDate = Integer.parseInt(formatter1.format(segodnDate));
        if (KeyPrimMonth >= (tekDate+5000000)) {
            ImageButton b1 = (ImageButton) findViewById(R.id.MonthVperedIt_view);
            b1.setEnabled(false);
            ImageButton a1 = findViewById(R.id.MonthVperedIt_view);   // ПРОЗРАЧНОСТЬ КНОПКИ
            a1.setAlpha(1f);
            a1.animate().alpha(0.2f).setDuration(1500);

            TextView b2 = (TextView) findViewById(R.id.nadpVper);
            b2.setEnabled(false);
            TextView a2 = findViewById(R.id.nadpVper);   // ПРОЗРАЧНОСТЬ КНОПКИ
            a2.setAlpha(1f);
            a2.animate().alpha(0.0f).setDuration(1500);
        }

        if (monthPrim==null) {

            SimpleDateFormat formatter6 = new SimpleDateFormat("MM");
            int q = Integer.parseInt(formatter6.format(segodnDate));

            String month2 = null;
            switch (q) {
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
            }
            monthPrim = month2;
        }

        onResume();

        nadpItog.setTypeface(TypefaceItog);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);   // Плавное появление экрана
        tv2 = (TextView) findViewById(R.id.nadpItog_view);
        tv2.startAnimation(anim);

        dateItog.setTypeface(TypefaceItog);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim7);   // Плавное появление экрана
        tv1 = findViewById(R.id.dateItog_view);
        tv1.startAnimation(anim);

        nadp_prib.setTypeface(TypefaceItog);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim7);   // Плавное появление экрана
        tv3 = findViewById(R.id.nadp_prib_view);
        tv3.startAnimation(anim);

        nadp_dox.setTypeface(TypefaceItog);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim12);
        tv5 = (TextView) findViewById(R.id.nadp_dox_view);
        tv5.startAnimation(anim);

        nadp_ras.setTypeface(TypefaceItog);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim13);
        tv4 = (TextView) findViewById(R.id.nadp_ras_view);
        tv4.startAnimation(anim);

       /* Date segodnDate2 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        int daysToDecrement = -1;
        c.add(Calendar.DATE, daysToDecrement);
        String dte = sdf.format(c.getTime()).toString();*/


        Date segodnDate1 = new Date();
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy");
        int tekGod = Integer.parseInt(formatter2.format(segodnDate1));

        if (RassmatrivaemGod == tekGod) {

            dateItog.setText("" + monthPrim);
        } else {
            dateItog.setText("" + monthPrim + "  " + RassmatrivaemGod);
        }
    }


    public void clickKalendIt(View v) {

        izmenMount = 0;
        Intent intent = new Intent(this, Kalendar2.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickStatistikaIt(View view) {

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
    public void onResume() {    // Получаем число из памяти
        super.onResume();

        if (mSettings.contains(String.valueOf(KeyPrimMonth))) {
            PrimMonth = mSettings.getString(String.valueOf(KeyPrimMonth), String.valueOf(0));
        } else {
            PrimMonth = "";
        }

        if (mSettings.contains(String.valueOf(KeyDTolko))) {

            doxZaMonth = mSettings.getInt(String.valueOf(KeyDTolko), 0);

            DecimalFormat s2 = new DecimalFormat();
            DecimalFormatSymbols v2 = DecimalFormatSymbols.getInstance();
            v2.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s2.setDecimalFormatSymbols(v2);
            int t2 = doxZaMonth;
            pokazDoxZaMonth.setTypeface(TypefaceItog);   // ШРИФТ
            pokazDoxZaMonth.setText("" + s2.format(t2));
        } else {
            pokazDoxZaMonth.setTypeface(TypefaceItog);   // ШРИФТ
            pokazDoxZaMonth.setText("0");
        }

        if (mSettings.contains(String.valueOf(KeyMonthR))) {

            rasxZaMonth = mSettings.getInt(String.valueOf(KeyMonthR), 0);

            DecimalFormat s2 = new DecimalFormat();
            DecimalFormatSymbols v2 = DecimalFormatSymbols.getInstance();
            v2.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s2.setDecimalFormatSymbols(v2);
            int t2 = rasxZaMonth;
            pokazRasZaMonth.setTypeface(TypefaceItog);   // ШРИФТ
            pokazRasZaMonth.setText("" + s2.format(t2));
        } else {
            pokazRasZaMonth.setTypeface(TypefaceItog);   // ШРИФТ
            pokazRasZaMonth.setText("0");
        }

        if (mSettings.contains(String.valueOf(KeyMonthD))) {

            itogZaMonth = mSettings.getInt(String.valueOf(KeyMonthD), 0);

            DecimalFormat s2 = new DecimalFormat();
            DecimalFormatSymbols v2 = DecimalFormatSymbols.getInstance();
            v2.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s2.setDecimalFormatSymbols(v2);
            int t2 = itogZaMonth;
            pokazItogZaMonth.setTypeface(TypefaceItog);   // ШРИФТ
            pokazItogZaMonth.setText("" + s2.format(t2));
        } else {
            pokazItogZaMonth.setTypeface(TypefaceItog);   // ШРИФТ
            pokazItogZaMonth.setText("0");
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
        TypefaceItog = a1;
    }

    public void clickMonthNazadId(View v) {

        izmenMount = 1;
        nomerMount();
        if (poslCifrMount == 1) {
            izmenMount = 89;
            RassmatrivaemGod = RassmatrivaemGod - 1;
        }
        final Context context = this;            // Переход на другой класс
        Intent intent = new Intent(context, Itog7.class);
        startActivity(intent);
    }

    public void clickMonthVperedId(View v) {

        izmenMount = (-1);
        nomerMount();
        if (poslCifrMount == 12) {
            izmenMount = -89;
            RassmatrivaemGod = RassmatrivaemGod + 1;
        }
        final Context context = this;            // Переход на другой класс
        Intent intent = new Intent(context, Itog7.class);
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

