package com.example.valid_register_form;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPassword;
    private RadioGroup rgGender;
    private CheckBox cbTerms;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        rgGender = findViewById(R.id.rgGender);
        cbTerms = findViewById(R.id.cbTerms);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            int selectedId = rgGender.getCheckedRadioButtonId();

            // Validate name
            if (name.isEmpty()) {
                etName.setError("Please enter your name");
                etName.requestFocus();
                return;
            }

            // Validate password
            if (password.isEmpty()) {
                etPassword.setError("Please enter your password");
                etPassword.requestFocus();
                return;
            }

            // Validate gender
            if (selectedId == -1) {
                Toast.makeText(
                        MainActivity.this,
                        "Please select your gender",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            // Validate terms
            if (!cbTerms.isChecked()) {
                Toast.makeText(
                        MainActivity.this,
                        "Please accept the terms and conditions",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            // Get selected gender
            RadioButton selectedRadioButton = findViewById(selectedId);
            String gender = selectedRadioButton.getText().toString();

            // Registration successful
            Toast.makeText(
                    MainActivity.this,
                    "Registered: " + name + " (" + gender + ")",
                    Toast.LENGTH_LONG
            ).show();
        });
    }
}
