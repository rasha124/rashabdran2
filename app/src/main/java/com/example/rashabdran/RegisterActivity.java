package com.example.rashabdran;

import static com.example.rashabdran.R.layout.activity_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText etMail,etPassword;
    private Button btnRegister, btnCancel;
    private TextView tvWelcome;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_register);

        etMail= findViewById(R.id.editTextTextEmailAddress2);
        etPassword= findViewById(R.id.editTextTextPassword2);
        btnRegister= findViewById(R.id.buttonRegister);
        btnCancel= findViewById(R.id.buttonCancel);

        preferences = getSharedPreferences("Userinfo",'0');
    }
    public void register (View view)
    {
     String input_mail = etMail.getText().toString();
     String input_password= etPassword.getText().toString();
     if (input_mail.length()>0){
         //open preference file
         SharedPreferences.Editor editor = preferences.edit();
         //save key , value data
         editor.putString("Username",input_mail);
         editor.putString("password",input_password);

         editor.apply();
         Toast.makeText(this,"User ragistred !",Toast.LENGTH_LONG).show();
         Intent intent_main= new Intent(this, MainActivity.class);
         startActivity(intent_main);
     }else {
         Toast.makeText(this,"Empty Values , Please insert!", Toast.LENGTH_SHORT).show();
     }

    }
    public void cancel(View view){
        Intent intent_main = new Intent(this ,MainActivity.class);
        startActivity(intent_main);
    }
}