package com.example.javaproject_climatecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaCadastroEquipamentos extends AppCompatActivity {

    DataBaseHelper helper;

    Spinner marca;
    Spinner tipo;
    EditText local;
    Button salvar;
    Button excluir;
    String equipamento_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_equipamentos);

        equipamento_id = getIntent().getStringExtra("equipamento_id");

        marca = findViewById(R.id.spinnerMarcaTelaCadastroEquip);
        tipo = findViewById(R.id.spinnerTipoTelaCadastroEquip);
        local = findViewById(R.id.editTextLocalTelaCadastroEquip);
        salvar = findViewById(R.id.buttonSalvarTelaCadastroEquip);
        excluir = findViewById(R.id.buttonExcluirTelaCadastroEquip);
        helper = new DataBaseHelper(this);

        if (equipamento_id != null) {
            prepararEdicao();
        } else {
            local.setText("");
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarEquipamento(view);
            }
        });

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excluirEquipamento(view);
            }
        });

    }

    public void prepararEdicao() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT marca, tipo, local from equipamentos WHERE _id = ?", new String[]{equipamento_id});
        cursor.moveToFirst();
        local.setText(cursor.getString(2));
        String[] tipos = getResources().getStringArray(R.array.activity_tela_cadastro_equipamento_lista_tipo);
        for (int item = 0; item < tipos.length; item++) {
            if (tipos[item].equals(cursor.getString(0))) {
                tipo.setSelection(item);
            }
        }
        String[] marcas = getResources().getStringArray(R.array.activity_tela_cadastro_equipamento_lista_marca);
        for (int item = 0; item < marcas.length; item++) {
            if (marcas[item].equals(cursor.getString(1))) {
                marca.setSelection(item);
            }
        }
    }

    public void salvarEquipamento(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        if (local.getText().length() > 0) {
            valores.put("marca", marca.getSelectedItem().toString());
            valores.put("tipo", tipo.getSelectedItem().toString());
            valores.put("local", local.getText().toString());

            long resultado;
            if (equipamento_id == null) {
                resultado = db.insert("equipamentos", null, valores);
            } else {
                resultado = db.update("equipamentos", valores, "_id = ?", new String[]{equipamento_id});
            }

            if (resultado != 1) {
                Toast.makeText(this, getString(R.string.activity_main_salvo_sucesso), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(TelaCadastroEquipamentos.this, TelaListaEquipamentos.class));
            } else {
                Toast.makeText(this, getString(R.string.activitu_main_erro_salvar), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, getString(R.string.activity_main_campo_vazios), Toast.LENGTH_SHORT).show();
        }

    }

    public void excluirEquipamento(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();
        long resultado = db.delete("equipamentos", "_id = ?", new String[]{equipamento_id});
        if (resultado != -1) {
            Toast.makeText(this, getString(R.string.activity_main_tela_cadastro_excluir_equipamento), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(TelaCadastroEquipamentos.this, TelaListaEquipamentos.class));
        } else {
            Toast.makeText(this, getString(R.string.activity_main_tela_cadastro_falha_excluir_equipamento), Toast.LENGTH_SHORT).show();
        }

    }


}