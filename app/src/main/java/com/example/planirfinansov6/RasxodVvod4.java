package com.example.planirfinansov6;

import static com.example.planirfinansov6.Kalendar2.APP_PREFERENCES;
import static com.example.planirfinansov6.Kalendar2.DateR;
import static com.example.planirfinansov6.Kalendar2.DayR;
import static com.example.planirfinansov6.Kalendar2.mSettings;
import static com.example.planirfinansov6.Kalendar2.summaRasxodObchEtotDay;
import static com.example.planirfinansov6.MainActivity.Key;
import static com.example.planirfinansov6.MainActivity.KeyDP;
import static com.example.planirfinansov6.MainActivity.KeyDR;
import static com.example.planirfinansov6.MainActivity.KeyDTolko;
import static com.example.planirfinansov6.MainActivity.KeyMonth;
import static com.example.planirfinansov6.MainActivity.KeyMonthD;
import static com.example.planirfinansov6.MainActivity.KeyMonthR;
import static com.example.planirfinansov6.MainActivity.KeyPrimMonth;
import static com.example.planirfinansov6.MainActivity.KeyRP;
import static com.example.planirfinansov6.MainActivity.KeyRR;
import static com.example.planirfinansov6.MainActivity.KeyR_1;
import static com.example.planirfinansov6.MainActivity.KeyR_2;
import static com.example.planirfinansov6.MainActivity.KeyR_3;
import static com.example.planirfinansov6.MainActivity.KeyR_4;
import static com.example.planirfinansov6.MainActivity.KeySumD;
import static com.example.planirfinansov6.MainActivity.KeySumMonthRP;
import static com.example.planirfinansov6.MainActivity.KeySumMonthRR;
import static com.example.planirfinansov6.MainActivity.KeySumR;
import static com.example.planirfinansov6.MainActivity.izmenMount;
import static com.example.planirfinansov6.MainActivity.summaDoxodZaMonth;
import static com.example.planirfinansov6.MainActivity.summaRasxodZaMonth;

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

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RasxodVvod4 extends AppCompatActivity {

    int month;
    int chislo;
    String DayViv;
    TextView dateR, dayR, rasxodR, rasxodP, summaRasxodDayR, summaRasxodDayP, summaRasxodObchDay, RasxodZaMonthR, RasxodZaMonthP, summaRasxodZaMonthObch;
    Animation anim;
    TextView nadpRasxod, nadpRasxodR, nadpRasxodP, nadpVsegoRasxod, nadpRasxodZaMonth;
    TextView tv6, tv7, tv8, tv4, tv5;
    String summaRasxodR, summaRasxodP;
    EditText vvodRasxodR1, vvodRasxodR2, vvodRasxodP3, vvodRasxodP4;
    Typeface TypefaceRasxod;   // ШРИФТ
    int summaRasxodEtotDayR, summaRasxodEtotDayP, summaRasxodEtotMonthR, summaRasxodEtotMonthP;
    int vvodR1, vvodR2, vvodR3, vvodR4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rasxod_vvod);

        Key();

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE); // Внутри метода onCreate() вы инициализируете переменную  mSettings

        dateR = (TextView) findViewById(R.id.dateR_view);
        dayR = (TextView) findViewById(R.id.dayR_view);

        summaRasxodDayR = (TextView) findViewById(R.id.summaRasxodDay_R_view);
        summaRasxodDayP = (TextView) findViewById(R.id.summaRasxodDay_P_view);
        summaRasxodObchDay = (TextView) findViewById(R.id.summaRasxodDay_view);
        summaRasxodZaMonthObch = (TextView) findViewById(R.id.summaRasxodZaMonthObch_view);
        RasxodZaMonthR = (TextView) findViewById(R.id.RasxodZaMonth_R_view);
        RasxodZaMonthP = (TextView) findViewById(R.id.RasxodZaMonth_P_view);

        vvodRasxodR1 = (EditText) findViewById(R.id.vvod_rasxod_1_view);
        vvodRasxodR2 = (EditText) findViewById(R.id.vvod_rasxod_2_view);
        vvodRasxodP3 = (EditText) findViewById(R.id.vvod_rasxod_3_view);
        vvodRasxodP4 = (EditText) findViewById(R.id.vvod_rasxod_4_view);

        nadpRasxod = (TextView) findViewById(R.id.nadpRasxod_view);
        nadpRasxodR = (TextView) findViewById(R.id.nadpRasxodR_view);
        nadpRasxodP = (TextView) findViewById(R.id.nadpRasxodP_view);
        nadpVsegoRasxod = (TextView) findViewById(R.id.nadpVsegoRasxod_view);
        nadpRasxodZaMonth = (TextView) findViewById(R.id.nadpRasxodZaMonth_view);

        Date segodnDate = new Date();

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
        int tekDate = Integer.parseInt(formatter1.format(segodnDate));
        if (Key >= tekDate) {
            ImageButton b1 = (ImageButton) findViewById(R.id.VperedRasx_view);
            b1.setEnabled(false);
            ImageButton a1 = findViewById(R.id.VperedRasx_view);   // ПРОЗРАЧНОСТЬ КНОПКИ
            a1.setAlpha(1f);
            a1.animate().alpha(0.2f).setDuration(1500);

            TextView b2 = (TextView) findViewById(R.id.nadpVper);
            b2.setEnabled(false);
            TextView a2 = findViewById(R.id.nadpVper);   // ПРОЗРАЧНОСТЬ КНОПКИ
            a2.setAlpha(1f);
            a2.animate().alpha(0.0f).setDuration(1500);
        }

        viborShrifta();
        nadpRasxod.setTypeface(TypefaceRasxod);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim8);   // Плавное появление экрана
        tv8 = (TextView) findViewById(R.id.nadpRasxod_view);
        tv8.startAnimation(anim);

        nadpRasxodR.setTypeface(TypefaceRasxod);    // ШРИФТ
        nadpRasxodP.setTypeface(TypefaceRasxod);    // ШРИФТ
        nadpVsegoRasxod.setTypeface(TypefaceRasxod);    // ШРИФТ
        nadpRasxodZaMonth.setTypeface(TypefaceRasxod);    // ШРИФТ

        dateR.setTypeface(TypefaceRasxod);
        dateR.setText(DateR);
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);   // Плавное появление экрана
        tv6 = (TextView) findViewById(R.id.dateR_view);
        tv6.startAnimation(anim);

        dayR.setTypeface(TypefaceRasxod);
        dayR.setText(DayR);
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim7);   // Плавное появление экрана
        tv7 = (TextView) findViewById(R.id.dayR_view);
        tv7.startAnimation(anim);

        KeyR_1 = (double) KeyDR + 0.12;
        KeyR_2 = (double) KeyDR + 0.13;
        KeyR_3 = (double) KeyDR + 0.14;
        KeyR_4 = (double) KeyDR + 0.15;

        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim12);
        tv5 = (TextView) findViewById(R.id.nadpRasxodR_view);
        tv5.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim13);
        tv4 = (TextView) findViewById(R.id.nadpRasxodP_view);
        tv4.startAnimation(anim);

        onResume();

        if (vvodR1 != 0) {
            vvodRasxodR1.setText("" + vvodR1);
        }
        if (vvodR2 != 0) {
            vvodRasxodR2.setText("" + vvodR2);
        }
        if (vvodR3 != 0) {
            vvodRasxodP3.setText("" + vvodR3);
        }
        if (vvodR4 != 0) {
            vvodRasxodP4.setText("" + vvodR4);
        }
    }

    public void clickMenu(View v) {

        Intent intent = new Intent(this, Menu8.class);   // Переход на другой класс
        startActivity(intent);
    }

    public void clickSochranitR(View v) {

        onResume();
        summaDoxodZaMonth = summaDoxodZaMonth + summaRasxodZaMonth;
        summaRasxodZaMonth = summaRasxodZaMonth - summaRasxodObchEtotDay;

        summaRasxodEtotMonthR = summaRasxodEtotMonthR - summaRasxodEtotDayR;
        summaRasxodEtotMonthP = summaRasxodEtotMonthP - summaRasxodEtotDayP;

// РАСХОД РАСХОДНИКИ
        summaRasxodR = "0";

        int a, b;
        String z1 = vvodRasxodR1.getText().toString();
        String z2 = vvodRasxodR2.getText().toString();

        if (z1.contains("1") | z1.contains("2") | z1.contains("3") | z1.contains("4") | z1.contains("5")
                | z1.contains("6") | z1.contains("7") | z1.contains("8") | z1.contains("9")) {
            a = Integer.parseInt(vvodRasxodR1.getText().toString());
        } else {
            a = 0;
        }
        if (z2.contains("1") | z2.contains("2") | z2.contains("3") | z2.contains("4") | z2.contains("5")
                | z2.contains("6") | z2.contains("7") | z2.contains("8") | z2.contains("9")) {
            b = Integer.parseInt(vvodRasxodR2.getText().toString());
        } else {
            b = 0;
        }

        summaRasxodR = String.valueOf((a + b));

        DecimalFormat s1 = new DecimalFormat();
        DecimalFormatSymbols symbols1 = DecimalFormatSymbols.getInstance();
        symbols1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s1.setDecimalFormatSymbols(symbols1);
        summaRasxodEtotDayR = Integer.parseInt(summaRasxodR);
        summaRasxodDayR.setTypeface(TypefaceRasxod);
        summaRasxodDayR.setText("" + s1.format(summaRasxodEtotDayR));

        vvodR1 = a;
        vvodR2 = b;

// РАСХОД ПРОДУКЦИЯ

        summaRasxodP = "0";

        int c, d;
        String z6 = vvodRasxodP3.getText().toString();
        String z7 = vvodRasxodP4.getText().toString();

        if (z6.contains("1") | z6.contains("2") | z6.contains("3") | z6.contains("4") | z6.contains("5")
                | z6.contains("6") | z6.contains("7") | z6.contains("8") | z6.contains("9")) {
            c = Integer.parseInt(vvodRasxodP3.getText().toString());
        } else {
            c = 0;
        }
        if (z7.contains("1") | z7.contains("2") | z7.contains("3") | z7.contains("4") | z7.contains("5")
                | z7.contains("6") | z7.contains("7") | z7.contains("8") | z7.contains("9")) {
            d = Integer.parseInt(vvodRasxodP4.getText().toString());
        } else {
            d = 0;
        }

        summaRasxodP = String.valueOf((c + d));

        vvodR3 = c;
        vvodR4 = d;

        DecimalFormat s2 = new DecimalFormat();
        DecimalFormatSymbols v2 = DecimalFormatSymbols.getInstance();
        v2.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s2.setDecimalFormatSymbols(v2);
        summaRasxodEtotDayP = Integer.parseInt(summaRasxodP);
        summaRasxodDayP.setTypeface(TypefaceRasxod);
        summaRasxodDayP.setText("" + s2.format(summaRasxodEtotDayP));

        View view = this.getCurrentFocus();   // Скрывает экранную клавиатуру
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        summaRasxodObchEtotDay = summaRasxodEtotDayR + summaRasxodEtotDayP;

        DecimalFormat s3 = new DecimalFormat();
        DecimalFormatSymbols v3 = DecimalFormatSymbols.getInstance();
        v3.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s3.setDecimalFormatSymbols(v3);
        int t1 = summaRasxodObchEtotDay;
        summaRasxodObchDay.setTypeface(TypefaceRasxod);
        summaRasxodObchDay.setText("" + s3.format(t1));

        summaRasxodZaMonth = summaRasxodZaMonth + summaRasxodObchEtotDay;
        DecimalFormat s6 = new DecimalFormat();
        DecimalFormatSymbols v6 = DecimalFormatSymbols.getInstance();
        v6.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s6.setDecimalFormatSymbols(v6);
        int t6 = summaRasxodZaMonth;
        summaRasxodZaMonthObch.setTypeface(TypefaceRasxod);
        summaRasxodZaMonthObch.setText("" + s6.format(t6));

        summaRasxodEtotMonthR = summaRasxodEtotMonthR + summaRasxodEtotDayR;
        DecimalFormat s4 = new DecimalFormat();
        DecimalFormatSymbols v4 = DecimalFormatSymbols.getInstance();
        v4.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s4.setDecimalFormatSymbols(v4);
        int t4 = summaRasxodEtotMonthR;
        RasxodZaMonthR.setTypeface(TypefaceRasxod);
        RasxodZaMonthR.setText("" + s4.format(t4));

        summaRasxodEtotMonthP = summaRasxodEtotMonthP + summaRasxodEtotDayP;
        DecimalFormat s5 = new DecimalFormat();
        DecimalFormatSymbols v5 = DecimalFormatSymbols.getInstance();
        v5.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
        s5.setDecimalFormatSymbols(v5);
        int t5 = summaRasxodEtotMonthP;
        RasxodZaMonthP.setTypeface(TypefaceRasxod);
        RasxodZaMonthP.setText("" + s5.format(t5));

        summaDoxodZaMonth = summaDoxodZaMonth - summaRasxodZaMonth;

        onPause();
    }

    public void clickNazadR(View v) {

        /*       vozvratnayaSVvodaData = false;*/
        Intent intent = new Intent(this, Kalendar2.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickPrimechR(View view) {

        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Primech6.class);
        startActivity(intent);
    }

    public void clickStatistikaR(View view) {

        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Statistika5.class);
        startActivity(intent);
    }

    public void clickVperedRasx(View v) throws ParseException {

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

        final Context context = this;            // Переход на другой класс
        Intent intent = new Intent(context, RasxodVvod4.class);
        startActivity(intent);
    }


    public void clickNazadRasx(View v) throws ParseException {

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

        final Context context = this;            // Переход на другой класс
        Intent intent = new Intent(context, RasxodVvod4.class);
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

    @Override
    public void onPause() {    // Запоминаем данные
        super.onPause();

        SharedPreferences.Editor editor1 = mSettings.edit();
        editor1.putInt(String.valueOf(KeyRR), summaRasxodEtotDayR);
        editor1.apply();
        SharedPreferences.Editor editor2 = mSettings.edit();
        editor2.putInt(String.valueOf(KeyRP), summaRasxodEtotDayP);
        editor2.apply();
        SharedPreferences.Editor editor3 = mSettings.edit();
        editor3.putInt(String.valueOf(KeySumR), summaRasxodObchEtotDay);
        editor3.apply();
        SharedPreferences.Editor editor4 = mSettings.edit();
        editor4.putInt(String.valueOf(KeyMonthR), summaRasxodZaMonth);
        editor4.apply();
        SharedPreferences.Editor editor5 = mSettings.edit();
        editor5.putInt(String.valueOf(KeyMonthD), summaDoxodZaMonth);
        editor5.apply();
        SharedPreferences.Editor editor6 = mSettings.edit();
        editor6.putInt(String.valueOf(KeySumMonthRR), summaRasxodEtotMonthR);
        editor6.apply();
        SharedPreferences.Editor editor7 = mSettings.edit();
        editor7.putInt(String.valueOf(KeySumMonthRP), summaRasxodEtotMonthP);
        editor7.apply();

        SharedPreferences.Editor editor8 = mSettings.edit();
        editor8.putInt(String.valueOf(KeyR_1), vvodR1);
        editor8.apply();
        SharedPreferences.Editor editor9 = mSettings.edit();
        editor9.putInt(String.valueOf(KeyR_2), vvodR2);
        editor9.apply();
        SharedPreferences.Editor editor10 = mSettings.edit();
        editor10.putInt(String.valueOf(KeyR_3), vvodR3);
        editor10.apply();
        SharedPreferences.Editor editor11 = mSettings.edit();
        editor11.putInt(String.valueOf(KeyR_4), vvodR4);
        editor11.apply();
    }

    @Override
    public void onResume() {    // Получаем число из настроек
        super.onResume();

        if (mSettings.contains(String.valueOf(KeyMonthR))) {
            summaRasxodZaMonth = mSettings.getInt(String.valueOf(KeyMonthR), 0);
        } else summaRasxodZaMonth = 0;

        if (mSettings.contains(String.valueOf(KeyMonthD))) {
            summaDoxodZaMonth = mSettings.getInt(String.valueOf(KeyMonthD), 0);
        } else summaDoxodZaMonth = 0;

        if (mSettings.contains(String.valueOf(KeyR_1))) {
            vvodR1 = mSettings.getInt(String.valueOf(KeyR_1), 0);
        }
        if (mSettings.contains(String.valueOf(KeyR_2))) {
            vvodR2 = mSettings.getInt(String.valueOf(KeyR_2), 0);
        }
        if (mSettings.contains(String.valueOf(KeyR_3))) {
            vvodR3 = mSettings.getInt(String.valueOf(KeyR_3), 0);
        }
        if (mSettings.contains(String.valueOf(KeyR_4))) {
            vvodR4 = mSettings.getInt(String.valueOf(KeyR_4), 0);
        }

        if (mSettings.contains(String.valueOf(KeySumMonthRR))) {
            summaRasxodEtotMonthR = mSettings.getInt(String.valueOf(KeySumMonthRR), 0);
            DecimalFormat s1 = new DecimalFormat();
            DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
            v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s1.setDecimalFormatSymbols(v1);
            int t1 = summaRasxodEtotMonthR;
            RasxodZaMonthR.setTypeface(TypefaceRasxod);
            RasxodZaMonthR.setText("" + s1.format(t1));
        } else summaRasxodEtotMonthR = 0;

        if (mSettings.contains(String.valueOf(KeySumMonthRP))) {
            summaRasxodEtotMonthP = mSettings.getInt(String.valueOf(KeySumMonthRP), 0);

            DecimalFormat s1 = new DecimalFormat();
            DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
            v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s1.setDecimalFormatSymbols(v1);
            int t1 = summaRasxodEtotMonthP;
            RasxodZaMonthP.setTypeface(TypefaceRasxod);
            RasxodZaMonthP.setText("" + s1.format(t1));
        } else summaRasxodEtotMonthP = 0;

        if (mSettings.contains(String.valueOf(KeyRR))) {
            summaRasxodEtotDayR = mSettings.getInt(String.valueOf(KeyRR), 0);

            DecimalFormat s1 = new DecimalFormat();
            DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
            v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s1.setDecimalFormatSymbols(v1);
            int t1 = summaRasxodEtotDayR;
            summaRasxodDayR.setTypeface(TypefaceRasxod);
            summaRasxodDayR.setText("" + s1.format(t1));
        } else summaRasxodEtotDayR = 0;

        if (mSettings.contains(String.valueOf(KeyRP))) {
            summaRasxodEtotDayP = mSettings.getInt(String.valueOf(KeyRP), 0);

            DecimalFormat s1 = new DecimalFormat();
            DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
            v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s1.setDecimalFormatSymbols(v1);
            int t1 = summaRasxodEtotDayP;
            summaRasxodDayP.setTypeface(TypefaceRasxod);
            summaRasxodDayP.setText("" + s1.format(t1));
        } else summaRasxodEtotDayP = 0;

        if (mSettings.contains(String.valueOf(KeySumR))) {
            summaRasxodObchEtotDay = mSettings.getInt(String.valueOf(KeySumR), 0);

            DecimalFormat s1 = new DecimalFormat();
            DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
            v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s1.setDecimalFormatSymbols(v1);
            int t1 = summaRasxodObchEtotDay;
            summaRasxodObchDay.setTypeface(TypefaceRasxod);
            summaRasxodObchDay.setText("" + s1.format(t1));
        } else summaRasxodObchEtotDay = 0;

        if (mSettings.contains(String.valueOf(KeyMonthR))) {
            summaRasxodZaMonth = mSettings.getInt(String.valueOf(KeyMonthR), 0);

            DecimalFormat s1 = new DecimalFormat();
            DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
            v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s1.setDecimalFormatSymbols(v1);
            int t1 = summaRasxodZaMonth;
            summaRasxodZaMonthObch.setTypeface(TypefaceRasxod);
            summaRasxodZaMonthObch.setText("" + s1.format(t1));
        } else summaRasxodZaMonth = 0;
    }

    public void clickItog(View v) {

        izmenMount = 0;
        Intent intent = new Intent(this, Itog7.class);   // Переход на другой класс (сдесь класс Vvod)
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
        TypefaceRasxod = a1;
    }
}


