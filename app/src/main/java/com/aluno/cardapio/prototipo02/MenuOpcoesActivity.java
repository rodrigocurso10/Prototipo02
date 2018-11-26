package com.aluno.cardapio.prototipo02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOpcoesActivity extends AppCompatActivity {

    Button bt_bebidas, bt_comidas, bt_teste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opcoes);

        bt_bebidas=(Button) findViewById(R.id.bt_bebidas);
        bt_comidas=(Button) findViewById(R.id.bt_comidas);
        bt_teste=(Button) findViewById(R.id.bt_teste);

        bt_bebidas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuOpcoesActivity.this, BebidasActivity.class);
                startActivity(i);
            }
        });

        bt_comidas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuOpcoesActivity.this, ComidasActivity.class);
                startActivity(i);
            }
        });

        bt_teste.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuOpcoesActivity.this, TesteActivity.class);
                startActivity(i);
            }
        });
    }
}
