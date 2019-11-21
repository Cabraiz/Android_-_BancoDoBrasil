package com.example.firstboy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class NovoAct extends AppCompatActivity {

    private ImageButton btnBack;

    private Button btnContaPessoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        btnBack = findViewById(R.id.btnBackMenu);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NovoAct.this, MainAct.class);
                startActivity(i);
            }
        });

        btnContaPessoal = findViewById(R.id.btnContaPessoal);

        btnContaPessoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NovoAct.this, ContaAct.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            }
        });
    }
}
