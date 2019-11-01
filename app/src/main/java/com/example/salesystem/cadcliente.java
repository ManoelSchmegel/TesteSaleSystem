package com.example.salesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadcliente extends AppCompatActivity {
    EditText ednome,edcpf,edtelefone,edcidade;
    Button btnsalvar,btncancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadcliente);

        ednome =  findViewById(R.id.novonome);
        edcpf = findViewById(R.id.novocpf);
        edtelefone = findViewById(R.id.novotelefone);
        edcidade = findViewById(R.id.novocidade);

        btnsalvar = findViewById(R.id.botaosalvar);
        btncancelar = findViewById(R.id.botaocancelar);

//cancelar direciona pro Main
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cadcliente.this,Main.class);
                startActivity(i);
            }
        });

//salvar informacoes
        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insercao();
            }
        });
    }

    public void insercao(){
        try{
            String nome = ednome.getText().toString();
            String cpf = edcpf.getText().toString();
            String telefone = edtelefone.getText().toString();
            String cidade = edcidade.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase( "clientes", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS clientes(id INTEGER PRIMARY KEY AUTOINCREMENT,nomecliente VARCHAR,cpfcliente INTEGER,telefone INTEGER,cidade VARCHAR)");
            String sql = "insert into clientes(nomecliente,cpfcliente,telefone,cidade)values(?,?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,nome);
            statement.bindString(1,cpf);
            statement.bindString(1,telefone);
            statement.bindString(1,cidade);
            Toast.makeText(this, "Cliente cadastrado com sucesso!",Toast.LENGTH_SHORT).show();
            ednome.setText("");
            edcpf.setText("");
            edtelefone.setText("");
            edcidade.setText("");
            ednome.requestFocus();
        }catch (Exception ex){
            Toast.makeText(this, "Problema em cadastrar o cliente. Contate o Suporte!",Toast.LENGTH_SHORT).show();
        }
    }
}
