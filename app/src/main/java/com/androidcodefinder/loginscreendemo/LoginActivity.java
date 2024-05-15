package com.androidcodefinder.loginscreendemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidcodefinder.loginscreendemo.model.User;

import com.androidcodefinder.loginscreendemo.repository.UserRepository;
import com.makeramen.roundedimageview.RoundedImageView;

public class LoginActivity extends AppCompatActivity {

    RoundedImageView roundedImageView;
    private Button btnA,btnB, btnC;
    private ImageView imgFb, imgGg, imgTt;
    private TextView tvLogo;
    private EditText editUsername, editPassword;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnA = (Button)findViewById(R.id.btnLogin);
        btnB=(Button)findViewById(R.id.btnSignup);
        btnC = (Button)findViewById(R.id.btnOnLogin);
        imgFb = (ImageView) findViewById(R.id.imageView);
        imgGg = (ImageView) findViewById(R.id.imageView2);
        imgTt = (ImageView) findViewById(R.id.imageView3);

        editUsername = (EditText)findViewById(R.id.txtUsername);
        editPassword = (EditText)findViewById(R.id.txtPassword);

       // userRepository = new UserRepository();

        Intent intent = getIntent();
        if (null != intent){
            String strUsername = intent.getStringExtra("strUsername");
            String strPassword = intent.getStringExtra("strPassword");
            if (!strUsername.equals("") && !strPassword.equals(""))
                loginUser(strUsername, strPassword);
        }

//        Intent i = new Intent(Intent.ACTION_VIEW);
//        i.setData(Uri.parse("https://google.com"));
//        startActivity(i);
//
//
//        Intent it = new Intent(Intent.ACTION_DIAL);
//        it.setData(Uri.parse("tel:0123456789"));
//        startActivity(i);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //handle onClick event on this button.
                Log.d("LoginScreen", "btnA - Button Login clicked!");
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LoginScreen", "btnB - Button Signup clicked!");
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });


        btnC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("LoginScreen", "btnC - OnLogin Login clicked!");

                String strUsername = editUsername.getText().toString();
                String strPassword = editPassword.getText().toString();
                loginUser(strUsername, strPassword);

            }
        });
        Log.d(getApplication().getPackageName(), "Main Activity - Login Screen");

    }

    public void onImgGGClick(View view) {


        Log.d(this.getLocalClassName(),"Gooogle ImageView clicked!");
    }

    public void loginUser(String strUsername, String strPassword){
        User user = new User(strUsername, strPassword);
        userRepository = new UserRepository();
        if (null != userRepository && userRepository.checkExistedUser(user)) {
            Toast.makeText(LoginActivity.this, "OnLogin success!!!!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(LoginActivity.this, "OnLogin failed!!!!", Toast.LENGTH_LONG).show();
        }
    }
}
