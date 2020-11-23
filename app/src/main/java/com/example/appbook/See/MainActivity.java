package com.example.appbook.See;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appbook.Conexao;
import com.example.appbook.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity
{

    private EditText txtUser,txtPass;
    private TextView txtResetPass;
    private Button btnEntrar, btnCadUser;

    private FirebaseAuth auth;


       @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponentes();
        eventClick();

    }


    private void eventClick() {
           btnCadUser.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   startActivity(new Intent(MainActivity.this,TelaCadUser.class));


               }
           });

           btnEntrar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String Login = txtUser.getText().toString().trim();
                   String Senha = txtPass.getText().toString().trim();
                   Entrar(Login,Senha);

                   startActivity(new Intent(MainActivity.this,TelaInicio.class));


               }
           });

           txtResetPass.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

               }
           });
    }

    private void Entrar(String login, String senha) {
           auth.signInWithEmailAndPassword(login,senha)
                   .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful()){
                               startActivity(new Intent(MainActivity.this , TelaInicio.class));
                           }else{
                               Alert("Erro ao Entrar!");

                           }
                       }
                   });
    }


    private void Alert(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        }





    private void initComponentes(){

        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);
        txtResetPass = (TextView) findViewById(R.id.txtResetPass);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadUser = (Button) findViewById(R.id.btnCadUser);
    }


    @Override
    protected void onStart() {
        super.onStart();
        auth= Conexao.getFbAuth();

    }
}