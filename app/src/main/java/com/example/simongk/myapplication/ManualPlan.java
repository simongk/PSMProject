package com.example.simongk.myapplication;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;

public class ManualPlan extends AppCompatActivity {
    public Spinner spinnerGodzinowy;
    public Dialog dialog;
    private GestureDetectorCompat mDetector;

    SQLiteDatabase planDB;
    Button stworzBaze,pokazPlan;
    TextView sp,sw,ss,sc,spt,dp,dw,ds,dc,dpt,jp,jw,js,jc,jpt,dwp,dww,dws,dwc,dwpt,cp,cw,cs,cc,cpt;


    public String dialogoweButtony(){
        EditText nazwa = (EditText) dialog.findViewById(R.id.editText);
        RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.rg);
            int rid = rg.getCheckedRadioButtonId();
            RadioButton rb = (RadioButton) dialog.findViewById(rid);
            String t1 = rb.getText().toString();
            String t = String.valueOf(t1.charAt(0));
            String t01 = nazwa.getText().toString().concat("-").concat(t).concat(" ");
            return t01;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manualplan);
        createDatabase();

        mDetector = new GestureDetectorCompat(this, new MyGestureListener());


        sp = (TextView) findViewById(R.id.sp);
        dp = (TextView) findViewById(R.id.dp);
        jp = (TextView) findViewById(R.id.jp);
        dwp = (TextView) findViewById(R.id.dwp);
        cp = (TextView) findViewById(R.id.cp);

        sw = (TextView) findViewById(R.id.sw);
        dw = (TextView) findViewById(R.id.dw);
        jw = (TextView) findViewById(R.id.jw);
        dww = (TextView) findViewById(R.id.dww);
        cw = (TextView) findViewById(R.id.cw);

        ss = (TextView) findViewById(R.id.ss);
        ds = (TextView) findViewById(R.id.ds);
        js = (TextView) findViewById(R.id.js);
        dws = (TextView) findViewById(R.id.dws);
        cs = (TextView) findViewById(R.id.cs);

        sc = (TextView) findViewById(R.id.sc);
        dc = (TextView) findViewById(R.id.dc);
        jc = (TextView) findViewById(R.id.jc);
        dwc = (TextView) findViewById(R.id.dwc);
        cc  = (TextView) findViewById(R.id.cc);

        spt = (TextView) findViewById(R.id.spt);
        dpt = (TextView) findViewById(R.id.dpt);
        jpt = (TextView) findViewById(R.id.jpt);
        dwpt = (TextView) findViewById(R.id.dwpt);
        cpt  = (TextView) findViewById(R.id.cpt);

        //okazPlan = (Button) findViewById(R.id.pokazPlan);


        Button b1 = (Button) findViewById(R.id.showd);
        getDatabase();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(ManualPlan.this);
                dialog.setTitle("Wstaw do planu");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogplan);


                spinnerGodzinowy = (Spinner) dialog.findViewById(R.id.spinnerGodzinowy);
                ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(ManualPlan.this,R.array.godziny,android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerGodzinowy.setAdapter(adapter1);

                final Spinner spinnerDniowy = (Spinner) dialog.findViewById(R.id.spinnerDniowy);
                ArrayAdapter adapter = ArrayAdapter.createFromResource(ManualPlan.this,R.array.dnitygodnia,android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerDniowy.setAdapter(adapter);


                Button b = (Button) dialog.findViewById(R.id.button3);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                        switch(spinnerDniowy.getSelectedItem().toString()){
                            case "Pon":
                                switch(spinnerGodzinowy.getSelectedItem().toString()){
                                case "7:30-9:00":
                                    planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                           "VALUES (0,'"+dialogoweButtony()+"');");
                                    dialog.dismiss();
                                    getDatabase();
                                    break;

                                case "9:15-10:45":
                                    planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                            "VALUES (1,'"+dialogoweButtony()+"');");
                                    dialog.dismiss();
                                    getDatabase();
                                    break;

                                case "11:00-12:30":
                                    planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                            "VALUES (2,'"+dialogoweButtony()+"');");
                                    dialog.dismiss();
                                    getDatabase();
                                    break;

                                case "12:45-14:15":
                                    planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                            "VALUES (3,'"+dialogoweButtony()+"');");
                                    dialog.dismiss();
                                    getDatabase();
                                    break;

                                case "14:30-16:00":
                                    planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                            "VALUES (4,'"+dialogoweButtony()+"');");
                                    dialog.dismiss();
                                    getDatabase();
                                    break;
                                }
                                break;

                            case "Wto":
                                switch(spinnerGodzinowy.getSelectedItem().toString()){
                                    case "7:30-9:00":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (5,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "9:15-10:45":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (6,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "11:00-12:30":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (7,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "12:45-14:15":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (8,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "14:30-16:00":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (9,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;
                                }
                                break;

                            case "Śr":
                                switch(spinnerGodzinowy.getSelectedItem().toString()){
                                    case "7:30-9:00":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (10,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "9:15-10:45":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (11,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "11:00-12:30":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (12,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "12:45-14:15":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (13,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "14:30-16:00":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (14,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;
                                }
                                break;

                            case "Czw":
                                switch(spinnerGodzinowy.getSelectedItem().toString()){
                                    case "7:30-9:00":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (15,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "9:15-10:45":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (16,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "11:00-12:30":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (17,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "12:45-14:15":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (18,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "14:30-16:00":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (19,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;
                                }
                                break;

                            case "Pt":
                                switch(spinnerGodzinowy.getSelectedItem().toString()){
                                    case "7:30-9:00":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (20,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "9:15-10:45":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (21,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "11:00-12:30":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (22,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "12:45-14:15":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (23,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;

                                    case "14:30-16:00":
                                        planDB.execSQL("INSERT OR REPLACE INTO zajecia (id,nazwa) " +
                                                "VALUES (24,'"+dialogoweButtony()+"');");
                                        dialog.dismiss();
                                        getDatabase();
                                        break;
                                }
                                break;
                        }
                    }catch(Exception e){
                        Toast.makeText(ManualPlan.this,"Zaznacz cos!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                dialog.show();

            }
        });

        Intent i = getIntent();
    }

    public void createDatabase() {
        try{

            planDB = this.openOrCreateDatabase("PlanNieparzysty",MODE_ENABLE_WRITE_AHEAD_LOGGING,null);
            planDB.execSQL("create table if not exists zajecia "+
                           "(id INTEGER PRIMARY KEY AUTOINCREMENT,nazwa VARCHAR);");
            File database = getApplicationContext().getDatabasePath("PlanNieparzysty");

            if(database.exists()){
                //Toast.makeText(this,"Baza stworzona/istnieje!",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"Nie ma bazy danych :(", Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Log.e("PLANNIEPARZYSTY ERROR","Blad w tworzeniu bazy");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ManualPlan.this,MainMenu.class));
    }

   public void getDatabase() {
        try {
            Cursor curosr = planDB.rawQuery("SELECT * from zajecia", null);
            int idColumn = curosr.getColumnIndex("id");
            int nazwaColumn = curosr.getColumnIndex("nazwa");
            curosr.moveToFirst();
            do {
                String nazwaZajecia = curosr.getString(nazwaColumn);
                String temp = curosr.getString(idColumn);
                int id = Integer.parseInt(temp);
                if (id == 0) sp.setText(nazwaZajecia);
                else if (id == 1) dp.setText(nazwaZajecia);
                else if (id == 2) jp.setText(nazwaZajecia);
                else if (id == 3) dwp.setText(nazwaZajecia);
                else if (id == 4) cp.setText(nazwaZajecia);

                else if (id == 5) sw.setText(nazwaZajecia);
                else if (id == 6) dw.setText(nazwaZajecia);
                else if (id == 7) jw.setText(nazwaZajecia);
                else if (id == 8) dww.setText(nazwaZajecia);
                else if (id == 9) cw.setText(nazwaZajecia);

                else if (id == 10) ss.setText(nazwaZajecia);
                else if (id == 11) ds.setText(nazwaZajecia);
                else if (id == 12) js.setText(nazwaZajecia);
                else if (id == 13) dws.setText(nazwaZajecia);
                else if (id == 14) cs.setText(nazwaZajecia);

                else if (id == 15) sc.setText(nazwaZajecia);
                else if (id == 16) dc.setText(nazwaZajecia);
                else if (id == 17) jc.setText(nazwaZajecia);
                else if (id == 18) dwc.setText(nazwaZajecia);
                else if (id == 19) cc.setText(nazwaZajecia);

                else if (id == 20) spt.setText(nazwaZajecia);
                else if (id == 21) dpt.setText(nazwaZajecia);
                else if (id == 22) jpt.setText(nazwaZajecia);
                else if (id == 23) dwpt.setText(nazwaZajecia);
                else if (id == 24) cpt.setText(nazwaZajecia);

                else Toast.makeText(ManualPlan.this, "Coś się stanęło :(", Toast.LENGTH_SHORT).show();

            } while (curosr.moveToNext());
        } catch (Exception e) {
            Toast.makeText(ManualPlan.this, "Coś się stanęło :(", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteDatabase(View view) {
        this.deleteDatabase("PlanNieparzysty");
    }

    @Override
    protected void onDestroy() {
        planDB.close();
        super.onDestroy();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class MyGestureListener implements GestureDetector.OnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            startActivity(new Intent(ManualPlan.this,ManualPlan2.class));
            return true;
        }
    }
}
