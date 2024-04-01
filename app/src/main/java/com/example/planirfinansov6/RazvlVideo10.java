package com.example.planirfinansov6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.my.target.ads.MyTargetView;
import com.my.target.ads.Reward;
import com.my.target.ads.RewardedAd;
import com.my.target.common.MyTargetManager;
import com.my.target.common.models.IAdLoadingError;

public class RazvlVideo10 extends AppCompatActivity {

    TextView nadpRazvl;
    Typeface TypefaceRazvl;   // ШРИФТ
    androidx.constraintlayout.widget.ConstraintLayout ConstraintLayout;
    private MyTargetView adView; // Рекламный  экземпляр класса
    RelativeLayout layout;
    RelativeLayout.LayoutParams adViewLayoutParams;
    private RewardedAd ad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        // СКРЫВАЕМ ВЕРХНЮЮ И НИЖНЮЮ СТРОКИ НАВИГАЦИИ
        ConstraintLayout = findViewById(R.id.ConstraintLayout_video);
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
        viborShrifta();
        nadpRazvl.setTypeface(TypefaceRazvl);    // ШРИФТ
    }

    @Override  // Остатки VK рекламы баннер
    protected void onDestroy() {
        if (adView != null) adView.destroy();
        super.onDestroy();
    }

    public void clickMenu(View v) {

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


