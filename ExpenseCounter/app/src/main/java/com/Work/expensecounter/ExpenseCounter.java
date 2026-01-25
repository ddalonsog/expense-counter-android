package com.Work.expensecounter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

//Declaring class, "extends" means that this class is and Android window
public class ExpenseCounter extends AppCompatActivity {

    //Global variable to save the total expenses
    private double totalExpenses = 0.0;

    //This method executes automatically when this window is opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //Calls Android Constructor to prepare the base
        EdgeToEdge.enable(this); //Activates fullscreen design
        setContentView(R.layout.activity_expense_counter); // Connects the code with the xml file for visuals


        //Adjusts the margins to avoid buttons being hided by clock or the camera
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       //Linking the xml file to the code using the IDs
        EditText etAmount = findViewById(R.id.editTextAmount);
        EditText etDescription = findViewById(R.id.editTextDescription);
        Button btnAdd = findViewById(R.id.buttonAdd);
        TextView tvTotal = findViewById(R.id.textViewTotal);

        //Actions and behaivior for the botton
        btnAdd.setOnClickListener(v -> {

            //taking the values introduced and convert them to String
            String amountText = etAmount.getText().toString();

            //Verifying that the amount field is not empty
            if (!amountText.isEmpty()) {

                double amount = Double.parseDouble(amountText); //Converting the amount from String to double
                

                totalExpenses += amount;

                //Updating the TextView to show the total expenses in ($0.00) format
                tvTotal.setText(String.format(Locale.getDefault(), "$%.2f", totalExpenses));

                //Erases what was introduced by the user facilitating the next entry
                etAmount.setText("");
                etDescription.setText("");

                //Showing confirmation message
                Toast.makeText(this, "Added Expense", Toast.LENGTH_SHORT).show();
            } else {
                //Showing error message
                Toast.makeText(this, "Put an Amount Please", Toast.LENGTH_SHORT).show();
            }
        });
    }
}