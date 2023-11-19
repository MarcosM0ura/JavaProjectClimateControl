package com.example.javaproject_climatecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    EditText senha;
    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.editTextUsuarioTelaLogin);
        senha = (EditText) findViewById(R.id.editTextSenhaTelaLogin);
        entrar = (Button) findViewById(R.id.buttonEntrarTelaLoginBtn);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("admin".equals(usuario.getText().toString()) && "1234".equals(senha.getText().toString()))
                {
                    startActivity(new Intent(MainActivity.this, TelaDeSelecao.class));

                } else {
                    Toast falhaAutencacao = Toast.makeText(MainActivity.this,getResources().getString(R.string.acivity_main_falha_autenticacao), Toast.LENGTH_SHORT);
                    falhaAutencacao.show();
                }
            }
        });

    }


    @Override
    protected void onStart(){
        super.onStart();
        usuario.setText("");
        senha.setText("");
    }

}