package com.swufestu.work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View view) {
        Log.i(TAG,"onClick");
        String name="41810040";
        String pswd="123456";
        EditText username =(EditText) findViewById(R.id.username);
        EditText password =(EditText) findViewById(R.id.password);
        if(username.getText().toString().equals(name))
        {
            if(password.getText().toString().equals(pswd))
            {
                Bundle data =new Bundle();
                data.putString("username", username.getText().toString());
                Intent intent =new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtras(data);
                Toast.makeText(getApplicationContext(), "欢迎，"+username.getText().toString(), Toast.LENGTH_SHORT).show();
                startActivity(intent);

                overridePendingTransition(0,0);
            }
            else{
                Toast.makeText(getApplicationContext(), "用户名或密码错误！", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "用户名或密码错误！", Toast.LENGTH_SHORT).show();
        }
    }
}