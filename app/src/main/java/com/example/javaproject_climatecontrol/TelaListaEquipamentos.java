package com.example.javaproject_climatecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaListaEquipamentos extends AppCompatActivity {

    DataBaseHelper helper;
    ArrayList<Equipamentos> equipamentoscadastrados;
    ListView listaequipamentos;
    Button novoequipamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_equipamentos);

        helper = new DataBaseHelper(this);

        equipamentoscadastrados = new ArrayList<Equipamentos>();

        listaequipamentos = (ListView) findViewById(R.id.listaEquipamentosCadastrados);
        novoequipamento = (Button) findViewById(R.id.btnNovoEquipamentoTelaLista);

        novoequipamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaListaEquipamentos.this, TelaCadastroEquipamentos.class));
            }
        });

        ArrayAdapter <String> listaequipamentosadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lerEquipamentos());

        listaequipamentos.setAdapter(listaequipamentosadapter);

        listaequipamentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TelaListaEquipamentos.this, TelaCadastroEquipamentos.class);
                intent.putExtra("equipamento_id", equipamentoscadastrados.get(i).getId());
                startActivity(intent);
            }
        });

    }

    private String[] lerEquipamentos(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id, marca, tipo, local from equipamentos", null);
        cursor.moveToFirst();
        String [] equipamentoslidos = new String[cursor.getCount()];
        for(int item = 0; item < cursor.getCount(); item++){
            equipamentoscadastrados.add(new Equipamentos(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            equipamentoslidos[item] = cursor.getString(1) + " - " +  cursor.getString(3);
            cursor.moveToNext();
        }
        cursor.close();

        return equipamentoslidos;
    }

}