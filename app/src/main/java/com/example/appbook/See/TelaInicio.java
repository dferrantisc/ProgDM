package com.example.appbook.See;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appbook.Conexao;
import com.example.appbook.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TelaInicio extends AppCompatActivity {

    private Button btnCadL, btnSair;
    private EditText txtLogin, txtID;

    private FirebaseAuth auth;
    private FirebaseUser fbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);

        initComponentesTIni();
        eventClickTIni();
    }

    private void eventClickTIni() {
        btnCadL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaInicio.this, TelaCadLivro.class));

            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexao.logoutfb();
                finish();

            }
        });

    }

    private void initComponentesTIni() {

        btnCadL = (Button) findViewById(R.id.btnCadL);
        btnSair = (Button) findViewById(R.id.btnSair);

        txtLogin = (EditText) findViewById(R.id.txtLoginTIni);
        txtID = (EditText) findViewById(R.id.txtID);
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFbAuth();
        fbUser = Conexao.getFbUser();
        verifcUser();
    }

    private void verifcUser() {
        if (fbUser == null){
            finish();
        }else {
            txtLogin.setText("Login"+fbUser.getEmail());
            txtID.setText("ID:" +fbUser.getUid());
        }
    }
}