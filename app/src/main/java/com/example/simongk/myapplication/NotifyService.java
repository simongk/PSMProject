package com.example.simongk.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Created by simongk on 01.06.16.
 *
 * Service do obsłgi powiadomien
 */
public class NotifyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
    private final IBinder mBinder = new ServiceBinder();


    public class ServiceBinder extends Binder{
        NotifyService getService(){
            return NotifyService.this;
        }
    }

    public static final String INTENT_NOTIFY ="com.example.simongk.myapplication.service.INTENT_NOTIFY";
    private NotificationManager mNM;

    /**
    * @return tworzy powiadomienie
    * */
    @Override
    public void onCreate() {
        mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }
    /**
    * funkcja gdy otrzyma intent to zaczyna funkcje showNotification
    * */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent.getBooleanExtra(INTENT_NOTIFY, false))
            showNotification();
        return START_NOT_STICKY;
    }

    /**
    * funkcja pokazujaca powiadomienie i zawierajaca informacje o nim
    * */
    private void showNotification() {
        // This is the 'title' of the notification
        CharSequence title = "Masz coś do zrobienia!";
        // This is the icon to use on the notification
        int icon = R.drawable.ic_dialog_alert;
        // This is the scrolling text of the notification
        CharSequence text = "Sprawdź listę notatek.";
        // What time to show on the notification
        long time = System.currentTimeMillis();
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, ToDoList.class), 0);

        Notification.Builder notification = new Notification.Builder(this);
        notification.setAutoCancel(false);
        notification.setContentTitle(title);
        notification.setSmallIcon(icon);
        notification.setContentText(text);
        notification.setContentIntent(contentIntent);
        notification.build();

        mNM.notify(11,notification.build());

        stopSelf();
    }

}
