package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final String MY_LOGIN = "";
    EditText passwordText, loginText;
    TextView passwordright;
    Button signButton;
    String password = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordText = findViewById(R.id.password_text);
        loginText = findViewById(R.id.login_text);
        passwordright = findViewById(R.id.password_right);
        signButton = findViewById(R.id.sign_button);
        signButton.setEnabled(false);
        loginText.requestFocus();
        loginText.setOnKeyListener(mKeyListener);
        passwordText.setOnKeyListener(mKeyListener);
        signButton.setOnClickListener(mClickListener);

    }
    protected void onStart() {
        super.onStart();
        String login = getIntent().getStringExtra(MY_LOGIN);
        loginText.setText(login);
    }
    private View.OnKeyListener mKeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            switch (view.getId()){
                case R.id.login_text:
                case R.id.password_text:
                    signButton.setEnabled(loginText.getText().length()>0 &&
                            passwordText.getText().length()>0);
                    break;
            }
            return false;
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.sign_button && !String.valueOf(passwordText.getText()).equals(password)){
                passwordright.setText("Пароль введён неверно");
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
            else{
                passwordright.setText("Вы вошли!");
            }
        }
    };

}