package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.helpers.InputValidation;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = LoginActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout layoutUser;
    private TextInputLayout layoutPass;

    private TextInputEditText userName;
    private TextInputEditText userPass;

    private AppCompatButton loginBtn;

    private AppCompatTextView signUpBtn;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        layoutUser = (TextInputLayout) findViewById(R.id.layoutUser);
        layoutPass = (TextInputLayout) findViewById(R.id.layoutPass);

        userName = (TextInputEditText) findViewById(R.id.userName);
        userPass = (TextInputEditText) findViewById(R.id.userPass);

        loginBtn = (AppCompatButton) findViewById(R.id.loginBtn);

        signUpBtn = (AppCompatTextView) findViewById(R.id.signUpBtn);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        loginBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);

    }

    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn:
                verifyFromSQLite();
                break;
            case R.id.signUpBtn:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(userName, layoutUser, getString(R.string.error_message_email))) {

        }
        if (!inputValidation.isInputEditTextEmail(userName, layoutUser, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(userPass, layoutPass, getString(R.string.error_message_email))) {
            return;
        }

        if (databaseHelper.checkUser(userName.getText().toString().trim()
                , userPass.getText().toString().trim())) {


            Intent accountsIntent = new Intent(activity, UsersListActivity.class);
            accountsIntent.putExtra("EMAIL", userName.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);


        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        userName.setText(null);
        userPass.setText(null);
    }
}
