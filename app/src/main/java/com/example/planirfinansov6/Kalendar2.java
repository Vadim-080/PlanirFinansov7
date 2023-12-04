package com.example.planirfinansov6;

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
import static com.example.planirfinansov6.MainActivity.KeySumD;
import static com.example.planirfinansov6.MainActivity.KeySumMonthRP;
import static com.example.planirfinansov6.MainActivity.KeySumMonthRR;
import static com.example.planirfinansov6.MainActivity.KeySumR;
import static com.example.planirfinansov6.MainActivity.RassmatrivaemGod;
import static com.example.planirfinansov6.MainActivity.izmenMount;
import static com.example.planirfinansov6.MainActivity.summaDoxodZaMonth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Kalendar2 extends AppCompatActivity {

    public static String DateR, DayR;  // Дате для отображении во вкладке расход
    public static final String APP_PREFERENCES = "PAPKA_MEMORI3";  // константа для имени файла настроек
    public static final String APP_PREFERENCES_COUNTER_DR = String.valueOf(KeyDR); // Создадим параметр, который мы хотим сохранять в настройках
    public static final String APP_PREFERENCES_COUNTER_DP = String.valueOf(KeyDP); // Создадим параметр, который мы хотим сохранять в настройках
    public static final String APP_PREFERENCES_COUNTER_RR = String.valueOf(KeyRR); // Создадим параметр, который мы хотим сохранять в настройках
    public static final String APP_PREFERENCES_COUNTER_RP = String.valueOf(KeyRP); // Создадим параметр, который мы хотим сохранять в настройках
    public static final String APP_PREFERENCES_COUNTER_DTolko = String.valueOf(KeyDTolko); // Создадим параметр, который мы хотим сохранять в настройках
    public static final String APP_PREFERENCES_COUNTER_SumD = String.valueOf(KeySumD); // Создадим параметр, который мы хотим сохранять в настройках
    public static final String APP_PREFERENCES_COUNTER_SumR = String.valueOf(KeySumR); // Создадим параметр, который мы хотим сохранять в настройках
    public static final String APP_PREFERENCES_COUNTER_MonthD = String.valueOf(KeyMonthD); // Создадим параметр, который мы хотим сохранять в настройках
    public static final String APP_PREFERENCES_COUNTER_MonthR = String.valueOf(KeyMonthR); // Создадим параметр, который мы хотим сохранять в настройках
    public static SharedPreferences mSettings;  // Создаём переменную, представляющую экземпляр класса SharedPreferences, который отвечает за работу с настройками
   /* public static boolean vozvratnayaSVvodaData = true;*/
    public static int summaDoxodObchEtotDay;
    public static int summaRasxodObchEtotDay;
    public static Date vibranData, vibranDataMonth;
    public static String monthPrim;
    Typeface TypefaceKalend;   // ШРИФТ
    CalendarView calendar;
    TextView date_view, day_view;
    TextView doxodRab, pokazZaMonth;
    /*  TextView ИСПЫТ_view;*/
    TextView nadpisZaMonth, nadpisDoxod;
    TextView tv1, tv5, tv2, tv7;
    Animation anim;

    public static boolean proverka = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalend);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        calendar = (CalendarView) findViewById(R.id.calendar);
        date_view = (TextView) findViewById(R.id.date_view);
        day_view = (TextView) findViewById(R.id.day_view);
        nadpisZaMonth = (TextView) findViewById(R.id.nadpisZaMonth_view);
        doxodRab = (TextView) findViewById(R.id.pokazDoxodRab_view);
        nadpisDoxod = (TextView) findViewById(R.id.nadpisDoxod_view);

        pokazZaMonth = (TextView) findViewById(R.id.pokazZaMonth_view);

        proverka = false; // обнуляет дату при возврате на главный экран

        viborShrifta();
        nadpisDoxod.setTypeface(TypefaceKalend);   // ШРИФТ

        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim10);
        tv5 = (TextView) findViewById(R.id.pokazDoxodRab_view);
        tv5.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);
        tv1 = (TextView) findViewById(R.id.pokazZaMonth_view);
        tv1.startAnimation(anim);

        Date segodnDate = new Date();
        Calendar calendar1 = Calendar.getInstance();
        String month = calendar1.getDisplayName(Calendar.MONTH,
                Calendar.LONG_FORMAT, new Locale("RU"));
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(formatter2.format(segodnDate));

        SimpleDateFormat formatter3 = new SimpleDateFormat("dd");
        int a1 = Integer.parseInt(formatter3.format(segodnDate));

        date_view.setTypeface(TypefaceKalend);   // ШРИФТ
        date_view.setText(a1 + "  " + month);
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim2);   // Плавное появление экрана
        tv2 = (TextView) findViewById(R.id.date_view);
        tv2.startAnimation(anim);

        SimpleDateFormat formatter4 = new SimpleDateFormat("EEEE", new Locale("ru", "DK"));
        String a2 = (formatter4.format(segodnDate));
        day_view.setTypeface(TypefaceKalend);   // ШРИФТ
        day_view.setText("" + a2);
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim7);   // Плавное появление экрана
        tv7 = (TextView) findViewById(R.id.day_view);
        tv7.startAnimation(anim);

        DateR = (a1 + "  " + month);
        DayR = a2;

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMM");
        KeyMonth = Integer.parseInt(formatter1.format(segodnDate));

        SimpleDateFormat formatter5 = new SimpleDateFormat("yyyyMMdd");
        Key = Integer.parseInt(formatter5.format(segodnDate));

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
        RassmatrivaemGod = year;
        nadpisZaMonth();
        onResume();

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override

            public void onSelectedDayChange(
                    @NonNull CalendarView view,

                    int year, int month, int dayOfMonth) {

                Calendar a1 = Calendar.getInstance();
                a1.set(year, month, dayOfMonth);
                int a2 = a1.get(Calendar.DAY_OF_WEEK);

                int q1 = a2 - 1;
                String dayOfWeek = null;
                switch (q1) {
                    case 1:
                        dayOfWeek = "понедельник";
                        break;
                    case 2:
                        dayOfWeek = "вторник";
                        break;
                    case 3:
                        dayOfWeek = "среда";
                        break;
                    case 4:
                        dayOfWeek = "четверг";
                        break;
                    case 5:
                        dayOfWeek = "пятница";
                        break;
                    case 6:
                        dayOfWeek = "суббота";
                        break;
                    case 0:
                        dayOfWeek = "воскресенье";
                        break;
                }

                int q = month + 1;   // Добавьте 1 в месяц, потому что месяц индекс начинается с 0
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
                proverka = true;
                DateR = dayOfMonth + "  " + (month1);
                date_view.setTypeface(TypefaceKalend);   // ШРИФТ
                date_view.setText(DateR);
                DayR = (dayOfWeek);
                day_view.setTypeface(TypefaceKalend);   // ШРИФТ
                day_view.setText(DayR);

                String DateVibr = (dayOfMonth + "/" + q + "/" + year);
                SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy"/*, Locale.ENGLISH*/);
                vibranData = null;
                try {
                    vibranData = formatter1.parse(DateVibr);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                String DateVibrMonth = (q + 1) + "/" + year;
                SimpleDateFormat formatter2 = new SimpleDateFormat("MM/yyyy"/*, Locale.ENGLISH*/);
                vibranDataMonth = null;
                try {
                    vibranDataMonth = formatter2.parse(DateVibrMonth);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                SimpleDateFormat formatter3 = new SimpleDateFormat("yyyyMMdd");
                Key = Integer.parseInt(formatter3.format(vibranData));

                SimpleDateFormat formatter4 = new SimpleDateFormat("yyyyMM");
                KeyMonth = Integer.parseInt(formatter4.format(vibranData));

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
                RassmatrivaemGod = year;
                nadpisZaMonth();
                onResume();
            }
        });
    }

    @Override
    public void onResume() {    // Получаем число из настроек
        super.onResume();

        Key();

        if (mSettings.contains(String.valueOf(KeySumD))) {
            // а затем извлекаем из ключа его значение
            summaDoxodObchEtotDay = mSettings.getInt(String.valueOf(KeySumD), 0);
            // Выводим на экран данные из настроек
            DecimalFormat s1 = new DecimalFormat();
            DecimalFormatSymbols v1 = DecimalFormatSymbols.getInstance();
            v1.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s1.setDecimalFormatSymbols(v1);
            int t1 = summaDoxodObchEtotDay;
            doxodRab.setTypeface(TypefaceKalend);   // ШРИФТ
            doxodRab.setText("" + s1.format(t1));
        } else {
            doxodRab.setTypeface(TypefaceKalend);   // ШРИФТ
            doxodRab.setText("0");
        }

        if (KeyMonth == 0) {
            Date segodnDate = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
            KeyMonth = Integer.parseInt(formatter.format(segodnDate));
        }

        if (mSettings.contains(String.valueOf(KeyMonthD))) {

            summaDoxodZaMonth = mSettings.getInt(String.valueOf(KeyMonthD), 0);

            DecimalFormat s2 = new DecimalFormat();
            DecimalFormatSymbols v2 = DecimalFormatSymbols.getInstance();
            v2.setGroupingSeparator(' '); //явно задаем символ разделителя тысяч
            s2.setDecimalFormatSymbols(v2);
            int t2 = summaDoxodZaMonth;
            pokazZaMonth.setTypeface(TypefaceKalend);   // ШРИФТ
            pokazZaMonth.setText("" + s2.format(t2));
        } else {
            pokazZaMonth.setTypeface(TypefaceKalend);   // ШРИФТ
            pokazZaMonth.setText("0");
        }
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

    public void clickItog(View v) {
        izmenMount=0;
        Intent intent = new Intent(this, Itog7.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void nadpisZaMonth() {
        nadpisZaMonth.setTypeface(TypefaceKalend);   // ШРИФТ
        Date segodnDate = new Date();
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(formatter2.format(segodnDate));

        if (RassmatrivaemGod == year) {
            nadpisZaMonth.setText("ВСЕГО ЗА " + (monthPrim));
        } else {
            nadpisZaMonth.setText("ВСЕГО ЗА " + (monthPrim) + " " + RassmatrivaemGod);
        }
    }

    public void clickRedaktor(View view) {
        Key();
        final Context context = this;            // Переход на другой класс (сдесь класс Vvod)
        Intent intent = new Intent(context, Vvod3.class);
        startActivity(intent);
    }

    public void clickStatistika(View view) {
        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Statistika5.class);
        startActivity(intent);
    }

    public void clickPrimechK(View view) {
        Key();
        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Primech6.class);
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
        TypefaceKalend = a1;
    }

    public void clickMenu(View v) {
        Intent intent = new Intent(this, Menu8.class);   // Переход на другой класс
        startActivity(intent);
    }

    public void clickVixod(View view) {
        this.finishAffinity();
    }  // СВЕРТЫВАЕТ ПРИЛОЖЕНИЕ
}



