package com.i044114_i012114.proyectofinalandroid;

import android.content.Intent;
import android.support.transition.Transition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.i044114_i012114.proyectofinalandroid.Helpers.SqliteHelper;
import com.i044114_i012114.proyectofinalandroid.Views.LoginUserActivity;
import com.i044114_i012114.proyectofinalandroid.Views.RegisterUserActivity;

public class LoginActivity extends AppCompatActivity {

    SqliteHelper sqliteHelper;

    private Transition transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void goToResgister (View view){
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);

    }

    public void goToLogin (View view){

        Intent intent = new Intent(this, LoginUserActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in, R.anim.left_on);
    }


}
