package com.Work.expensecounter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class createUser extends AppCompatActivity {

    @Override//method executed automatically when this window is opened
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//Calls Android Constructor to prepare the base
        setContentView(R.layout.activity_create_user);//Connects the code with the xml file for visuals

        //Connects with the elements on the xml file
        EditText etPassword = findViewById(R.id.editTextPassword);
        EditText etUserID = findViewById(R.id.editTextUserId);
        Button btnRegister = findViewById(R.id.btnRegister);

        //Activates the button
        btnRegister.setOnClickListener(v -> {
            //Reading entered data
            String userID = etUserID.getText().toString();
            String password = etPassword.getText().toString();

            //Creates a "UserPrefs" file and saves the entered data
            if(!userID.isEmpty() && !password.isEmpty() ) {
                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);//Opens the file in private mode
                SharedPreferences.Editor editor = prefs.edit();//Created an editor to save the data
                editor.putString("current_user", userID);//Saves the userID
                editor.putString("password", password);//Saves the passwrd
                editor.apply();//Confirms the writing for data storage

                Toast.makeText(this, "Welcome " + userID, Toast.LENGTH_SHORT).show();//Confirmation message

                //Creates the Intent and Opens the ExpenseCounter activity
                Intent intent = new Intent(this, ExpenseCounter.class);
                startActivity(intent);
                finish();//Closes the current activity
            }
            else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();//Error message
            }
        });

    }
}
