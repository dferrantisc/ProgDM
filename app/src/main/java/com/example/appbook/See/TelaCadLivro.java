package com.example.appbook.See;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.appbook.Entidades.LivroEn;
import com.example.appbook.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;


public class TelaCadLivro extends AppCompatActivity {

    EditText txtNomeL;
    EditText EtxtAutorL;
    EditText EtxtQuantPL;
    CheckBox cbLido ;
    CheckBox cbLendo;

    FirebaseDatabase database;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_livro);


        FirebaseApp.initializeApp(TelaCadLivro.this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();


        Button btnSalvarLivro = findViewById(R.id.btnSalvarLivro);

        btnSalvarLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaCadLivro.this, TelaInicio.class));


            }
        });



            txtNomeL = (EditText) findViewById(R.id.txtNomeL);
            EtxtAutorL = (EditText) findViewById(R.id.EtxtAutorL);
            EtxtQuantPL = (EditText) findViewById(R.id.EtxtQuantPL);
            cbLido = (CheckBox) findViewById(R.id.cbLido);
            cbLendo = (CheckBox) findViewById(R.id.cbLendo);







    }



    public void SalvarL(View view) {

        LivroEn dl = new LivroEn();


            dl.setNomeL(txtNomeL.getText().toString());
            dl.setAutorL(EtxtAutorL.getText().toString());
            dl.setQuantidadePgsL(EtxtQuantPL.getText().toString());

            dl.setLido(cbLido.isChecked());
            dl.setLendo(cbLendo.isChecked());


            String valor= EtxtQuantPL.getText().toString();
            int finalValue= Integer.parseInt(valor);

           reference.child("Livro").setValue(dl);

           finish();


    }

}