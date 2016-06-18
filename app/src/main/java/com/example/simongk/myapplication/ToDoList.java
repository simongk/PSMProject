package com.example.simongk.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ToDoList extends Activity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    public  ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist);
        //add
        lvItems=(ListView) findViewById(R.id.lvItems);
        items=new ArrayList<String>();
        readItems();
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
        etNewItem.setText("");
        writeItems();
    }



    private void setupListViewListener(){
        lvItems.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                Dialog dialog = new Dialog(ToDoList.this);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.cozrobic);
                dialog.setTitle("Co zrobić?");
                final Button b1 = (Button) dialog.findViewById(R.id.button);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        items.remove(position);
                        itemsAdapter.notifyDataSetChanged();
                        writeItems();
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

    private void readItems(){
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir,"todo.txt");
        try{
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        }catch(IOException e){
            items = new ArrayList<>();
        }
    }

    private void writeItems(){
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir,"todo.txt");
        try{
            FileUtils.writeLines(todoFile,items);
        } catch (IOException e){
            e.printStackTrace();
        }
    }






}
