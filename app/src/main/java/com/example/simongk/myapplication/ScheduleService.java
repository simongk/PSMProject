package com.example.simongk.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by simongk on 01.06.16.
 */
public class ScheduleService extends Service{
        public Calendar c = Calendar.getInstance();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final IBinder mBinder = new ServiceBinder();

    public class ServiceBinder extends Binder {
         ScheduleService getService(){
             return ScheduleService.this;
         }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("ScheduleService", "Received start id " + startId + ": " + intent);
        return START_STICKY;
    }

    public void setAlarm(Calendar c){
        new AlarmTask(this,c).run();
    }
}
