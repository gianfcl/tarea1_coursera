package com.example.tarea1_coursera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {


    EditText nombre;
    DatePicker fechanac;
    EditText telefono;
    EditText contacto;
    EditText descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros = getIntent().getExtras();
        if (parametros !=null){
            String Nombre = parametros.getString("Nombre");
            String FecNac = parametros.getString("FecNac");
            String[] datosfecha = FecNac.split("-");
            String Telefono = parametros.getString("Telefono");
            String Contacto = parametros.getString("Contacto");
            String Descripcion = parametros.getString("Descripcion");

            EditText vetNombre = (EditText) findViewById(R.id.etNombre);
            Log.i("0",FecNac);
            DatePicker vdpFechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);
            EditText vetTelefono = (EditText) findViewById(R.id.etTelefono);
            EditText vetContacto = (EditText) findViewById(R.id.etContacto);
            EditText vetDescripcion = (EditText) findViewById(R.id.etDescripcion);

            vetNombre.setText(Nombre);
            vdpFechaNacimiento.init(Integer.parseInt(datosfecha[2]), Integer.parseInt(datosfecha[1])-1, Integer.parseInt(datosfecha[0]), null);
            vetTelefono.setText(Telefono);
            vetContacto.setText(Contacto);
            vetDescripcion.setText(Descripcion);
        }
    }

    public void ConfirmarDatos(View view){
        nombre   = (EditText)findViewById(R.id.etNombre);
        fechanac   = (DatePicker)findViewById(R.id.dpFechaNacimiento);
        telefono   = (EditText)findViewById(R.id.etTelefono);
        contacto   = (EditText)findViewById(R.id.etContacto);
        descripcion   = (EditText)findViewById(R.id.etDescripcion);
        Intent intent = new Intent(MainActivity.this,Confirmar_Datos.class);
        intent.putExtra("Nombre", nombre.getText().toString());
        intent.putExtra("FecNac",fechanac.getDayOfMonth()+"-"+ConvertirMes(fechanac.getMonth())+"-"+fechanac.getYear());
        intent.putExtra("Telefono",telefono.getText().toString());
        intent.putExtra("Contacto",contacto.getText().toString());
        intent.putExtra("Descripcion",descripcion.getText().toString());
        startActivity(intent);
    }

    public String ConvertirMes(int number)
    {
        number = number+1;
        return number<=9?"0"+number:String.valueOf(number);
    }
}