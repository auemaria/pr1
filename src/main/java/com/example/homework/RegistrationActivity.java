package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    EditText registrpasswordText, registrloginText;
    Button registrButton;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        registrpasswordText = findViewById(R.id.password_registr_text);
        registrloginText = findViewById(R.id.login_registr_text);
        registrButton = findViewById(R.id.registration_button);
        registrloginText.requestFocus();
        registrButton.setEnabled(false);


        registrloginText.setOnKeyListener(mKeyListener);
        registrpasswordText.setOnKeyListener(mKeyListener);
        registrButton.setOnClickListener(mClickListener);
    }
    private View.OnKeyListener mKeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            switch (view.getId()){
                case R.id.login_registr_text:
                case R.id.password_registr_text:
                    registrButton.setEnabled(registrloginText.getText().length()>0 &&
                            registrpasswordText.getText().length()>0);
                    break;
            }
            return false;
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.registration_button){
                String login = String.valueOf(registrloginText.getText());
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                intent.putExtra(MainActivity.MY_LOGIN, login);
                startActivity(intent);
            }
        }
    };

    }
