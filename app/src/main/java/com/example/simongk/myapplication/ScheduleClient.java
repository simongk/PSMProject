package com.example.simongk.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.Calendar;

/**
 * Created by simongk on 01.06.16.
 */
public class ScheduleClient {
    private ScheduleService mBoundService;
    private Context mContext;
    private boolean misBound;
    public Calendar c = Calendar.getInstance();
    public ScheduleClient(Context context) {
        mContext=context;
    }

    public void doBindService() {
        mContext.bindService(new Intent(mContext,ScheduleService.class),mConnection,Context.BIND_AUTO_CREATE);
        misBound=true;
    }



    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBoundService = ((ScheduleService.ServiceBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBoundService = null;
        }
    };

    public void setAlarmForNotification(Calendar c){
        mBoundService.setAlarm(c);
    }

    public void doUnbindService() {
        if(misBound){
            mContext.unbindService(mConnection);
            misBound=false;
        }
    }
}
