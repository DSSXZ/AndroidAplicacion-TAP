package com.example.dssxz.ap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by DSSXZ on 20/05/2016.
 */
public class Editar extends Activity{
    ImageView imagenBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editara);

    }



    public void atras(View view){
        Intent nuevo= new Intent(this, Deudas.class);
        startActivity(nuevo);

    }


    public void aceptar(View view){
        if(validar(view)==false) {
            Intent nuevo1 = new Intent(this, Deudas.class);
            startActivity(nuevo1);
            Toast.makeText(Editar.this, "Se guardo", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent nuevo2 = new Intent(this, Editar.class);
            startActivity(nuevo2);
        }
    }



    public boolean validar(View view){
        String val1 = ((EditText)findViewById(R.id.editText)).getText().toString();
        String val2 = ((EditText)findViewById(R.id.editText2)).getText().toString();
        String val3 =((EditText)findViewById(R.id.editText3)).getText().toString();
        if(val1.equals("") || val2.equals("") || val3.equals("")){
            Toast.makeText(Editar.this, "Se deben insetar todos los datos", Toast.LENGTH_LONG).show();
            return true;
        }
        else{return false;}
    }
}
