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
 * Service do obslugi kalendarza
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


    /**
    * OS ma zaczynac service zaraz po otrzymaniu pamieci
    * */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    /**
    * tworzy konstruktor klasy AlarmTask
    * */
    public void setAlarm(Calendar c){
        new AlarmTask(this,c).run();
    }
}
