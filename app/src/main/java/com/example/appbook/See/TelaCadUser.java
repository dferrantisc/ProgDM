package com.example.appbook.See;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbook.Conexao;
import com.example.appbook.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.security.auth.login.LoginException;

public class TelaCadUser extends AppCompatActivity {

    private EditText txtCadUNome,txtCadULogin,txtCadUPass;
    private Button btnSalvarCad, btnVoltar;
    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_user);

        initComponentesUser();
        eventClickCadU();

    }

    private void eventClickCadU() {
        btnSalvarCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = txtCadUNome.getText().toString().trim();

                String login = txtCadULogin.getText().toString().trim();
                String senha = txtCadUPass.getText().toString().trim();

                newUser( login, senha);


            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }

    private void newUser( String login, String senha)
    {
           Auth.createUserWithEmailAndPassword(login,senha)
                .addOnCompleteListener(TelaCadUser.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Alert("Usuário Foi Cadastrado com SUCESSO! OBG.");
                            startActivity(new Intent(TelaCadUser.this, MainActivity.class));
                            finish();

                        }else{
                            Alert("ERRO No Cadastro do Usuário!");
                        }
                    }
                });
    }

    private void Alert(String msg){
        Toast.makeText(TelaCadUser.this,msg,Toast.LENGTH_SHORT).show();
    }

    private void initComponentesUser() {
        txtCadUNome = (EditText) findViewById(R.id.txtCadUNome);
        txtCadULogin = (EditText) findViewById(R.id.txtCadULogin);
        txtCadUPass = (EditText) findViewById(R.id.txtCadUPass);

        btnSalvarCad = (Button) findViewById(R.id.btnSalvarCad);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Auth = Conexao.getFbAuth();
    }
}