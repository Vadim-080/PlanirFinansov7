package com.example.planirfinansov6;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyNewIntentService extends IntentService {
    private static final int NOTIFICATION_ID = 3;

    public MyNewIntentService() {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            NotificationChannel channel = new NotificationChannel("SH",
                    "Simple",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Notifs");
            mNotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "SH")
                .setSmallIcon(R.drawable.zay3) // notification icon
                .setContentTitle("ЗАЙКА") // title for notification
                .setContentText("пора заполнить меня за сегодня")// message for notification
                .setAutoCancel(true); // clear notification after click
        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pi);
        mNotificationManager.notify(0, mBuilder.build());

    }
}
