package com.example.planirfinansov6;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class MyNewIntentService extends IntentService {
    private static final int NOTIFICATION_ID = 3;

    public MyNewIntentService() {
        super("MyNewIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("SH", "Simple", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Notifs");
            mNotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "SH")

                // https://developer.alexanderklimov.ru/android/notification.php   -- ОПИСАНЫ ВОЗМОЖНЫЕ ВАРИАНТЫ

                .setSmallIcon(R.drawable.ic_notification) // устанавливает маленький значок, который выводится в строке состояния, а также в правой части открытого уведомления
                .setContentTitle("    ❤️  ПРИВЕТ  ❤️") // title for notification
                .setContentText("ПОРА  МЕНЯ  ЗАПОЛНЯТЬ")// message for notification
                .setAutoCancel(true) // автоматически закрыть уведомление после нажатия
                .setPriority(NotificationCompat.PRIORITY_MAX)  // Приоритет уведомлений
                .setColor(Color.RED)  //  закрашивает значок и название приложения указанным цветом
                .setOngoing(true)  // выводит уведомление поверх обычных уведомлений, такое уведомление нельзя закрыть или смахнуть.
                .setLights(Color.GREEN, 300, 300)   // цвет LED-индикатора
                .setVibrate(new long[]{100, 250})
                .setDefaults(Notification.DEFAULT_SOUND)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.zay6));// устанавливает большой значок, который выводится в открытом уведомлении слева.

        int bigIcon = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? R.drawable.zz2 : R.drawable.zz2;

        Intent intent1 = new Intent(getApplicationContext(), Kalendar2.class);

        PendingIntent pi = PendingIntent.getActivity(this, 0, intent1, PendingIntent.FLAG_IMMUTABLE);
        mBuilder.setContentIntent(pi);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}

