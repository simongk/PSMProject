package com.example.simongk.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    public void seeSchedule(View view){
        startActivity(new Intent(MainMenu.this,WebPlan.class));
    }

    public void seeToDo(View view) {
        startActivity(new Intent(MainMenu.this, ToDoList.class));
    }

    public void seePlan(View vie){
        startActivity(new Intent(MainMenu.this,ManualPlan.class));
    }

    public void seeDatePicker(View v){
        startActivity(new Intent(MainMenu.this,RememberYourDate.class));
    }


}
