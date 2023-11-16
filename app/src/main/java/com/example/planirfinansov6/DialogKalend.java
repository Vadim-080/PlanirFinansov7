package com.example.planirfinansov6;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogKalend extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder.setTitle("ПОЖАЛУЙСТА!  ВЫБИРИТЕ ДРУГУЮ ДАТУ\n")

// ПОСТАВИТЬ ПРИКОЛЬНУЮ ИКОНКУ

                .setIcon(R.drawable.ic_launcher_foreground)
                .setMessage("мы же не знаем\nсколько заработаем в будущем\n\n")
                .setPositiveButton("ПРОДОЛЖИТЬ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final DialogInterface.OnClickListener context = this;            // Переход на другой класс (сдесь класс Vvod)
                        Intent intent = new Intent((Context) context, Kalendar2.class);
                        startActivity(intent);
                    }
                })
                .create();

    }

}

// ВЫВОДИТ КАЛЕНДАРЬ

   /* @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Передаем контекст, слушатель для выбора даты и текущую дату
        return new DatePickerDialog(getActivity(), listener, year, month, day);
    }

    // Слушатель для выбора даты, выводим на экран сообщение
    private DatePickerDialog.OnDateSetListener listener = (view, year, month, dayOfMonth) -> {
        String msg = "дата: " + dayOfMonth + "/" + (month + 1) + "/" + year;
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    };*/