package com.example.rashabdran;

import static com.example.rashabdran.R.id.Home;
import static com.example.rashabdran.R.id.about_menu;
import static com.example.rashabdran.R.id.help;
import static com.example.rashabdran.R.id.sitting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private EditText etMail, etpassword;
        private Button btnLogin,btnSingup;
        private TextView tvSignup, tvWelcome;

        private final String valid_mail="admin";
        private final String valid_password="1";
        SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMail=findViewById(R.id.editTextTextEmailAddress);
        etpassword=findViewById(R.id.editTextTextPassword);
        btnLogin=findViewById(R.id.buttonLogin);
        btnSingup=findViewById(R.id.Register);
        preferences=getSharedPreferences("userinfo",0);
    }
    //this method loads the menu design into this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menuexample, menu);
       return true;
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //in case user chose about menu
        if(item.getItemId()== about_menu){
            Intent i=new Intent(this,AboutActivity.class);
            startActivity(i);

       }
        else if(item.getItemId()== sitting){
            Intent m=new Intent(this,listActivity.class);
            startActivity(m);

        }
        else if (item.getItemId()== Home)
        {
            Intent n= new Intent(this, HomeActivity.class);
            startActivity(n);
        }
        else if (item.getItemId()== help) {
            Intent r = new Intent(this, HelpActivity.class);
            startActivity(r);
        }
        return true ;
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Back Button Was pressed !");
        dialog.setMessage("Are you sure you want to Exit ");
        //in case the user chose no ,nothing happens
         dialog.setNegativeButton("No",null);
         //when the user clicks on the yes button the application closes
         dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 MainActivity.this.finish();
             }
         });
          dialog.setIcon(R.drawable.ic_baseline_block_24);
          AlertDialog alertDialog =dialog.create();
          alertDialog.show();
    }
    public void register (View view)
    {
        Intent i_register = new Intent(this,RegisterActivity.class);
        startActivity(i_register);

    }

    public void login(View view) {
        String input_mail = etMail.getText().toString();
        String input_password = etpassword.getText().toString();

        String registeredMail = preferences.getString("Username", "");
        String registeredPassword = preferences.getString("password", "");
        if (input_mail.equals(registeredMail) && input_password.equals(registeredPassword)) {
            Intent i_mail = new Intent(this, HomeActivity.class);
            startActivity(i_mail);


        } else {
            Toast.makeText(this, "Incorrect credentials!", Toast.LENGTH_SHORT).show();
        }
    }
}


