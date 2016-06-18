package com.example.simongk.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity  {


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
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.tygodnie);
        dialog.setCancelable(true);
        dialog.setTitle("Wybierz tydzień");

        RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.gruparadiowa);
        RadioButton nieparzysty = (RadioButton) dialog.findViewById(R.id.np);
        RadioButton parzysty = (RadioButton) dialog.findViewById(R.id.p);
        final Intent inp = new Intent(MainMenu.this,ManualPlan.class);
        final Intent ip = new Intent(MainMenu.this,ManualPlan2.class);

        nieparzysty.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(inp);
                dialog.dismiss();
            }
        });
        parzysty.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ip);
                dialog.dismiss();
            }
        });

        //Toast.makeText(this,"Zaznacz coś!",Toast.LENGTH_SHORT).show();
        dialog.show();
    }



}
