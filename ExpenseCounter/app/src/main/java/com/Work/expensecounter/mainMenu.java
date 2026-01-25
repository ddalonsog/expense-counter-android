package com.Work.expensecounter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;


public class mainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnExpenseCounter = findViewById(R.id.btnGoToExpenses);
        Button btnBalance = findViewById(R.id.btnGoToBalance);
        Button btnSalary = findViewById(R.id.btnGoToSalary);
        Button btnCreateUser = findViewById(R.id.btnGoToCreateUser);
        Button btnChangeUser = findViewById(R.id.btnChangeUser);

        btnExpenseCounter.setOnClickListener(v -> {
            Intent intent = new Intent(this, ExpenseCounter.class);
            startActivity(intent);
        });

        btnBalance.setOnClickListener(v -> {
            Intent intent = new Intent(this, Balance.class);
            startActivity(intent);
        });

        btnSalary.setOnClickListener(v -> {
            Intent intent = new Intent(this, addSalary.class);
            startActivity(intent);
        });

        btnCreateUser.setOnClickListener(v -> {
            Intent intent = new Intent(this, createUser.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        btnChangeUser.setOnClickListener(v -> {
            Intent intent = new Intent(this, signIn.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }

}
