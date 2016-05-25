package com.example.dssxz.ap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by DSSXZ on 20/05/2016.
 */
public class Deudas extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deudasp);

    }

    public void añadir(View view){
        Intent nuevo2= new Intent(this, Editar.class);
        startActivity(nuevo2);

    }

}
