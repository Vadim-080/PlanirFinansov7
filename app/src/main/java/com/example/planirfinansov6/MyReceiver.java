package com.example.planirfinansov6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Test", "RAN");  // Ведет журнал событий


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(new Intent(context, MyNewIntentService.class));
        } else {
            context.startService(new Intent(context, MyNewIntentService.class));
        }
    }
}



