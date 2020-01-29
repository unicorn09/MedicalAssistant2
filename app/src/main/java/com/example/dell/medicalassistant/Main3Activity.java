package com.example.dell.medicalassistant;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    private Button login;
    private EditText email;
    private EditText password;
    private Button signup123;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null){
            finish();

            Intent i = new Intent(Main3Activity.this, Main5Activity.class);
            startActivity(i);
        }
        email = (EditText) findViewById(R.id.email);
        password= (EditText) findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);
    }
    private void userLogin()
    {
        String emailis=email.getText().toString().trim();
        String passwordis=password.getText().toString().trim();
        firebaseAuth.signInWithEmailAndPassword(emailis,passwordis)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            finish();
                            Intent i = new Intent(Main3Activity.this, Main5Activity.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(Main3Activity.this, "Invalid Email Id or Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    @Override
    public void onClick(View v) {
        if(v==login)
            userLogin();
    }
    public void onButtonClick7 (View v)
    {
        if(v.getId()==R.id.signup123)
        {
            Intent l =new Intent(Main3Activity.this,Main4Activity.class);
            startActivity(l);
        }
    }
  /*  public void onButtonClick8 (View v)
    {
        if(v.getId()==R.id.login1)
        {
            Intent l =new Intent(Main3Activity.this,Main8Activity.class);
            startActivity(l);
        }
    }*/
}