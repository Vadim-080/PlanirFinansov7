package com.example.planirfinansov6;

import static com.example.planirfinansov6.Kalendar2.APP_PREFERENCES;
import static com.example.planirfinansov6.Kalendar2.mSettings;
import static com.example.planirfinansov6.Kalendar2.monthPrim;
import static com.example.planirfinansov6.MainActivity.KeyPrimMonth;
import static com.example.planirfinansov6.MainActivity.RassmatrivaemGod;
import static com.example.planirfinansov6.MainActivity.izmenMount;

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

    androidx.constraintlayout.widget.ConstraintLayout ConstraintLayout;
   /* private MyTargetView adView; // Рекламный  экземпляр класса
    RelativeLayout layout;
    RelativeLayout.LayoutParams adViewLayoutParams;
    private RewardedAd ad;*/

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primech);

 // СКРЫВАЕМ ВЕРХНЮЮ И НИЖНЮЮ СТРОКИ НАВИГАЦИИ
        ConstraintLayout = findViewById(R.id.ConstraintLayout_primech);
        int currentVis = ConstraintLayout.getSystemUiVisibility();
        int newVis;
        if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE) == View.SYSTEM_UI_FLAG_LOW_PROFILE) {
            newVis = View.SYSTEM_UI_FLAG_VISIBLE;
        } else {
            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        ConstraintLayout.setSystemUiVisibility(newVis);

/*// VK РЕКЛАМА
        layout = findViewById(R.id.RelativeLayout);
        adView = new MyTargetView(this);
        // Устанавливаем id слота
        adView.setSlotId(1535547);
        // Устанавливаем LayoutParams
        adViewLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        adViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adView.setLayoutParams(adViewLayoutParams);
        // Устанавливаем слушатель событий
        adView.setListener(new MyTargetView.MyTargetViewListener() {
            @Override
            public void onLoad(MyTargetView myTargetView) {
                // Данные успешно загружены, запускаем показ объявлений
                layout.addView(adView);
                *//*  layout.addView(adView, adViewLayoutParams );*//*
            }

            *//**
             * @param iAdLoadingError
             * @param myTargetView
             *//*
            public void onNoAd(@NonNull IAdLoadingError iAdLoadingError, @NonNull MyTargetView myTargetView) {
            }

            @Override
            public void onShow(MyTargetView myTargetView) {
            }

            @Override
            public void onClick(MyTargetView myTargetView) {
            }
        });
        // Запускаем загрузку данных
        adView.load();*/

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
            datePrim.setText("" + monthPrim + "  " + RassmatrivaemGod);
        }
    }

   /* @Override  // Остатки VK рекламы баннер
    protected void onDestroy() {
        if (adView != null) adView.destroy();
        super.onDestroy();
    }*/

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
        PrimMonth = textPrim.getText().toString();
        onPause();
        izmenMount = 0;
        Intent intent = new Intent(this, Kalendar2.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickStatistikaPr(View view) {
        PrimMonth = textPrim.getText().toString();
        onPause();
        izmenMount = 0;
        Date segodnDate1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy");
        RassmatrivaemGod = Integer.parseInt(formatter1.format(segodnDate1));
        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Statistika5.class);
        startActivity(intent);
    }

    public void clickMenu(View v) {

     /*   initAd(); // ВИДЕО РЕКЛАМА VK*/

        PrimMonth = textPrim.getText().toString();
        onPause();
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
        PrimMonth = textPrim.getText().toString();
        onPause();
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
        PrimMonth = textPrim.getText().toString();
        onPause();
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

  /*  // VK реклама ВИДЕО
    private void initAd() {
        // Включение режима отладки
        MyTargetManager.setDebugMode(true);

        // Создаем экземпляр RewardedAd
        ad = new RewardedAd(1535550, this);
        // Устанавливаем слушатель событий
        ad.setListener(new RewardedAd.RewardedAdListener() {
            @Override
            public void onLoad(RewardedAd ad) { // Запускаем показ
                ad.show();
            }
            @Override
            public void onNoAd(@NonNull IAdLoadingError iAdLoadingError, @NonNull RewardedAd rewardedAd) {
            }
            @Override
            public void onClick(RewardedAd ad) {
            }
            @Override
            public void onDisplay(RewardedAd ad) {
            }
            @Override
            public void onDismiss(RewardedAd ad) {
            }
            @Override
            public void onReward(@NonNull Reward reward, @NonNull RewardedAd ad) {
            }
        });
        // Запускаем загрузку данных
        ad.load();
    }*/
}

