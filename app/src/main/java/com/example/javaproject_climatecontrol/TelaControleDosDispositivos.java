package com.example.javaproject_climatecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaControleDosDispositivos extends AppCompatActivity {

    Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_controle_dos_dispositivos);

        voltar = (Button) findViewById(R.id.buttonVoltarTelaControleDisp);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaControleDosDispositivos.this, TelaDeSelecao.class));
            }
        });

    }
}