package com.donatracker.a3even2odd.donatracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.donatracker.a3even2odd.donatracker.R;
import com.donatracker.a3even2odd.donatracker.models.persistance.Persistence;
import com.donatracker.a3even2odd.donatracker.models.register.Register;
import com.donatracker.a3even2odd.donatracker.models.user.User;
import com.donatracker.a3even2odd.donatracker.models.user.UserTypes;

/**
 * View for registration screen.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class RegistrationActivity extends AppCompatActivity {
    private Spinner userTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userTypeSpinner = findViewById(R.id.userTypeSpinner);
        userTypeSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, UserTypes.values()));
    }

    /**
     * Button handler for Register Button
     *
     * @param v the Button
     */
    public void onRegisterPressed(View v) {
        String username = ((EditText) findViewById(R.id.usernameNew)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordNew)).getText().toString();
        String checkPassword = ((EditText) findViewById(R.id.passwordNew2)).getText().toString();
        Register register = new Register(username, password, checkPassword);
        TextView passwordCheck = findViewById(R.id.passwordCheck);
        TextView errorUsername = findViewById(R.id.errorUsername);

        if(!register.assertPassword()) {
            passwordCheck.setVisibility(View.VISIBLE);
        } else {
            passwordCheck.setVisibility(View.GONE);
        }
        if (!register.assertUsername()) {
            errorUsername.setVisibility(View.VISIBLE);
        } else {
            errorUsername.setVisibility(View.GONE);
        }
        if(register.assertUsername() && register.assertPassword()) {
            User user = new User(username, password, (UserTypes)userTypeSpinner.getSelectedItem());

            Toast.makeText(this, "Account Added", Toast.LENGTH_SHORT).show();

            Persistence.getInstance().write(User.SAVE_FILE, getApplicationContext(), user);

            Intent mainIntent = new Intent(this, MainActivity.class);
            mainIntent.putExtra("EXTRA_USER_TYPE", user.getAccountType());
            startActivity(mainIntent);

            finish();
        }
    }

    /**
     * Button handler ofr Cancel Button
     *
     * @param v the Button
     */
    public void onCancelPressed(View v) {
        finish();
    }

}
