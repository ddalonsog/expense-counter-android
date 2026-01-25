package com.Work.expensecounter;

import androidx.appcompat.app.AppCompatActivity;

public class addSalary extends AppCompatActivity { // extends AppCompatActivity because we want to use newer features on older devices

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //Calls android constructor to prepare the base
        setContentView(R.layout.activity_add_salary); //Connects the code with the xml file for visuals

        //Connects to the expandible button on the xml file
        Spinner spinner = findViewById(R.id.spinnerSalaryType);

        //Providing Spinner the required options
        String[] options = {"Monthly", "Byweekly", "Annual"};

        //Creating the adapter that links the String array to the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


    }
}
