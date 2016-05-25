package com.example.dssxz.ap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by DSSXZ on 20/05/2016.
 */
public class Editar extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editara);

    }

    public void atras(View view){
        Intent nuevo= new Intent(this, Deudas.class);
        startActivity(nuevo);

    }
}
