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

    private static final int NOTIFICATION = 123;
    public static final String INTENT_NOTIFY ="com.example.simongk.myapplication.service.INTENT_NOTIFY";
    private NotificationManager mNM;

    @Override
    public void onCreate() {
        Log.i("NotifyService","onCreate()");
        mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        // If this service was started by out AlarmTask intent then we want to show our notification
        if(intent.getBooleanExtra(INTENT_NOTIFY, false))
            showNotification();

        // We don't care if this service is stopped as we have already delivered our notification
        return START_NOT_STICKY;
    }
    private void showNotification() {
        // This is the 'title' of the notification
        CharSequence title = "Masz cos do zrobienia!";
        // This is the icon to use on the notification
        int icon = R.drawable.ic_dialog_alert;
        // This is the scrolling text of the notification
        CharSequence text = "Sprawdz liste notatek.";
        // What time to show on the notification
        long time = System.currentTimeMillis();
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, SecondActivity.class), 0);

        Notification.Builder notification = new Notification.Builder(this);
        notification.setAutoCancel(false);
        notification.setContentTitle(title);
        notification.setSmallIcon(icon);
        notification.setContentText(text);
        notification.setContentIntent(contentIntent);
        notification.build();


        Notification my = notification.getNotification();
        mNM.notify(11,my);
        // Send the notification to the system.


        // Stop the service when we are finished
        stopSelf();
    }

}
