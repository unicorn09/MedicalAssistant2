package com.example.dell.medicalassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void onButtonClick2 (View v)
    {
        if(v.getId()==R.id.button2)
        {
            Intent q =new Intent(Main2Activity.this,Main3Activity.class);
            startActivity(q);
        }
    }
    public void onButtonClick3 (View v)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
