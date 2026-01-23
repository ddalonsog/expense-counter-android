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
        String savedUser = preferences.getString("current_user", null);//Trying to get the entered user name, if not, returns null

        setContentView(R.layout.activity_sign_in);//Connects the code with the xml file for visuals

        //Connects with the elements on the xml file
        EditText etPassword = findViewById(R.id.editTextPassword);
        EditText etUserID = findViewById(R.id.editTextUserId);
        Button btnEnter = findViewById(R.id.btnEnter);


        //If there where not users found, it creates an Intent to open CreateUser, closes the current activity and stops the current code
        if(savedUser == null) {
            Intent intent = new Intent(this, createUser.class);
            startActivity(intent);
            finish();
            return;
        }

        //Activates the button
        btnEnter.setOnClickListener(v -> {

            //Reading entered data
            String userID = etUserID.getText().toString();
            String password = etPassword.getText().toString();

            //Gets the data from the "UserPrefs" file to compare with the entered data
            SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            String savedUserOnDisk = prefs.getString("current_user", "");
            String savedPassOnDisk = prefs.getString("password", "");

            //If entered data is equal to the recovered data, it opens the ExpenseCounter activity and closes the current activity
            if (userID.equals(savedUserOnDisk) && password.equals(savedPassOnDisk) ) {

                Toast.makeText(this, "Welcome " + userID, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ExpenseCounter.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "Incorrect credentials", Toast.LENGTH_SHORT).show();
            }

        });
    }
}