package com.androidtutorialshub.loginregister.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.helpers.InputValidation;
import com.androidtutorialshub.loginregister.model.User;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

/**
 * Created by lalit on 8/27/2016.
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout layoutSName;
    private TextInputLayout layoutSUser;
    private TextInputLayout layoutSPass;
    private TextInputLayout layoutSConPass;

    private TextInputEditText signName;
    private TextInputEditText signUser;
    private TextInputEditText signPass;
    private TextInputEditText signConPass;

    private AppCompatButton signUpBtn2;
    private AppCompatTextView loginPage;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

        layoutSName = (TextInputLayout) findViewById(R.id.layoutSName);
        layoutSUser = (TextInputLayout) findViewById(R.id.layoutSUser);
        layoutSPass = (TextInputLayout) findViewById(R.id.layoutSPass);
        layoutSConPass = (TextInputLayout) findViewById(R.id.layoutSConPass);

        signName = (TextInputEditText) findViewById(R.id.signName);
        signUser = (TextInputEditText) findViewById(R.id.signUser);
        signPass = (TextInputEditText) findViewById(R.id.signPass);
        signConPass = (TextInputEditText) findViewById(R.id.signConPass);

        signUpBtn2 = (AppCompatButton) findViewById(R.id.signUpBtn2);

        loginPage = (AppCompatTextView) findViewById(R.id.loginPage);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        signUpBtn2.setOnClickListener(this);
        loginPage.setOnClickListener(this);

    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

    }


    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.signUpBtn2:
                postDataToSQLite();
                break;

            case R.id.loginPage:
                finish();
                break;
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(signName, layoutSName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(signUser, layoutSUser, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(signUser, layoutSUser, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(signPass, layoutSPass, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(signPass, signConPass,
                layoutSConPass, getString(R.string.error_password_match))) {
            return;
        }

        if (!databaseHelper.checkUser(signUser.getText().toString().trim())) {

            user.setName(signName.getText().toString().trim());
            user.setEmail(signUser.getText().toString().trim());
            user.setPassword(signPass.getText().toString().trim());

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }


    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        signName.setText(null);
        signUser.setText(null);
        signPass.setText(null);
        signConPass.setText(null);
    }
}
