package com.aluno.cardapio.prototipo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProdutoActivity extends AppCompatActivity {

    EditText et_pro_cod, et_pro_desc, et_pro_val, et_pro_tipo;
    Button bt_pro_cad;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        db=new DBHelper (this);

        et_pro_cod = (EditText)findViewById(R.id.et_pro_cod);
        et_pro_desc = (EditText)findViewById(R.id.et_pro_desc);
        et_pro_val = (EditText)findViewById(R.id.et_pro_val);
        et_pro_tipo = (EditText) findViewById(R.id.et_pro_tipo);

        bt_pro_cad = (Button) findViewById(R.id.bt_pro_cad);

        bt_pro_cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String codigo = et_pro_cod.getText().toString();
                String desc = et_pro_desc.getText().toString();
                String valor = et_pro_val.getText().toString();
                String tipo = et_pro_tipo.getText().toString();

                if (codigo.equals("")) {
                    Toast.makeText(ProdutoActivity.this, "Codigo não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                } else if (desc.equals("")) {
                    Toast.makeText(ProdutoActivity.this, "Descrição não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                } else if (valor.equals("")) {
                    Toast.makeText(ProdutoActivity.this, "Valor não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                } else if (tipo.equals("")){
                    Toast.makeText(ProdutoActivity.this, "Tipo de produto não inserido", Toast.LENGTH_SHORT).show();
                }
//                else if(!tipo.equals("b") || !tipo.equals("C")){
//                    Toast.makeText(ProdutoActivity.this, "Tipo de produto invalido", Toast.LENGTH_SHORT).show();
//                }
                else if(tipo.equals("B")) {
                        //tudo ok
                        long res = db.CadProdBebida(codigo, desc, valor);
                        if (res > 0) {
                            Toast.makeText(ProdutoActivity.this, "Cadastrado Bebidas", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ProdutoActivity.this, "Cadastro invalido B, tente novamente", Toast.LENGTH_SHORT).show();
                        }
                }
                else if(tipo.equals("C")) {
                        //tudo ok
                        long res = db.CadProdComida(codigo, desc, valor);
                        if (res > 0) {
                            Toast.makeText(ProdutoActivity.this, "Cadastrado Comida", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ProdutoActivity.this, "Cadastro invalido C, tente novamente", Toast.LENGTH_SHORT).show();
                        }
                }
                else {
                    Toast.makeText(ProdutoActivity.this, "Cadastrado Invalido, tente novamente", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
