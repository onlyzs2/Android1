package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tilEmail, tilSenha;

    TextInputEditText edtEmail, edtSenha;

    Button btnLogin;

    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tilEmail = findViewById(R.id.tilEmail);
        tilSenha = findViewById(R.id.tilSenha);
        edtSenha = findViewById(R.id.edtSenha);
        edtEmail = findViewById(R.id.edtEmail);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String senha = edtSenha.getText().toString().trim();

                tilEmail.setError(null);
                tilSenha.setError(null);

                if (email.isEmpty()){
                    tilEmail.setError("Informe o e-mail");
                    return;
                } else if (senha.isEmpty()) {
                    tilSenha.setError("Informe a senha");
                    return;
                }
                Toast.makeText(MainActivity.this, "login Efetuado", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
