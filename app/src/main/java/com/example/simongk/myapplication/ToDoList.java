package com.example.simongk.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ToDoList extends Activity {

    SQLiteDatabase planDB;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    public  ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist);
        //this.deleteDatabase("ToDo");
        //add
        createDatabase();
        lvItems=(ListView) findViewById(R.id.lvItems);
        items=new ArrayList<>();
        Cursor cursor = planDB.rawQuery("SELECT * from lista",null);
        int idCol = cursor.getColumnIndex("id");
        int trCol = cursor.getColumnIndex("tresc");
        cursor.moveToFirst();
        items=new ArrayList<String>();
        if(cursor!=null && (cursor.getCount()>0)){
            do {
                String id = cursor.getString(idCol);
                String tresc = cursor.getString(trCol);
                items.add(tresc);
            }while(cursor.moveToNext());}
            else Toast.makeText(this,"Czym?",Toast.LENGTH_SHORT).show();
        itemsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
        Intent i = getIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public void onAddItem(View v){
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText=etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        planDB.execSQL("INSERT INTO lista(tresc) values ('"+itemText+"');");
        etNewItem.setText("");
        //writeItems();
    }
    public void createDatabase() {
        try{

            planDB = this.openOrCreateDatabase("ToDo",MODE_ENABLE_WRITE_AHEAD_LOGGING,null);
            planDB.execSQL("create table if not exists lista "+
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT,tresc VARCHAR);");
            File database = getApplicationContext().getDatabasePath("ToDo");

            if(database.exists()){
                //Toast.makeText(this,"Baza stworzona/istnieje!",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"Nie ma bazy danych :(", Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Log.e("ToDo ERROR","Blad w tworzeniu bazy");
        }
    }





    private void setupListViewListener(){
        lvItems.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long id) {
                Dialog dialog = new Dialog(ToDoList.this);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.cozrobic);
                dialog.setTitle("Co zrobić?");
                final Button b1 = (Button) dialog.findViewById(R.id.button);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String item = items.get(position);
                        items.remove(position);
                        Cursor g = planDB.rawQuery("SELECT id from lista where tresc = '"+ item + "' ;",null);
                        int d = g.getColumnIndex("id");
                        g.moveToFirst();
                        String g1 = g.getString(d);
                        int e = Integer.parseInt(g1);
                        itemsAdapter.notifyDataSetChanged();
                        planDB.execSQL("DELETE FROM lista where id = " + e + " ;");
                        //ToDoList.this.deleteDatabase("ToDo");
                        //writeItems();
                    }
                });
                final Button b2 = (Button) dialog.findViewById(R.id.button2);
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ToDoList.this,RememberYourDate.class));
                    }
                });
                dialog.show();

                return true;
            }
        });
    }
}
