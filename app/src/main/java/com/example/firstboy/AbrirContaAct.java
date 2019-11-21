package com.example.firstboy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbrirContaAct extends AppCompatActivity {

    private TextView abrirContaHeadText;
    private EditText phoneNumber;
    private TextWatcher txt;

    boolean change = false;
    private List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abrir_conta);
        list = Collections.synchronizedList(new ArrayList());


        phoneNumber = findViewById(R.id.abrirContaInput);
        phoneNumber.addTextChangedListener(txt = MaskEditUtil.mask(phoneNumber, "###.###.###-##"));

        abrirContaHeadText = findViewById(R.id.AbrirContaHeadText);
        phoneNumber.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER) && phoneNumber.getText().length() > 10) {
                    if(list.isEmpty()) {
                        abrirContaHeadText.setText("Insira o seu nome completo:");
                        phoneNumber.removeTextChangedListener(txt);
                        list.add(phoneNumber.getText());
                        phoneNumber.setText("");
                    } else if(list.size() == 1){
                        abrirContaHeadText.setText("Insira o seu nome completo:");
                        phoneNumber.removeTextChangedListener(txt);
                        list.add(phoneNumber.getText());
                        phoneNumber.setText("");
                    }
                    return true;
                }
                return false;
            }
        });
    }
}
