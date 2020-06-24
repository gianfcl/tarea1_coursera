package com.example.tarea1_coursera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class Confirmar_Datos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar__datos);

        Bundle parametros = getIntent().getExtras();

        String Nombre = parametros.getString("Nombre");
        String FecNac = parametros.getString("FecNac");
        String Telefono = parametros.getString("Telefono");
        String Contacto = parametros.getString("Contacto");
        String Descripcion = parametros.getString("Descripcion");

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvContacto = (TextView) findViewById(R.id.tvCorreo);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(Nombre);
        tvFechaNacimiento.setText(FecNac);
        tvTelefono.setText(Telefono);
        tvContacto.setText(Contacto);
        tvDescripcion.setText(Descripcion);
    }

    public void Regresarmain(View view){
        TextView nombre   = (TextView)findViewById(R.id.tvNombre);
        TextView fechanac   = (TextView)findViewById(R.id.tvFechaNacimiento);
        TextView telefono   = (TextView)findViewById(R.id.tvTelefono);
        TextView contacto   = (TextView)findViewById(R.id.tvCorreo);
        TextView descripcion   = (TextView)findViewById(R.id.tvDescripcion);
        Intent intent = new Intent(Confirmar_Datos.this,MainActivity.class);
        intent.putExtra("Nombre", nombre.getText().toString());
        intent.putExtra("FecNac",fechanac.getText().toString());
        intent.putExtra("Telefono",telefono.getText().toString());
        intent.putExtra("Contacto",contacto.getText().toString());
        intent.putExtra("Descripcion",descripcion.getText().toString());
        startActivity(intent);
    }
}