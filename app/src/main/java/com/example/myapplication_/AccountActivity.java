package com.example.myapplication_;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileOutputStream;

public class AccountActivity extends AppCompatActivity {
    private EditText newUsername, newPassword;
    private Button acceptButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        newUsername = findViewById(R.id.newUsername);
        newPassword = findViewById(R.id.newPassword);
        acceptButton = findViewById(R.id.acceptButton);
        cancelButton = findViewById(R.id.cancelButton);

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = newUsername.getText().toString();
                String pass = newPassword.getText().toString();
                saveAccount(user, pass);
                Toast.makeText(AccountActivity.this, "Cuenta creada", Toast.LENGTH_LONG).show();
                finish(); // Regresa a LoginActivity
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Regresa a LoginActivity
            }
        });
    }

    private void saveAccount(String user, String pass) {
        try {
            FileOutputStream fos = openFileOutput("cuentas.txt", MODE_APPEND);
            fos.write((user + "," + pass + "\n").getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
