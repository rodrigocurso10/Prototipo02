package com.aluno.cardapio.prototipo02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdministradorActivity extends AppCompatActivity {

    Button bt_cad_cliente, bt_cad_produto, bt_del_cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

        bt_cad_cliente = findViewById(R.id.bt_cad_cliente);
        bt_cad_cliente.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(AdministradorActivity.this, RegistrarActivity.class));
            }
        });

        bt_cad_produto = findViewById(R.id.bt_cad_produto);
        bt_cad_produto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startActivity(new Intent(AdministradorActivity.this, ProdutoActivity.class));
            }
        });

        bt_del_cliente = findViewById(R.id.bt_del_cliente);
        bt_del_cliente.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startActivity(new Intent(AdministradorActivity.this, DeletarActivity.class));
            }
        });

    }
}
