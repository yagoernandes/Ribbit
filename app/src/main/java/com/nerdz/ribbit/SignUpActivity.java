package com.nerdz.ribbit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {
    //ButterKnife Setting and instantiating elements of UI
    @Bind(R.id.usernameField) EditText mUsernameField;
    @Bind(R.id.passwordField)EditText mPasswordField;
    //Getting the intent who calls the class
    protected Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        mIntent = getIntent();
        //Setting parameters received
        mUsernameField.setText(mIntent.getStringExtra("username"));
        mPasswordField.setText(mIntent.getStringExtra("password"));
    }

    @OnClick(R.id.alreadyLoginLabel) void alreadyLogin() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        intent.putExtra("username", mUsernameField.getText());
        intent.putExtra("password", mPasswordField.getText());
        startActivity(intent);
    }
}
