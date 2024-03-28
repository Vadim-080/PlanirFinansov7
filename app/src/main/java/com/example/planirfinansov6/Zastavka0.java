package com.example.planirfinansov6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Zastavka0 extends AppCompatActivity {

    int cvet;  // цвет вывода слов
    Typeface TypefaceMainZast;   // ШРИФТ
    private TextView tv;
    private ImageView iv1, iv2;

  /*  private RewardedAd ad;*/

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zastavka);

       /* initAd();*/

        tv = (TextView) findViewById(R.id.tv);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);

        viborShrifta();  // ШРИФТ
        viborCveta();

        tv.setTypeface(TypefaceMainZast);
        tv.setTextColor(cvet);
        tv.setText("Я ТВОЙ \n ФИНАНСИСТ");

        Animation myanim1 = AnimationUtils.loadAnimation(this, R.anim.zastav_anim1);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.zastav_anim2);
        Animation myanim3 = AnimationUtils.loadAnimation(this, R.anim.zastav_anim3);
        iv1.startAnimation(myanim1);
        iv2.startAnimation(myanim2);
        tv.startAnimation(myanim3);


        final Intent i = new Intent(this, MainActivity.class);


        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };


        timer.start();
    }


/*// VK зелама ВИДЕО

    private void initAd() {
        // Включение режима отладки
        *//*MyTargetManager.setDebugMode(true);*//*

        // Создаем экземпляр RewardedAd
        ad = new RewardedAd(1533575, this);
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


    public void viborCveta() {

        byte a2 = (byte) (Math.random() * 11); // Случайное число от 0 до 9
        if (a2 == 1) {
            cvet = Color.parseColor("#059C00"); // Зеленый
        }
        if (a2 == 2) {
            cvet = Color.parseColor("#0037FF");  // Тёмно синий
        }
        if (a2 == 3) {
            cvet = Color.parseColor("#AA00FF");  // Фиолетовый
        }
        if (a2 == 4) {
            cvet = Color.parseColor("#6200EA");   // Тёмно фиолетовый
        }
        if (a2 == 5) {
            cvet = Color.parseColor("#2962FF"); // Светло синий
        }
        if (a2 == 6) {
            cvet = Color.parseColor("#987700");  // Тёмно желтый
        }
        if (a2 == 7) {
            cvet = Color.parseColor("#FF6D00");  // Оранжевый
        }
        if (a2 == 8) {
            cvet = Color.parseColor("#DD2C00");  // морковный
        }
        if (a2 == 9) {
            cvet = Color.parseColor("#D50000");  // Красный
        }
        if (a2 == 10) {
            cvet = Color.parseColor("#EF0B72");  // Алый
        }
        if (a2 == 0) {
            cvet = Color.parseColor("#001173"); // Очень тёмно синий
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
        TypefaceMainZast = a1;
    }
}