package com.edisondeveloper.petagram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MailActivity extends AppCompatActivity {

    private Button send;
    private EditText name;
    private EditText email;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        send = findViewById(R.id.boton_enviar);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        message = findViewById(R.id.msg);
        Toolbar toolbar = findViewById(R.id.appBarLayout);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.button_back);
        }
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validacion();
            }
        });
    }

    public void validacion() {
        String nombre = name.getText().toString();
        String correo = email.getText().toString();
        String mensaje = message.getText().toString();
        if(nombre.length() < 13 | nombre.isEmpty()){
            name.setError(getString(R.string.nombre_incorrecto));
        }else if(correo.length() < 13 | correo.isEmpty()){
            email.setError(getString(R.string.email_incorrecto));
        }else if(!correo.contains("@")){
            email.setError(getString(R.string.email_incorrecto));
        }else if(mensaje.isEmpty()){
            message.setError(getString(R.string.msg_incorrecto));
        }else{
            Toast.makeText(this,getString(R.string.successfull_msg), Toast.LENGTH_SHORT).show();
        }
    }
}