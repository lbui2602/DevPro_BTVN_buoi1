package com.example.devpro_btvn_buoi1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity {
    Button btnRegister;
    EditText edtUsername2,edtPassword2,edtPasswordConfirm;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister=findViewById(R.id.btnRegister);
        edtUsername2=findViewById(R.id.edtTK2);
        edtPassword2=findViewById(R.id.edtMK2);
        edtPasswordConfirm=findViewById(R.id.edtMK2Confirm);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String username=edtUsername2.getText().toString();
                    String password=edtPassword2.getText().toString();
                    String passwordConfirm=edtPasswordConfirm.getText().toString();
                    if(username=="" || password==""|| passwordConfirm==""){
                        Toast.makeText(ActivityRegister.this, "Vui lòng không bỏ trống thông tin.", Toast.LENGTH_SHORT).show();
                    }
                    else if(username.length()<=7 || password.length()<=7 || passwordConfirm.length()<=7){
                        Toast.makeText(ActivityRegister.this, "Tên đăng nhập và mật khẩu cần ít nhất 8 kí tự!", Toast.LENGTH_SHORT).show();
                    }
                    else if(!password.equals(passwordConfirm) ){
                        Toast.makeText(ActivityRegister.this, "Mật khẩu xác nhận không đúng!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        User user = new User(username,password);
                        Intent intent1=new Intent();
                        intent1.putExtra("lbui", user);
                        setResult(78,intent1);
                        finish();
                    }
                }catch (Exception ex){

                }

            }
        });

    }
    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
    }
}