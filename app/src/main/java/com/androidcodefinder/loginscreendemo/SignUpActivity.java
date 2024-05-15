package com.androidcodefinder.loginscreendemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidcodefinder.loginscreendemo.model.User;
import com.androidcodefinder.loginscreendemo.repository.UserRepository;

public class SignUpActivity extends AppCompatActivity {

    private Button btnLogin,btnSignup, btnOnSignup;
    private UserRepository userRepository;

    private EditText edUsername;
    private EditText edPassword;
    private EditText edCPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnSignup=(Button)findViewById(R.id.btnSignup);
        btnOnSignup = (Button)findViewById(R.id.btnOnSignup);

        edUsername = (EditText) findViewById(R.id.txtUsername);
        edPassword = (EditText) findViewById(R.id.txtPassword);
        edCPassword = (EditText) findViewById(R.id.txtCPassword) ;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                addUser();
            }
        });
        btnOnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
    }
    public void addUser(){
        userRepository  = new UserRepository();
        String sUsername = edUsername.getText().toString();
        String sPassword = edPassword.getText().toString();
        String scPassword = edCPassword.getText().toString();

       //validate data....?
        if (!sPassword.equals(scPassword)){
            Toast.makeText(this, "Password & Confirm password is not the same", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User(sUsername, sPassword);
        userRepository.addUser(user);

        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        intent.putExtra("strUsername", sUsername);
        intent.putExtra("strPassword", sPassword);

        startActivity(intent);

    }
}
