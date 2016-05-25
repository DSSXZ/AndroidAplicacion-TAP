package com.example.dssxz.ap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void ventanaDeudas(View view){
        Intent nuevo1= new Intent(this, Deudas.class);
        startActivity(nuevo1);

    }

}
