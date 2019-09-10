package com.example.cgi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seConnecter(View v){
        EditText edit_id = findViewById(R.id.id_input);
        EditText edit_password = findViewById(R.id.password_input);
        String id = edit_id.getText().toString();
        String password = edit_password.getText().toString();
        if ("g".equals(id) && "p".equals(password)){
            Intent i = new Intent(this,MenuActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this,R.string.message_connect,Toast.LENGTH_LONG).show();
        }
    }
}
