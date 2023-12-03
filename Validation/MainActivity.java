package com.example.internalexm;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSign = (Button) findViewById(R.id.signBtn);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean status = true;
                EditText user =  findViewById(R.id.username);
                EditText email = findViewById(R.id.EmailAddress);
                EditText pass = findViewById(R.id.Password);
                EditText copas = findViewById(R.id.ConPassword);
                EditText no = findViewById(R.id.phoneno);
                CheckBox cb = findViewById(R.id.checkBox);

                String username = user.getText().toString();
                String emailString = email.getText().toString();
                String password = pass.getText().toString();
                String coPassword = copas.getText().toString();
                String numString  = no.getText().toString();
                boolean isChecked = cb.isChecked();
                TextView error = findViewById(R.id.error);
                TextView eremail = findViewById(R.id.textView2);
                TextView erpass = findViewById(R.id.textView3);
                TextView erno = findViewById(R.id.textView4);
                TextView ercb = findViewById(R.id.textView5);

                if(username.isEmpty() || username.matches(".*\\d.*")){
                    error.setText("Enter your usernam not include numbers");
                    status = false;
                }
                if (emailString.isEmpty() || ( ! emailString.contains("@") && ! emailString.contains("."))){
                    eremail.setText("Enter your valid email");
                    status= false;
                }
                String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).*$";
                if (password.length()<6 || (!password.matches(regex) || !password.equals(coPassword)  ) ){
                    erpass.setText("Enter your valid password");
                    status = false;
                }
                if (numString.length() != 10){
                    erno.setText("Enter your valid number");
                    status = false;
                }
                if(isChecked == false){
                    ercb.setText("Please agree the conditions");
                    status = false;
                }

                if(status == true){
                    Intent i = new Intent(MainActivity.this,LoginMain.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}