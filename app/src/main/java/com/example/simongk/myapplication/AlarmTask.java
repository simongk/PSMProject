package com.example.simongk.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 *
 * Service do notyfikacji
 */
public class AlarmTask implements Runnable {

    private final Calendar date;
    private final AlarmManager am;
    private final Context context;
    public AlarmTask(Context context, Calendar date) {
        this.context=context;
        this.am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        this.date= Calendar.getInstance();
    }

    @Override
    public void run() {
        Intent intent = new Intent(context,NotifyService.class);
        intent.putExtra(NotifyService.INTENT_NOTIFY,true);
        PendingIntent pendingIntent = PendingIntent.getService(context,0,intent,0);
        am.set(AlarmManager.RTC, date.getTimeInMillis(), pendingIntent);
    }
}
