package com.example.appbook.See;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appbook.R;

public class TelaCadUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cad_user);

        Button btnSalvarCad = findViewById(R.id.btnSalvarCad);

        btnSalvarCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaCadUser.this, MainActivity.class));
            }
        });


    }
}