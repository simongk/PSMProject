package com.example.simongk.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Calendar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;



public class RememberYourDate extends AppCompatActivity {

    private ScheduleClient scheduleClient;
    private DatePicker picker;
    public Calendar c = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicking);
        scheduleClient = new ScheduleClient(this);
        scheduleClient.doBindService();

        picker = (DatePicker) findViewById(R.id.scheduleTimePicker);
    }

    public void onDateSelectedButtonClick(View v){
        //get date from date picker
        int day = picker.getDayOfMonth();
        int month = picker.getMonth();
        int year = picker.getYear();


        //new calendar on chosen date
        c.set(year,month,day);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);

        scheduleClient.setAlarmForNotification(c);
        Toast.makeText(this, "Przypomnienie ustawione na: "+ day +
                "/"+ (month+1) +"/"+ year, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        if(scheduleClient !=null) scheduleClient.doUnbindService();
        super.onStop();
    }
}
