package com.aluno.cardapio.prototipo02;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class BebidasActivity extends AppCompatActivity {

    ListView mListView;
    DBHelper db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        mListView = findViewById(R.id.lista);
        db = new DBHelper(this);

        SQLiteDatabase banco = db.getReadableDatabase(); // instancia BD em modo de leitura

        // Campos a serem lido do BD
        String[] campos = {
                "username"
        };

        // Cursor contém o resultado da consulta
        Cursor cursor = banco.query("Utilizador",campos,null,null,null,null,null);

        // Monta um ArrayList com os dados da consulta
        ArrayList<String> nome = new ArrayList<>();
        while (cursor.moveToNext()) { // enquanto houver dados para serem lidos, faça
//            adiciona no arraylist o dados lido do banco
            String username = cursor.getString(cursor.getColumnIndex("username"));
            nome.add(username);
        }

        // Criar o adapter para listar os dados
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.addAll(nome);

        // associa o Adapter a ListView
        mListView.setAdapter(adapter);

    }
}
