package com.aluno.cardapio.prototipo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletarActivity extends AppCompatActivity {

    EditText et_deletar;
    Button bt_deletar;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar);

        db=new DBHelper (this);

        et_deletar = (EditText)findViewById(R.id.et_deletar);

        bt_deletar = (Button) findViewById(R.id.bt_deletar);

        bt_deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_deletar.getText().toString();

                if (username.equals("")){
                    Toast.makeText(DeletarActivity.this, "Usuario não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else {
                    //tudo ok
                    int res = db.deleteItem(username);

                    if (res != -1){
                        //Toast.makeText(LoginActivity.this, "Login ok", Toast.LENGTH_SHORT).show();
                        Toast.makeText(DeletarActivity.this, "Deletado com sucesso", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(DeletarActivity.this, "Erro, tente novamente", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
