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

public class ExpenseCounter extends AppCompatActivity {


    private double totalExpenses = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expense_counter);


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

            String amountText = etAmount.getText().toString();


            if (!amountText.isEmpty()) {

                double amount = Double.parseDouble(amountText);
                

                totalExpenses += amount;


                tvTotal.setText(String.format(Locale.getDefault(), "$%.2f", totalExpenses));


                etAmount.setText("");
                etDescription.setText("");


                Toast.makeText(this, "Gasto agregado", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(this, "Escribe un monto por favor", Toast.LENGTH_SHORT).show();
            }
        });
    }
}