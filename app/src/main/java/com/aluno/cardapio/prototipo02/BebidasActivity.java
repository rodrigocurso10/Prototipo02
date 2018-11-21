package com.aluno.cardapio.prototipo02;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class BebidasActivity extends AppCompatActivity {

    ListView mListView;
    DBHelper db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        mListView = findViewById(R.id.lista);
        db = new DBHelper(this);

    }
}
