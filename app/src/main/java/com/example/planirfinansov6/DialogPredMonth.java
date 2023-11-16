package com.example.planirfinansov6;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;

public class DialogPredMonth extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder.setTitle("ВЫ ВЫБРАЛИ\nПРОШЕДШИЙ МЕСЯЦ\n")
                .setIcon(R.drawable.zz2)
                .setMessage("ЕСЛИ УВЕРЕНЫ НАЖМИТЕ ПРОДОЛЖИТЬ\n\n")
                .setPositiveButton("отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final DialogInterface.OnClickListener context = this;            // Переход на другой класс (сдесь класс Vvod)
                        Intent intent = new Intent((Context) context, MainActivity.class);
                        startActivity(intent);
                    }
                })

                .setNegativeButton("ПРОДОЛЖИТЬ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       /* summaDoxodRab.setText(summaDoshod);
                        date.setText(Kalendar2.Date);
                        day.setText(Kalendar2.Day);*/
                    }
                })
                .create();
    }
}

