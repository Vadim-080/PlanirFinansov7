package com.example.planirfinansov6;

/*import static com.example.planirfinansov6.Kalendar2.vozvratnayaSVvodaData;*/

import static com.example.planirfinansov6.Kalendar2.DateR;
import static com.example.planirfinansov6.Kalendar2.DayR;
import static com.example.planirfinansov6.Kalendar2.monthPrim;
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
import static com.example.planirfinansov6.MainActivity.izmenMount;
import static java.util.Calendar.MONTH;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Menu8 extends AppCompatActivity {

    TextView nadpMenu, nadp_1, nadp_2, nadp_3, nadp_4, nadp_5, nadp_6, nadp_Itog;
    Typeface TypefaceMenu;   // ШРИФТ
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;
    Animation anim;

    androidx.constraintlayout.widget.ConstraintLayout ConstraintLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

// СКРЫВАЕМ ВЕРХНЮЮ И НИЖНЮЮ СТРОКИ НАВИГАЦИИ
        ConstraintLayout = findViewById(R.id.ConstraintLayout_menu);
        int currentVis = ConstraintLayout.getSystemUiVisibility();
        int newVis;
        if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE) == View.SYSTEM_UI_FLAG_LOW_PROFILE) {
            newVis = View.SYSTEM_UI_FLAG_VISIBLE;
        } else {
            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        ConstraintLayout.setSystemUiVisibility(newVis);

        nadpMenu = (TextView) findViewById(R.id.nadpMenu_view);
        nadp_1 = (TextView) findViewById(R.id.nadp_1);
        nadp_2 = (TextView) findViewById(R.id.nadp_2);
        nadp_3 = (TextView) findViewById(R.id.nadp_3);
        nadp_4 = (TextView) findViewById(R.id.nadp_4);
        nadp_5 = (TextView) findViewById(R.id.nadp_5);
        nadp_6 = (TextView) findViewById(R.id.nadp_6);
        nadp_Itog = (TextView) findViewById(R.id.nadp_Itog);

        viborShrifta();
        nadpMenu.setTypeface(TypefaceMenu);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);
        tv7 = (TextView) findViewById(R.id.nadpMenu_view);
        tv7.startAnimation(anim);
        nadp_1.setTypeface(TypefaceMenu);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim14);
        tv1 = (TextView) findViewById(R.id.nadp_1);
        tv1.startAnimation(anim);
        nadp_2.setTypeface(TypefaceMenu);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim15);
        tv2 = (TextView) findViewById(R.id.nadp_2);
        tv2.startAnimation(anim);
        nadp_3.setTypeface(TypefaceMenu);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim16);
        tv3 = (TextView) findViewById(R.id.nadp_3);
        tv3.startAnimation(anim);
        nadp_Itog.setTypeface(TypefaceMenu);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim17);
        tv8 = (TextView) findViewById(R.id.nadp_Itog);
        tv8.startAnimation(anim);
        nadp_4.setTypeface(TypefaceMenu);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim18);
        tv4 = (TextView) findViewById(R.id.nadp_4);
        tv4.startAnimation(anim);
        nadp_5.setTypeface(TypefaceMenu);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim19);
        tv5 = (TextView) findViewById(R.id.nadp_5);
        tv5.startAnimation(anim);
        nadp_6.setTypeface(TypefaceMenu);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim20);
        tv6 = (TextView) findViewById(R.id.nadp_6);
        tv6.startAnimation(anim);
    }

    public void clickKalend(View v) {

        Intent intent = new Intent(this, Kalendar2.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickDoxod(View v) {

        viborDat();
        Intent intent = new Intent(this, Vvod3.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickRasxod(View v) {

        viborDat();
        Intent intent = new Intent(this, RasxodVvod4.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickItog(View v) {

        mounth();
        izmenMount=0;
        viborDat();
        Intent intent = new Intent(this, Itog7.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void mounth() {
        Date segodnDate = new Date();
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

    public void clickZamet(View view) {

        mounth();
        viborDat();
        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Primech6.class);
        startActivity(intent);
    }

    public void clickStatistika(View view) {

        viborDat();
        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Statistika5.class);
        startActivity(intent);
    }

    public void clickRazvl(View v) {

        Intent intent = new Intent(this, MenuRazvlech9.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void viborDat() {

        Date segodnDate = new Date();
        Calendar calendar1 = Calendar.getInstance();
        String month = calendar1.getDisplayName(MONTH, Calendar.LONG_FORMAT, new Locale("RU"));

        SimpleDateFormat formatter3 = new SimpleDateFormat("dd");
        int a1 = Integer.parseInt(formatter3.format(segodnDate));

        SimpleDateFormat formatter4 = new SimpleDateFormat("EEEE", new Locale("ru", "DK"));
        String a2 = (formatter4.format(segodnDate));

        DateR = (a1 + "  " + month);
        DayR = a2;

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMM");
        KeyMonth = Integer.parseInt(formatter1.format(segodnDate));

        SimpleDateFormat formatter5 = new SimpleDateFormat("yyyyMMdd");
        Key = Integer.parseInt(formatter5.format(segodnDate));

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
        TypefaceMenu = a1;
    }
    public void clickVixod(View view) {
        this.finishAffinity();
    }  // СВЕРТЫВАЕТ ПРИЛОЖЕНИЕ

}


