package com.Work.expensecounter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class signIn extends AppCompatActivity {
    
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        
        EditText etUserID = findViewById(R.id.editTextUserId);
        Button btnEnter = findViewById(R.id.btnEnter);
        
        btnEnter.setOnClickListener(v -> {
            String userID = etUserID.getText().toString();
            
            if (!userID.isEmpty()) {
                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("current_user", userID);
                editor.apply();
                
                Toast.makeText(this, "Welcome " + userID, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ExpenseCounter.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "Please enter a UserID", Toast.LENGTH_SHORT).show();
            }

        });
    }
}