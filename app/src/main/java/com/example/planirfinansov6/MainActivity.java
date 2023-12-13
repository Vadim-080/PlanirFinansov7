
// ПЛАНИРОВЩИК ФИНАНСОВ ДЛЯ ПАРИКМАХЕРА
// НАЧАЛО РАЗРАБОТКИ 01.09.2023

package com.example.planirfinansov6;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_REMINDER = 1;
    public static int Key, KeyDR, KeyDP; // Key - промежуточн ключ = год-месяц-дата,    KeyDR - ключ Доход с Работы = дата,    KeyDP - ключ Доход с Продаж = 1дата.
    public static int KeyRR, KeyRP; // KeyRR - ключ Расход за Расходники для работы = 2дата,    KeyRP - ключ Расход за Продукцию на продажу = 3дата.
    public static int KeySumD, KeySumR; // KeySumD - ключ Суммы Дохода = 8дата, KeySumR - ключ Суммы Расхода = 9дата
    public static int KeyMonth, KeyMonthD, KeyMonthR; // KeyMonth - промежуточн ключ = год-месяц,  KeyMonthD - ключ Суммы Дохода за месяц = 1год-месяц, KeyMonthR - ключ Суммы Расхода за месяц = 2год-месяц.
    public static int KeySumMonthRR, KeySumMonthRP, KeyPrimMonth, KeyDTolko; // KeySumMonthRR - ключ Суммы Расхода за Месяц за Расходники= 3год-месяц,
    // KeySumMonthRP - ключ Суммы Расхода за Месяц за Продукцию = 4год-месяц, KeyPrimMonth - ключ примечания за Месяц = 5год-месяц, KeyDTolko - ключ Только Доход без расхода = 6год-месяц.
    public static double KeyD_1, KeyD_2, KeyD_3, KeyD_4, KeyD_5, KeyD_6, KeyD_7, KeyD_8, KeyD_9, KeyD_11; // KeyD_ - ключи для полей ввода  = год-месяц-дата + 0,1 или 0,2...,
    public static double KeyR_1, KeyR_2, KeyR_3, KeyR_4;
    public static int RassmatrivaemGod;
    public static int summaDoxodZaMonth, summaRasxodZaMonth;
    int cvet;  // цвет вывода слов
    boolean time = true;
    public static int izmenMount = 0;
    Typeface TypefaceMainAct;   // ШРИФТ
    TextView tv1, tv2, tv3, tv4;
    TextView citat;
    Animation anim;
    String Citata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citat = (TextView) findViewById(R.id.textView2);

        viborShrifta();  // ШРИФТ
        viborCveta();
        citat.setTextColor(cvet);
        viborCitat();
        citat.setText("" + Citata);

        Date segodnDate1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy");
        RassmatrivaemGod = Integer.parseInt(formatter1.format(segodnDate1));

        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim1);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv1.startAnimation(anim);

        String timeStamp = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
        byte q = Byte.parseByte(timeStamp);
        tv1.setTypeface(TypefaceMainAct);
        if (q >= 5 && q < 11) {
            tv1.setText("ДОБРОЕ УТРО ЗАЯ");
        }
        if (q >= 11 && q < 18) {
            tv1.setText("ДОБРЫЙ ДЕНЬ ЗАЙКА");
        }
        if (q >= 18 && q < 23) {
            tv1.setText("ДОБРЫЙ ВЕЧЕР ЗАЙЧЁНОК");
        }
        if (q >= 23 || q < 5) {
            tv1.setText("ДОБРОЙ НОЧИ");
            anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim3);
            tv3 = (TextView) findViewById(R.id.textView2);
            tv3.setTypeface(TypefaceMainAct);
            tv3.startAnimation(anim);
            tv3.setText("НОЧЬЮ \n НАДО СПАТЬ \n ПОЦЕЛУЙ \n И ОБНИМИ \n СВОЕГО ЗАЙКУ \n И ИДИ СПАТЬ");

            anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim4);
            tv4 = (TextView) findViewById(R.id.buNachnem);
            tv4.setTypeface(TypefaceMainAct);
            tv4.startAnimation(anim);
            tv4.setText("СПОКОЙНОЙ НОЧИ");
            time = false;

            ImageButton b1 = (ImageButton) findViewById(R.id.Menu);
            b1.setEnabled(false);
            ImageButton a1 = findViewById(R.id.Menu);   // ПРОЗРАЧНОСТЬ КНОПКИ
            a1.setAlpha(1f);
            a1.animate().alpha(0.2f).setDuration(1500);

            TextView b2 = (TextView) findViewById(R.id.textView2);
            b2.setEnabled(false);
            return;
        }

        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim2);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setTypeface(TypefaceMainAct);
        tv2.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.tv_anim4);
        tv4 = (TextView) findViewById(R.id.buNachnem);
        tv4.setTypeface(TypefaceMainAct);
        tv4.startAnimation(anim);

        //  УВЕДОМЛЕНИЯ
        // https://stackru.com/questions/54083216/sozdanie-uvedomleniya-android-kotoroe-povtoryaetsya-kazhdyij-den-v-opredelennoe?ysclid=lplngnkswq786714462

        Intent notifyIntent = new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_REMINDER, notifyIntent, PendingIntent.FLAG_IMMUTABLE);

        /*notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);*/    // Выбивает приложение на телефоне после заставки

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 51);
        calendar.set(Calendar.SECOND, 10);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        // ПЕРЕЛИСТЫВАНИЕ
        //  https://translated.turbopages.org/proxy_u/en-ru.ru.e25f5593-656f2ba2-ba476bb2-74722d776562/https/www.geeksforgeeks.org/viewpager2-in-android-with-example/

    }

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
        TypefaceMainAct = a1;
    }

    public void clickNachnem(View view) {  // Переход на календарь

        if (time == true) {
            final Context context = this;
            Intent intent = new Intent(context, Kalendar2.class);
            startActivity(intent);
        } else {
            time = true;
            this.finishAffinity();      // СВЕРТЫВАЕТ ПРИЛОЖЕНИЕ
        }
    }

    public void clickMenu(View view) {    // Переход в меню
        final Context context = this;
        Intent intent = new Intent(context, Menu8.class);
        startActivity(intent);
    }

    public void viborCitat() {
        byte b = (byte) (Math.random() * 84); // Случайное число

        if (b == 0) {
            Citata = "Будьте свободны от стресса и верьте в мастерство и волшебство своих парикмахеров";
        }
        if (b == 1) {
            Citata = "Большинство парикмахеров спрашивают: «Кто сделал эту стрижку? Это уже не в моде. Регулярно приходите сюда и сделайте новую модную стрижку»";
        }
        if (b == 2) {
            Citata = "Я любимая клиентка своего парикмахера, потому что даю ей свободу делать все, что она хочет";
        }
        if (b == 3) {
            Citata = "У меня нет времени выходить замуж, потому что я слишком занят, чтобы уложить волосы моей клиентки";
        }
        if (b == 4) {
            Citata = "Большинство женщин парикмахера любят больше, чем партнера";
        }
        if (b == 5) {
            Citata = "Мой парикмахер каждый день экспериментирует с моими волосами";
        }
        if (b == 6) {
            Citata = "Неважно, есть ли у вас несовершенная жизнь, если у вас есть идеальный парикмахер";
        }
        if (b == 7) {
            Citata = "Парикмахеры остры, как бритва, и знают, как лучше справиться с волосатыми ситуациями";
        }
        if (b == 8) {
            Citata = "1 вселенная, 8 планет, 204 страны, 804 острова, 7 морей, 7 миллиардов человек, и я нашел 1 фантастического человека, который меня понял; мой парикмахер";
        }
        if (b == 9) {
            Citata = "Парикмахеры раскрывают в вас красоту";
        }
        if (b == 10) {
            Citata = "Неважно, насколько плох ваш день, если вы рассказываете об этом своему парикмахеру";
        }
        if (b == 11) {
            Citata = "Нет терапевта лучше парикмахера";
        }
        if (b == 12) {
            Citata = "Парикмахер - это терапевт, который вам действительно нужен";
        }
        if (b == 13) {
            Citata = "Никто не сделает вас лучше, чем хороший парикмахер";
        }
        if (b == 14) {
            Citata = "Хороший парикмахер видит ваш потенциал, чтобы выглядеть красиво, задолго до вас";
        }
        if (b == 15) {
            Citata = "Ничего подобного парикмахеру, заставляющего женщину чувствовать себя красивой";
        }
        if (b == 16) {
            Citata = "Парикмахерское дело - это образ жизни, который побуждает никогда не отказываться от прически";
        }
        if (b == 17) {
            Citata = "Хороший парикмахер - это как хороший муж: когда вы их находите, вы выходите за них замуж";
        }
        if (b == 18) {
            Citata = "Нет ничего лучше для вашей самооценки, чем хороший парикмахер";
        }

        if (b == 19) {
            Citata = "Парикмахер - это одновременно и терапевт, и средство повышения самооценки, и своего рода закрученный друг в одном пакете";
        }
        if (b == 20) {
            Citata = "Мы, стилисты, знаем, как найти самое слабое место женщины и сделать ее сильной, работая с красотой";
        }

        if (b == 21) {
            Citata = "Нет ничего лучше, чем хороший парикмахер, чтобы высказать свое мнение о ваших повседневных проблемах и при этом стать красивее";
        }
        if (b == 22) {
            Citata = "Между парикмахером и его клиенткой существует неразрывная связь";
        }
        if (b == 23) {
            Citata = "У меня личные отношения с моим парикмахером, в которых красота соединяется с душой так, как это может обеспечить только парикмахер";
        }
        if (b == 24) {
            Citata = "Парикмахер - это художник, который играет с красотой, которая лежит как снаружи, так и внутри";
        }
        if (b == 25) {
            Citata = "Плохие волосы - это просто результат отсутствия парикмахера";
        }
        if (b == 26) {
            Citata = "Хотите увидеть чудо? Сходите к хорошему парикмахеру";
        }
        if (b == 27) {
            Citata = "Моя парикмахерская похожа на семью, потому что она заставляет меня чувствовать себя красивой снаружи и внутри";
        }
        if (b == 28) {
            Citata = "Я никогда не причесываюсь, потому что это дитя моего парикмахера, и он не позволяет мне трогать его, и, честно говоря, я бы предпочел, чтобы это было так";
        }
        if (b == 29) {
            Citata = "Есть только один способ узнать, можно ли спасти мои волосы; пойдем к парикмахеру";
        }
        if (b == 30) {
            Citata = "Я знаю только одного человека, который может исправить эту неприятную ситуацию; мой парикмахер";
        }
        if (b == 31) {
            Citata = "Я никогда не видела лучшей волшебной палочки, как ножницы моего парикмахера";
        }
        if (b == 32) {
            Citata = "После посещения моего парикмахера мир выглядит по-другому";
        }
        if (b == 33) {
            Citata = "Парикмахер играет с созданием и изменением чистой красоты, разве это не артистично?";
        }
        if (b == 34) {
            Citata = "Я хожу к парикмахеру не только для того, чтобы поправить волосы; Я иду к ней за сохранностью ее ремесла";
        }
        if (b == 35) {
            Citata = "Для хорошего парикмахера каждый клиент - это мир, к которому можно подойти только по-своему";
        }
        if (b == 36) {
            Citata = "Мой парикмахер не только укладывает мои волосы, он проникает в мое сердце и связывает его с той красотой, которую он создает";
        }
        if (b == 37) {
            Citata = "Парикмахер повышает самооценку многих влиятельных и неудержимых женщин";
        }
        if (b == 38) {
            Citata = "С красивыми волосами не с чем родиться; это то, с чем должны работать профессионалы";
        }
        if (b == 39) {
            Citata = "Парикмахер делает не только хорошие волосы; они придают вам уверенности, что всегда является лучшей прической";
        }
        if (b == 40) {
            Citata = "В моей жизни есть до и после, и это встреча с моим парикмахером";
        }
        if (b == 41) {
            Citata = "Мой парикмахер острый, как нож, но сладкий, как торт, и красота, которую она создает, - это красота, которую я чувствую";
        }
        if (b == 42) {
            Citata = "Куда бы я ни пошла и стала центром внимания, мой парикмахер всегда позади меня";
        }
        if (b == 43) {
            Citata = "Убедитесь, что вы строите хорошие отношения со своим парикмахером. От этого зависит ваша самооценка";
        }
        if (b == 44) {
            Citata = "Никогда, никогда, никогда не отказывайтесь от своих волос";
        }
        if (b == 45) {
            Citata = "Парикмахерское дело - это не работа, это ремесло";
        }
        if (b == 46) {
            Citata = "Друзья приходят и уходят, а хороший парикмахер - навсегда";
        }
        if (b == 47) {
            Citata = "День волос - лучший день…";
        }
        if (b == 48) {
            Citata = "Будьте вежливы со своим парикмахером. Мы можем испортить вам самооценку на полгода за пятнадцать минут";
        }
        if (b == 49) {
            Citata = "Всегда мудро вести себя хорошо с человеком, который держит ножницы у вашей головы";
        }
        if (b == 50) {
            Citata = "Если бы я не выступал, я был бы косметологом или терапевтом. Я люблю творчество, но также люблю помогать другим. Моя мама была парикмахером, и они прислушивались к любым проблемам - как косметолог";
        }
        if (b == 51) {
            Citata = "Сохраняйте спокойствие и наймите модного стилиста";
        }
        if (b == 52) {
            Citata = "Как стилисты, мы занимаемся землей и работаем днем. Устанавливает тенденции, укрепляя особую связь между внутренним и внешним \"я\" человека";
        }
        if (b == 53) {
            Citata = "Жизнь полна борьбы и проблем, но в конце концов вы найдете стилиста, который вас понимает";
        }
        if (b == 54) {
            Citata = "Парикмахеры - прекрасная порода. Вы работаете один на один с другим человеком, и цель состоит в том, чтобы заставить его чувствовать себя намного лучше и взглянуть на себя с огоньком в глазах";
        }
        if (b == 55) {
            Citata = "На самом деле не бывает людей с плохими волосами. Просто люди, которые не нашли подходящего парикмахера";
        }
        if (b == 56) {
            Citata = "Мои клиенты - это моя большая семья ... Без них моя карьера была бы невозможна. - Дарлин Кент Роджерс";
        }
        if (b == 57) {
            Citata = "Честно говоря, я буквально даже не знаю, как укладывать волосы, если только не участвую в мероприятии, потому что полагаюсь на стилистов";
        }
        if (b == 58) {
            Citata = "Лучшие парикмахеры никогда не перестают учиться";
        }
        if (b == 59) {
            Citata = "Прихорашиваться нелегко";
        }
        if (b == 60) {
            Citata = "Трудолюбивый художник, придающий неповторимый стиль вашему образу и демонстрирующий высочайший талант";
        }
        if (b == 61) {
            Citata = "Жизнь слишком коротка, чтобы иметь скучные волосы";
        }
        if (b == 62) {
            Citata = "Я могу сделать кого-нибудь на 10 лет моложе без ножа";
        }
        if (b == 63) {
            Citata = "Я играю с ножницами, чтобы получить удовольствие от стрижки";
        }
        if (b == 64) {
            Citata = "После стрижки все становится лучше";
        }
        if (b == 65) {
            Citata = "Любовь к прекрасному - это вкус. Создание красоты - это искусство";
        }
        if (b == 66) {
            Citata = "ЗАЙКА МОЯ Я ТЕБЯ ЛЮБЛЮ";
        }
        if (b == 67) {
            Citata = "Я хотела, чтобы люди чувствовали себя красивыми, и стала парикмахером";
        }
        if (b == 68) {
            Citata = "ТВОЙ ЗАЙКА ОЧЕНЬ ОЧЕНЬ ПО ТЕБЕ СКУЧАЕТ";
        }
        if (b == 69) {
            Citata = "Я не просто парикмахер. Вы не просто клиент. Вместе я обещаю раскрыть красоту и уверенность, которых никогда не было бы с химическими веществами";
        }
        if (b == 70) {
            Citata = "«Парикмахеры» - замечательный человек, трогающий больше сердец, чем волос";
        }
        if (b == 71) {
            Citata = "«Дешевые стрижки не годятся! хорошие стрижки не из дешевых";
        }
        if (b == 72) {
            Citata = "«За каждой красивой женщиной стоит парикмахер, который ее любит";
        }
        if (b == 73) {
            Citata = "«Ты самый яркий момент в моей жизни";
        }
        if (b == 74) {
            Citata = "«Красота исходит изнутри. Внутри парикмахерской";
        }
        if (b == 75) {
            Citata = "«Хорошие волосы не случаются. Это происходит по предварительной записи";
        }
        if (b == 76) {
            Citata = "«Я думаю, что самое важное, что может иметь женщина помимо таланта, - это, конечно, парикмахер";
        }
        if (b == 77) {
            Citata = "«Жизнь прекраснее, когда ты встречаешь правильного парикмахера";
        }
        if (b == 78) {
            Citata = "«Тебе не нужно быть кинозвездой, чтобы я уложила твою прическу, когда ты сидишь в моем кресле, ты моя кинозвезда";
        }
        if (b == 79) {
            Citata = "«Хороший парикмахер всегда поможет вам в острой необходимости";
        }
        if (b == 80) {
            Citata = "«Парикмахеры похожи на пластических хирургов, вооруженных только ножницами и лаком для волос";
        }
        if (b == 81) {
            Citata = "«Хорошие прически могут случиться случайно, но вы можете добиться этого, записавшись на прием к парикмахеру";
        }
        if (b == 82) {
            Citata = "«Самое близкое, что вы получите к волшебнику, - это парикмахер в дни плохой прически";
        }
        if (b == 83) {
            Citata = "«Вы хотите повысить свою уверенность в себе? Убедитесь, что вы нашли подходящего парикмахера, потому что он может сделать намного лучше, чем терапевт";
        }
    }
}



