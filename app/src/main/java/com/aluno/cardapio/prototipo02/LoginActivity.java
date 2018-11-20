package com.aluno.cardapio.prototipo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button bt_login;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);

        db = new DBHelper(this);

        bt_login = (Button)findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if (username.equals("")){
                    Toast.makeText(LoginActivity.this, "Usuario não inserido, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else if (password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Senha não inserida, tente novamente", Toast.LENGTH_SHORT).show();
                }
                else {
                    //tudo ok
                    String res = db.ValidarLogin(username,password);

                    if (res.equals("OK")){
                        Toast.makeText(LoginActivity.this, "Login ok", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Login invalido, tente novamente", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
