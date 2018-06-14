package com.example.george.pokeagenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUser = (EditText)findViewById(R.id.etUser);
    EditText etPassword = (EditText)findViewById(R.id.etPassword);
    SqliteHelper SHelper = new SqliteHelper(this);
    User testee = new User(null,"teste","senha");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void login(View view){
        String username = etUser.getText().toString();
        String password = etPassword.getText().toString();
        User currentUser = SHelper.Login(new User(null, username, password));
        if (currentUser != null) {
            Toast.makeText(this, "Logado com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,Tela2.class);
            startActivity(intent);
            finish();
        } else{
            Toast.makeText(this, "Falha no login", Toast.LENGTH_SHORT).show();
        }
    }
}
