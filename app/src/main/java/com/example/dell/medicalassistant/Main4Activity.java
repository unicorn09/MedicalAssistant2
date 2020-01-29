package com.example.dell.medicalassistant;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener{
    private EditText email1;
    private EditText password1;
    private EditText password2;
    private Button createaccount;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);
        firebaseAuth=FirebaseAuth.getInstance();
        email1=(EditText)findViewById(R.id.email1);
        password1=(EditText)findViewById(R.id.password1);
        password2=(EditText)findViewById(R.id.password2);
        createaccount=(Button)findViewById(R.id.createaccount);
        createaccount.setOnClickListener(this);

    }
    private void registerUser(){
        String email2= email1.getText().toString().trim();
        String password3= password1.getText().toString().trim();
        String password4= password2.getText().toString().trim();
        if(password3.equals(password4))
        {
            firebaseAuth.createUserWithEmailAndPassword(email2,password3).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful())
               {
                   Toast.makeText(Main4Activity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                   Toast.makeText(Main4Activity.this, "Login to Proceed", Toast.LENGTH_SHORT).show();

                   firebaseAuth.signOut();
                   finish();
                   Intent j=new Intent(Main4Activity.this,Main3Activity.class);
                   startActivity(j);
               }
               else{
                   finish();
                   Toast.makeText(Main4Activity.this, "Error Occurred,Please Try Again  ", Toast.LENGTH_SHORT).show();
                   Intent k=new Intent(Main4Activity.this,Main4Activity.class);
                   startActivity(k);

               }
                }
            });

        }
        else
        {
            Toast.makeText(this, "Password Not Matched", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Main4Activity.this,Main4Activity.class);
            startActivity(i);
        }

    }
    @Override
    public void onClick(View v) {
        if(v==createaccount){
            registerUser();
        }

    }

}

