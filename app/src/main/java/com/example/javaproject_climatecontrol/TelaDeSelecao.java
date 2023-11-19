package com.example.javaproject_climatecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaDeSelecao extends AppCompatActivity {

    Button equipamentos;
    Button novoDispositivo;
    Button telaControle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_selecao);

        equipamentos = (Button) findViewById(R.id.btnListaEquipTelaSelecao);
        novoDispositivo = (Button) findViewById(R.id.buttonNovoDispoTelaSelecao);
        telaControle = (Button) findViewById(R.id.buttonTelaSelecaoTelaControle);

        equipamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaDeSelecao.this, TelaListaEquipamentos.class));
            }
        });

        novoDispositivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaDeSelecao.this, TelaCadastroEquipamentos.class));
            }
        });

        telaControle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaDeSelecao.this, TelaControleDosDispositivos.class));
            }
        });

    }
}