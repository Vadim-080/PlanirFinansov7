package com.example.planirfinansov6;

import static com.example.planirfinansov6.Kalendar2.APP_PREFERENCES;
import static com.example.planirfinansov6.Kalendar2.mSettings;
import static com.example.planirfinansov6.MainActivity.KeyMonthD;
import static com.example.planirfinansov6.MainActivity.RassmatrivaemGod;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Statistika5 extends AppCompatActivity {

    BarChart barChart;

    // variable for our bar data.
    BarData barData;

    // variable for our bar data set.
    BarDataSet barDataSet;

    // array list for storing entries.
    ArrayList barEntriesArrayList;

    Animation anim;
    int monMinMax;
    String q;
    Typeface TypefaceStatist;   // ШРИФТ    TextView tv6;
    int KeyProm1, KeyPromDlyaVozvrata;
    double[] massiv;
    int znachZaMonth;

    TextView God;
    TextView month_1, month_2, month_3, month_4, month_5, month_6, month_7, month_8, month_9, month_10, month_11, month_12;
    TextView summa_1, summa_2, summa_3, summa_4, summa_5, summa_6, summa_7, summa_8, summa_9, summa_10, summa_11, summa_12;

    TextView znachenSrednDoxod, nadpMax, nadpMin, maxMonth, minMonth, znachenMax, znachenMin, nadp_sred_dox;

    androidx.constraintlayout.widget.ConstraintLayout ConstraintLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistika);

        // СКРЫВАЕМ ВЕРХНЮЮ И НИЖНЮЮ СТРОКИ НАВИГАЦИИ
        ConstraintLayout = findViewById(R.id.ConstraintLayout_statist);
        int currentVis = ConstraintLayout.getSystemUiVisibility();
        int newVis;
        if ((currentVis & View.SYSTEM_UI_FLAG_LOW_PROFILE) == View.SYSTEM_UI_FLAG_LOW_PROFILE) {
            newVis = View.SYSTEM_UI_FLAG_VISIBLE;
        } else {
            newVis = View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }
        ConstraintLayout.setSystemUiVisibility(newVis);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE); // Внутри метода onCreate() вы инициализируете переменную  mSettings

        month_1 = (TextView) findViewById(R.id.month_1_view);
        month_2 = (TextView) findViewById(R.id.month_2_view);
        month_3 = (TextView) findViewById(R.id.month_3_view);
        month_4 = (TextView) findViewById(R.id.month_4_view);
        month_5 = (TextView) findViewById(R.id.month_5_view);
        month_6 = (TextView) findViewById(R.id.month_6_view);
        month_7 = (TextView) findViewById(R.id.month_7_view);
        month_8 = (TextView) findViewById(R.id.month_8_view);
        month_9 = (TextView) findViewById(R.id.month_9_view);
        month_10 = (TextView) findViewById(R.id.month_10_view);
        month_11 = (TextView) findViewById(R.id.month_11_view);
        month_12 = (TextView) findViewById(R.id.month_12_view);

        summa_1 = (TextView) findViewById(R.id.summa_1_view);
        summa_2 = (TextView) findViewById(R.id.summa_2_view);
        summa_3 = (TextView) findViewById(R.id.summa_3_view);
        summa_4 = (TextView) findViewById(R.id.summa_4_view);
        summa_5 = (TextView) findViewById(R.id.summa_5_view);
        summa_6 = (TextView) findViewById(R.id.summa_6_view);
        summa_7 = (TextView) findViewById(R.id.summa_7_view);
        summa_8 = (TextView) findViewById(R.id.summa_8_view);
        summa_9 = (TextView) findViewById(R.id.summa_9_view);
        summa_10 = (TextView) findViewById(R.id.summa_10_view);
        summa_11 = (TextView) findViewById(R.id.summa_11_view);
        summa_12 = (TextView) findViewById(R.id.summa_12_view);

        nadp_sred_dox = (TextView) findViewById(R.id.nadp_sred_dox_view);
        znachenSrednDoxod = (TextView) findViewById(R.id.znachenSrednDoxod_view);
        nadpMax = (TextView) findViewById(R.id.nadpMax_view);
        nadpMin = (TextView) findViewById(R.id.nadpMin_view);
        maxMonth = (TextView) findViewById(R.id.maxMonth_view);
        minMonth = (TextView) findViewById(R.id.minMonth_view);
        znachenMax = (TextView) findViewById(R.id.znachenMax_view);
        znachenMin = (TextView) findViewById(R.id.znachenMin_view);

        KeyPromDlyaVozvrata = KeyMonthD; // ЗАПОМИНАЕТ НАЧАЛЬНОЕ ЗНАЧЕНИЕ KeyMonthD
        God = (TextView) findViewById(R.id.god_view);

        Date segodnDate1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy");
        int tekGod = Integer.parseInt(formatter1.format(segodnDate1));

        if (tekGod == RassmatrivaemGod) {
            ImageButton b1 = (ImageButton) findViewById(R.id.GodVpered_view);
            b1.setEnabled(false);
            ImageButton a1 = findViewById(R.id.GodVpered_view);   // ПРОЗРАЧНОСТЬ КНОПКИ
            a1.setAlpha(1f);
            a1.animate().alpha(0.2f).setDuration(1500);

            TextView b2 = (TextView) findViewById(R.id.nadpVper);
            b2.setEnabled(false);
            TextView a2 = findViewById(R.id.nadpVper);   // ПРОЗРАЧНОСТЬ КНОПКИ
            a2.setAlpha(1f);
            a2.animate().alpha(0.0f).setDuration(1500);
        }


        viborShrifta();
        month_1.setTypeface(TypefaceStatist);   // ШРИФТ
        month_2.setTypeface(TypefaceStatist);   // ШРИФТ
        month_3.setTypeface(TypefaceStatist);   // ШРИФТ
        month_4.setTypeface(TypefaceStatist);   // ШРИФТ
        month_5.setTypeface(TypefaceStatist);   // ШРИФТ
        month_6.setTypeface(TypefaceStatist);   // ШРИФТ
        month_7.setTypeface(TypefaceStatist);   // ШРИФТ
        month_8.setTypeface(TypefaceStatist);   // ШРИФТ
        month_9.setTypeface(TypefaceStatist);   // ШРИФТ
        month_10.setTypeface(TypefaceStatist);   // ШРИФТ
        month_11.setTypeface(TypefaceStatist);   // ШРИФТ
        month_12.setTypeface(TypefaceStatist);   // ШРИФТ
        nadp_sred_dox.setTypeface(TypefaceStatist);   // ШРИФТ
        God.setTypeface(TypefaceStatist);   // ШРИФТ

        God.setText("статистика за " + RassmatrivaemGod + " год");

        massiv = new double[12];
        KeyProm1 = ((RassmatrivaemGod + 10000) * 100) + 1;

        for (int i = 0; i <= 11; i++) {
            KeyMonthD = KeyProm1 + i;
            onResume();
            massiv[i] = znachZaMonth;
        }
        znachenSrednDoxod.setText("" + znachZaMonth); // ПРОВЕРКА КЛЮЧА

        summa_1.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom1 = Math.round((massiv[0] / 1000) * 10.0) / 10.0;
        if (prom1 != 0) {
            summa_1.setText("" + prom1);
        } else summa_1.setText("*");

        summa_2.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom2 = Math.round((massiv[1] / 1000) * 10.0) / 10.0;
        if (prom2 != 0) {
            summa_2.setText("" + prom2);
        } else summa_2.setText("*");

        summa_3.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom3 = Math.round((massiv[2] / 1000) * 10.0) / 10.0;
        if (prom3 != 0) {
            summa_3.setText("" + prom3);
        } else summa_3.setText("*");

        summa_4.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom4 = Math.round((massiv[3] / 1000) * 10.0) / 10.0;
        if (prom4 != 0) {
            summa_4.setText("" + prom4);
        } else summa_4.setText("*");

        summa_5.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom5 = Math.round((massiv[4] / 1000) * 10.0) / 10.0;
        if (prom5 != 0) {
            summa_5.setText("" + prom5);
        } else summa_5.setText("*");

        summa_6.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom6 = Math.round((massiv[5] / 1000) * 10.0) / 10.0;
        if (prom6 != 0) {
            summa_6.setText("" + prom6);
        } else summa_6.setText("*");

        summa_7.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom7 = Math.round((massiv[6] / 1000) * 10.0) / 10.0;
        if (prom7 != 0) {
            summa_7.setText("" + prom7);
        } else summa_7.setText("*");

        summa_8.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom8 = Math.round((massiv[7] / 1000) * 10.0) / 10.0;
        if (prom8 != 0) {
            summa_8.setText("" + prom8);
        } else summa_8.setText("*");

        summa_9.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom9 = Math.round((massiv[8] / 1000) * 10.0) / 10.0;
        if (prom9 != 0) {
            summa_9.setText("" + prom9);
        } else summa_9.setText("*");

        summa_10.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom10 = Math.round((massiv[9] / 1000) * 10.0) / 10.0;
        if (prom10 != 0) {
            summa_10.setText("" + prom10);
        } else summa_10.setText("*");

        summa_11.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom11 = Math.round((massiv[10] / 1000) * 10.0) / 10.0;
        if (prom11 != 0) {
            summa_11.setText("" + prom11);
        } else summa_11.setText("*");

        summa_12.setTypeface(TypefaceStatist);   // ШРИФТ
        double prom12 = Math.round((massiv[11] / 1000) * 10.0) / 10.0;
        if (prom12 != 0) {
            summa_12.setText("" + prom12);
        } else summa_12.setText("*");


        int q1 = 0;   // ВЫБОР МАКСИМАЛЬНОГО ЗНАЧЕНИЯ ЗА ГОД
        q = "янв";
        double max = massiv[0];
        for (int counter = 1; counter < massiv.length; counter++) {

            if (massiv[counter] > max) {
                max = massiv[counter];
                q1 = counter + 1;
            }
            double max1 = Math.round((max / 1000) * 10.0) / 10.0;
            znachenMax.setTypeface(TypefaceStatist);   // ШРИФТ
            if (max1 != 0) {
                znachenMax.setText("" + max1);
                monMinMax = q1;
                MonthMinMax();
                maxMonth.setText("" + q);
            } else {
                znachenMax.setText("-");
                maxMonth.setText("");
            }
        }

        if (tekGod != RassmatrivaemGod && znachenMax.getText().toString().contains("-")) {
            ImageButton b1 = (ImageButton) findViewById(R.id.GodNazad_view);
            b1.setEnabled(false);
            ImageButton a1 = findViewById(R.id.GodNazad_view);   // ПРОЗРАЧНОСТЬ КНОПКИ
            a1.setAlpha(1f);
            a1.animate().alpha(0.2f).setDuration(1500);

            TextView b2 = (TextView) findViewById(R.id.nadpNazad);
            b2.setEnabled(false);
            TextView a2 = findViewById(R.id.nadpNazad);   // ПРОЗРАЧНОСТЬ КНОПКИ
            a2.setAlpha(1f);
            a2.animate().alpha(0.0f).setDuration(1500);
        }

        int q2 = 1;      // ВЫБОР МИНИМАЛЬНОГО ЗНАЧЕНИЯ ЗА ГОД
        double min = 100000000;
        q = "янв";
        if (massiv[0] != 0) {
            min = massiv[0];
        }
        for (int counter = 1; counter < massiv.length; counter++) {

            if (massiv[counter] != 0) {
                if (massiv[counter] < min) {
                    min = massiv[counter];
                    q2 = counter + 1;
                }
            }
            double min1 = Math.round((min / 1000) * 10.0) / 10.0;
            znachenMin.setTypeface(TypefaceStatist);   // ШРИФТ
            if (min1 != 0) {
                if (min != 100000000) {
                    znachenMin.setText("" + min1);
                    monMinMax = q2;
                    MonthMinMax();
                    minMonth.setText("" + q);
                } else {
                    znachenMin.setText("-");
                    minMonth.setText("");
                }
            } else {
                znachenMin.setText("0");
            }
        }

        double sredn = massiv[0];
        for (int j = 1; j < massiv.length; j++) {
            sredn = sredn + massiv[j];
        }

        Date segodnDate2 = new Date();
        SimpleDateFormat formatter2 = new SimpleDateFormat("MM");
        int tekMonth = Integer.parseInt(formatter2.format(segodnDate2));
        Date segodnDate3 = new Date();
        SimpleDateFormat formatter3 = new SimpleDateFormat("dd");
        int kolichDey = Integer.parseInt(formatter3.format(segodnDate3));

        double kolDey = (tekMonth - 1) * 30.41 + kolichDey;

        if (tekGod != RassmatrivaemGod) {

            sredn = sredn / 12000;
            double sredn1 = Math.round(sredn * 10.0) / 10.0;
            znachenSrednDoxod.setTypeface(TypefaceStatist);   // ШРИФТ
            znachenSrednDoxod.setText("" + sredn1);
        } else {

            sredn = sredn / (1000 * (kolDey / 30.41));
            double sredn1 = Math.round(sredn * 10.0) / 10.0;
            znachenSrednDoxod.setTypeface(TypefaceStatist);   // ШРИФТ
            znachenSrednDoxod.setText("" + sredn1);
        }

        // Построение графика
        // https://otosection.com/creating-a-simple-graph-in-android-studio-with-graphview/  -  ВИДЕО ГРАФИК

        barChart = findViewById(R.id.chart);

        // calling method to get bar entries.
        getBarEntries();

        // creating a new bar data set.
        barDataSet = new BarDataSet(barEntriesArrayList, "");

        // creating a new bar data and
        // passing our bar data set.
        barData = new BarData(barDataSet);

        // below line is to set data
        // to our bar chart.
        barChart.setData(barData);

        // adding color to our bar data set.
        /*  barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);*/

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTypeface(Typeface.DEFAULT_BOLD);

        // setting text color.
        barDataSet.setValueTextColor(Color.MAGENTA);

        // setting text size
        barDataSet.setValueTextSize(12); // размер цифр столбцов

        barChart.getDescription().setEnabled(false);

        barChart.animateY(5000);
        barChart.getXAxis().setTextSize(10); // размер назв месяцев

        barChart.getXAxis().setTextColor(Color.BLUE);
        barChart.getXAxis().setTypeface(Typeface.DEFAULT_BOLD);

        barChart.setDrawBarShadow(false);   // ФОН столбцов

        barChart.setDrawValueAboveBar(true); // Значение каждой полосы рисуется выше неё

        barChart.setDrawGridBackground(false);  // ФОН всего графика

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP); // Надписи месяцев наверху
        xAxis.setLabelRotationAngle(-15);   // Поворот надписей месяцев
        xAxis.setLabelCount(26, true);  // количество линий оси Х
    }

    private void getBarEntries() {
        // creating a new array list
        barEntriesArrayList = new ArrayList<>();

        float q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12;

        if (summa_1.getText().toString().contains("*")) {
            q1 = 0;
        } else {
            q1 = Float.parseFloat((summa_1.getText().toString()));
        }

        if (summa_2.getText().toString().contains("*")) {
            q2 = 0;
        } else {
            q2 = Float.parseFloat(summa_2.getText().toString());
        }

        if (summa_3.getText().toString().contains("*")) {
            q3 = 0;
        } else {
            q3 = Float.parseFloat(summa_3.getText().toString());
        }

        if (summa_4.getText().toString().contains("*")) {
            q4 = 0;
        } else {
            q4 = Float.parseFloat(summa_4.getText().toString());
        }

        if (summa_5.getText().toString().contains("*")) {
            q5 = 0;
        } else {
            q5 = Float.parseFloat(summa_5.getText().toString());
        }

        if (summa_6.getText().toString().contains("*")) {
            q6 = 0;
        } else {
            q6 = Float.parseFloat(summa_6.getText().toString());
        }

        if (summa_7.getText().toString().contains("*")) {
            q7 = 0;
        } else {
            q7 = Float.parseFloat(summa_7.getText().toString());
        }

        if (summa_8.getText().toString().contains("*")) {
            q8 = 0;
        } else {
            q8 = Float.parseFloat(summa_8.getText().toString());
        }

        if (summa_9.getText().toString().contains("*")) {
            q9 = 0;
        } else {
            q9 = Float.parseFloat(summa_9.getText().toString());
        }

        if (summa_10.getText().toString().contains("*")) {
            q10 = 0;
        } else {
            q10 = Float.parseFloat(summa_10.getText().toString());
        }

        if (summa_11.getText().toString().contains("*")) {
            q11 = 0;
        } else {
            q11 = Float.parseFloat(summa_11.getText().toString());
        }

        if (summa_12.getText().toString().contains("*")) {
            q12 = 0;
        } else {
            q12 = Float.parseFloat(summa_12.getText().toString());
        }

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.
        barEntriesArrayList.add(new BarEntry(1f, q1));
        barEntriesArrayList.add(new BarEntry(2f, q2));
        barEntriesArrayList.add(new BarEntry(3f, q3));
        barEntriesArrayList.add(new BarEntry(4f, q4));
        barEntriesArrayList.add(new BarEntry(5f, q5));
        barEntriesArrayList.add(new BarEntry(6f, q6));
        barEntriesArrayList.add(new BarEntry(7f, q7));
        barEntriesArrayList.add(new BarEntry(8f, q8));
        barEntriesArrayList.add(new BarEntry(9f, q9));
        barEntriesArrayList.add(new BarEntry(10f, q10));
        barEntriesArrayList.add(new BarEntry(11f, q11));
        barEntriesArrayList.add(new BarEntry(12f, q12));

        String[] xAxisLables = new String[]{"", "янв", "фев", "март", "апр", "май", "июнь", "июль", "авг", "сент", "окт", "нояб", "дек"};

        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xAxisLables));
    }

    public void clickKalend(View v) {

        KeyMonthD = KeyPromDlyaVozvrata; // ВОЗВРАЩАЕТ НАЧАЛЬНОЕ ЗНАЧЕНИЕ KeyMonthD
        Intent intent = new Intent(this, Kalendar2.class);   // Переход на другой класс (сдесь класс Vvod)
        startActivity(intent);
    }

    public void clickMenu(View v) {

        Intent intent = new Intent(this, Menu8.class);   // Переход на другой класс
        startActivity(intent);
    }

    public void clickGodVpered(View v) {

        RassmatrivaemGod = RassmatrivaemGod + 1;
        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Statistika5.class);
        startActivity(intent);
    }

    public void clickGodNazad(View v) {
        ImageButton b1 = (ImageButton) findViewById(R.id.GodVpered_view);
        b1.setEnabled(true);
        RassmatrivaemGod = RassmatrivaemGod - 1;
        final Context context = this;            // Переход на другой класс (сдесь класс Statistika)
        Intent intent = new Intent(context, Statistika5.class);
        startActivity(intent);
    }

    public void clickPrimechSt(View view) {

        final Context context = this;            // Переход на другой класс (сдесь класс Primech)
        Intent intent = new Intent(context, Primech6.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {    // Получаем число из памяти
        super.onResume();

        if (mSettings.contains(String.valueOf(KeyMonthD))) {
            znachZaMonth = mSettings.getInt(String.valueOf(KeyMonthD), 0);
        } else {
            znachZaMonth = 0;
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
        TypefaceStatist = a1;
    }

    public void MonthMinMax() {
        switch (monMinMax) {
            case 1:
                q = "янв";
                break;
            case 2:
                q = "фев";
                break;
            case 3:
                q = "март";
                break;
            case 4:
                q = "апр";
                break;
            case 5:
                q = "май";
                break;
            case 6:
                q = "июнь";
                break;
            case 7:
                q = "июль";
                break;
            case 8:
                q = "авг";
                break;
            case 9:
                q = "сент";
                break;
            case 10:
                q = "окт";
                break;
            case 11:
                q = "нояб";
                break;
            case 12:
                q = "дек";
                break;
        }
    }
}

