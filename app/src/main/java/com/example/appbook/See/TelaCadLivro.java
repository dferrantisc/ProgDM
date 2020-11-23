package com.example.appbook.See;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.appbook.Entidades.LivroEn;
import com.example.appbook.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;


public class TelaCadLivro extends AppCompatActivity {

    private EditText txtNomeL,EtxtAutorL, EtxtQuantPL;
    private CheckBox cbLido,cbLendo;
    private Button btnSalvarLivro;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_livro);

        initComponentesLivros();
        eventClickCadL();



        Button btnSalvarLivro = findViewById(R.id.btnSalvarLivro);

        btnSalvarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaCadLivro.this, TelaInicio.class));


            }
        });

    }

    private void eventClickCadL() {
        btnSalvarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String NomeL = txtNomeL.getText().toString().trim();
                String AutorL = EtxtAutorL.getText().toString().trim();
                String QPgL = EtxtQuantPL.getText().toString().trim();

                String Lido = cbLido.getText().toString().trim();
                String Lendo =cbLendo.getText().toString().trim();



                if (cbLido.isChecked()){
                    cbLido.setChecked(false);
                    return;
                }else if (cbLendo.isChecked())
                {
                    cbLendo.setChecked(true);
                    return;
                }


                newBooks(NomeL, AutorL, QPgL, Lido, Lendo);

                startActivity(new Intent(TelaCadLivro.this, TelaInicio.class));
            }
        });
    }

    private void newBooks(String nomeL, String autorL, String qPgL, String lido, String lendo) {

    }


    private void initComponentesLivros() {

        txtNomeL = (EditText) findViewById(R.id.txtNomeL);
        EtxtAutorL = (EditText) findViewById(R.id.EtxtAutorL);
        EtxtQuantPL = (EditText) findViewById(R.id.EtxtQuantPL);

        cbLido = (CheckBox) findViewById(R.id.cbLido);
        cbLendo = (CheckBox) findViewById(R.id.cbLendo);

        btnSalvarLivro = (Button) findViewById(R.id.btnSalvarLivro);

    }


}