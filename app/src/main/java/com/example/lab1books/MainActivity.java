package com.example.lab1books;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerBooks;
    private RadioGroup radioGroupYears;
    private Button btnOk;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBooks = findViewById(R.id.spinnerBooks);
        radioGroupYears = findViewById(R.id.radioGroupYears);
        btnOk = findViewById(R.id.btnOk);
        textResult = findViewById(R.id.textResult);

        String[] authors = {"Тарас Шевченко", "Іван Франко", "Леся Українка"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                authors
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBooks.setAdapter(adapter);

        btnOk.setOnClickListener(v -> {
            int selectedYearId = radioGroupYears.getCheckedRadioButtonId();

            if (selectedYearId == -1) {
                Toast.makeText(this, "Заповніть усі дані", Toast.LENGTH_SHORT).show();
                return;
            }

            String selectedAuthor = spinnerBooks.getSelectedItem().toString();
            RadioButton selectedYear = findViewById(selectedYearId);
            String year = selectedYear.getText().toString();

            textResult.setText("Автор: " + selectedAuthor + "\nРік видання: " + year);
        });
    }
}