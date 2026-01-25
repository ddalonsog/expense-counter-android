package com.Work.expensecounter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class signIn extends AppCompatActivity {

    //method executed automatically when this window is opened
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//Calls Android Constructor to prepare the base

        SharedPreferences preferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);//Opening "UserPrefs" file to read data
        boolean hasUsers = preferences.getBoolean("any_user_registered", false);//Trying to get the entered user name, if not, returns null

        setContentView(R.layout.activity_sign_in);//Connects the code with the xml file for visuals

        //If there where not users found, it creates an Intent to open CreateUser, closes the current activity and stops the current code
        if(!hasUsers) {
            Intent intent = new Intent(this, createUser.class);
            startActivity(intent);
            finish();
            return;
        }

        //Connects with the elements on the xml file
        EditText etPassword = findViewById(R.id.editTextPassword);
        EditText etUserID = findViewById(R.id.editTextUserId);
        Button btnEnter = findViewById(R.id.btnEnter);



        //Activates the button
        btnEnter.setOnClickListener(v -> {
            String userID = etUserID.getText().toString();
            String password = etPassword.getText().toString();

            SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);

            // Seeking the password for the entered userID
            String savedPassword = prefs.getString("user_pass_" + userID, null);

            if (savedPassword != null && savedPassword.equals(password)) {
                // If passwrd exists and matches
                Toast.makeText(this, "Welcome " + userID, Toast.LENGTH_SHORT).show();

                // Saves who is the current user
                prefs.edit().putString("active_user", userID).apply();

                //Creates and Intent and opens main menu
                startActivity(new Intent(this, mainMenu.class));
                finish();//Closes the current activity
            } else {
                Toast.makeText(this, "User not found or wrong password", Toast.LENGTH_SHORT).show();//Error message
            }
        });
    }
}