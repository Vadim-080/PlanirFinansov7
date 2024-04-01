package com.example.planirfinansov6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.my.target.ads.MyTargetView;
import com.my.target.ads.Reward;
import com.my.target.ads.RewardedAd;
import com.my.target.common.MyTargetManager;
import com.my.target.common.models.IAdLoadingError;

public class MenuRazvlech9 extends AppCompatActivity {

    TextView nadpRazvl, nadp_1, nadp_2, nadp_3;
    Typeface TypefaceRazvl;   // ШРИФТ
    TextView tv1, tv2, tv3, tv7;
    Animation anim;

    androidx.constraintlayout.widget.ConstraintLayout ConstraintLayout;
    private MyTargetView adView; // Рекламный  экземпляр класса
    RelativeLayout layout;
    RelativeLayout.LayoutParams adViewLayoutParams;
    private RewardedAd ad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menurazvlech);

// СКРЫВАЕМ ВЕРХНЮЮ И НИЖНЮЮ СТРОКИ НАВИГАЦИИ
        ConstraintLayout = findViewById(R.id.ConstraintLayout_menurazvlech);
        int currentVis = ConstraintLayout.getSystemUiVisibility();
        int newVis;
        if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE) == View.SYSTEM_UI_FLAG_LOW_PROFILE) {
            newVis = View.SYSTEM_UI_FLAG_VISIBLE;
        } else {
            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        ConstraintLayout.setSystemUiVisibility(newVis);

// VK РЕКЛАМА
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
                /*  layout.addView(adView, adViewLayoutParams );*/
            }

            /**
             * @param iAdLoadingError
             * @param myTargetView
             */
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
        adView.load();

        nadpRazvl = (TextView) findViewById(R.id.nadpRazvl_view);
        nadp_1 = (TextView) findViewById(R.id.nadp_1);
        nadp_2 = (TextView) findViewById(R.id.nadp_2);
        nadp_3 = (TextView) findViewById(R.id.nadp_3);

        viborShrifta();
        nadpRazvl.setTypeface(TypefaceRazvl);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim6);
        tv7 = (TextView) findViewById(R.id.nadpRazvl_view);
        tv7.startAnimation(anim);
        nadp_1.setTypeface(TypefaceRazvl);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim14);
        tv1 = (TextView) findViewById(R.id.nadp_1);
        tv1.startAnimation(anim);
        nadp_2.setTypeface(TypefaceRazvl);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim15);
        tv2 = (TextView) findViewById(R.id.nadp_2);
        tv2.startAnimation(anim);
        nadp_3.setTypeface(TypefaceRazvl);    // ШРИФТ
        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim16);
        tv3 = (TextView) findViewById(R.id.nadp_3);
        tv3.startAnimation(anim);
    }

    @Override  // Остатки VK рекламы баннер
    protected void onDestroy() {
        if (adView != null) adView.destroy();
        super.onDestroy();
    }

    public void clickVideo(View v) {
        Intent intent = new Intent(this, RazvlVideo10.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickObuch(View v) {
        Intent intent = new Intent(this, Obuch12.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickTest(View v) {
        Intent intent = new Intent(this, Test11.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
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
        TypefaceRazvl = a1;
    }
    public void clickVixod(View view) {
        this.finishAffinity();
    }  // СВЕРТЫВАЕТ ПРИЛОЖЕНИЕ

    // VK реклама ВИДЕО
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
    }

}


