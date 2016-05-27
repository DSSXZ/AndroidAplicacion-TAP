package com.example.dssxz.ap;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by DSSXZ on 20/05/2016.
 */
public class Deudas extends Activity{
    ListView lv;
    ArrayList<String> players=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    DBAdapter bas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deudasp);

    }

    public void añadir(View view){
        Intent nuevo2= new Intent(this, Editar.class);
        startActivity(nuevo2);

    }

    public void atras(View view){
        Intent nuevo2= new Intent(this, MainActivity.class);
        startActivity(nuevo2);
    }


    public void ver(View view) {
        final DBAdapter db=new DBAdapter(this);
        lv = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, players);
        final DBAdapter db1 = new DBAdapter(this);
        initDB();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                    long id) {
                // TODO Auto-generated method stub
                int n=(int)lv.getSelectedItemPosition();
                borrar(n);
                Toast.makeText(getApplicationContext(), "Devuelto+ ", Toast.LENGTH_LONG).show();


            }
        });
    }

    private void borrar(int n) {
        final DBAdapter db1=new DBAdapter(this);
        players.clear();
        //OPEN
        db1.openDB();
        //RETRIEVE
        Cursor c=db1.getAllNames();


        if(c.moveToPosition(n+1)){
            String name = c.getString(0);
            db1.delateData(name);
        }//While

        lv.setAdapter(adapter);
        db1.close();
    }

    public void casos(){

    }

    private void initDB() {
        final DBAdapter db1=new DBAdapter(this);
        players.clear();
        //OPEN
        db1.openDB();
        //RETRIEVE
        Cursor c=db1.getAllNames();
        while(c.moveToNext()){
            String name=c.getString(1)+"   Debe: "+c.getString(2);
            players.add(name);
        }//While
        lv.setAdapter(adapter);
        db1.close();
    }

    public ArrayAdapter formatAdapter(){
        final DBAdapter db1=new DBAdapter(this);
        db1.readDB();
        return adapter;

    }//formatAdaper

}
