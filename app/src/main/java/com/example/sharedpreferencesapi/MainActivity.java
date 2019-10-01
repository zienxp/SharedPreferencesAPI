package com.example.sharedpreferencesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SheredPreferenceConfig preferenceConfig;
    private EditText UserName,UserPasword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceConfig = new SheredPreferenceConfig(getApplicationContext());

        UserName = findViewById(R.id.user_name);
        UserPasword = findViewById(R.id.user_password);

        if(preferenceConfig.readLoginStatus()){
            startActivity(new Intent(this,SuccessActivity.class));
            finish();
        }
    }

    public void loginUser(View view) {
        String userName = UserName.getText().toString();
        String userPassword = UserPasword.getText().toString();


        if (userName.equals(getResources().getString(R.string.user_name))&& userPassword.equals(getResources().getString(R.string.user_password))){
           startActivity(new Intent(this,SuccessActivity.class));
           preferenceConfig.writeLoginStatus(true);
           finish();
        }

        else {
            Toast.makeText(this,"Login Faild....Try Again...",Toast.LENGTH_SHORT).show();
            UserName.setText("");
            UserPasword.setText("");
        }

    }
}
