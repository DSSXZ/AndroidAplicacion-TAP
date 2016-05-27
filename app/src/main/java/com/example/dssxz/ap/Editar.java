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
public class Editar extends Activity {
    EditText txtName, txtObj,txtDes;
    ImageView btnAdd;
    Boolean debuelto;

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
            txtName=(EditText)findViewById(R.id.editText);
            txtObj=(EditText)findViewById(R.id.editText2);
            txtDes=(EditText)findViewById(R.id.editText3);
            Intent nuevo1 = new Intent(this, Deudas.class);
            startActivity(nuevo1);
            Toast.makeText(Editar.this, "Se guardo", Toast.LENGTH_SHORT).show();
            final DBAdapter db=new DBAdapter(this);
            db.openDB();
            long result = db.add(txtName.getText().toString(), txtObj.getText().toString());
            if (result > 0) {
                txtName.setText("");
                txtObj.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();
            }
            //CLOSE DB
            db.close();
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

    public void cancelar(View view){
        ((EditText)findViewById(R.id.editText)).setText("");
        ((EditText)findViewById(R.id.editText2)).setText("");
        ((EditText)findViewById(R.id.editText3)).setText("");
        Intent nuevo3 = new Intent(this, Deudas.class);
        startActivity(nuevo3);
    }




}
