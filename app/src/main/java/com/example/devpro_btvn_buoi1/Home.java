package com.example.devpro_btvn_buoi1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView tvChao;
    Button btnLogout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvChao=findViewById(R.id.tvChaoMung);
        btnLogout=findViewById(R.id.btnLogout);
//        Intent intent=getIntent();
//        String str=intent.getStringExtra("tk");
        String str=""+PrefManager.getString(Home.this,"username");
        str+="-"+PrefManager.getString(Home.this,"password");
        tvChao.setText("Hello "+str);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrefManager.removeKey(Home.this,"username");
                PrefManager.removeKey(Home.this,"password");
                Intent intent=new Intent(Home.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}