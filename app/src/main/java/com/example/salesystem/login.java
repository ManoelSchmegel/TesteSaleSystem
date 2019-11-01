package com.example.salesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText edcpf, edsenha;
    Button btnacesso, btncancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edcpf = findViewById(R.id.cpf);
        edsenha =  findViewById(R.id.senha);
        btnacesso = findViewById(R.id.botaoacessar);
        btncancelar = findViewById(R.id.botaocancelar);

        btnacesso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void login(){
        String username =  edcpf.getText().toString();
        String password = edsenha.getText().toString();

        if(username.equals("")|| password.equals("")) {
            Toast.makeText(this, "Por favor, verifique as informacoes digitadas", Toast.LENGTH_SHORT).show();
        }else if(username.equals("02129762069") && password.equals("12345")) {

            Intent i = new Intent(login.this,Main.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Usuario ou Senha incorretos", Toast.LENGTH_SHORT).show();

        }
    }

}
