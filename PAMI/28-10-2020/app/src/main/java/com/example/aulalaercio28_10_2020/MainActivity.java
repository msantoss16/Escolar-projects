package com.example.aulalaercio28_10_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnEntrar;
    EditText txtEmailUsu, txtSenhaUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = findViewById(R.id.btEntrar);
        txtEmailUsu = findViewById(R.id.txtEmailUsu);
        txtSenhaUsu = findViewById(R.id.txtSenhaUsu);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Transformando as variáveis edittext em string

                String email = txtEmailUsu.getText().toString();
                String senha = txtSenhaUsu.getText().toString();
                if (email.equals("etecia") && senha.equals("etecia")) {
                    startActivity(new Intent(getApplicationContext(),activity_2.class));
                    //realiza o foco no objeto em tempo de execução.
                    txtEmailUsu.requestFocus();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Usuário ou senha inválidos!!!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}