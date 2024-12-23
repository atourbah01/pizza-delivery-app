package com.example.midterm;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentMethod extends AppCompatActivity {

    private EditText etFullName, etCreditCardNumber, etSecurityCode, etStartDate, etExpirationDate;
    private Button processPaymentButton;
    private TextView Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        // Initialize views
        etFullName = findViewById(R.id.etFullName);
        etCreditCardNumber = findViewById(R.id.etCreditCardNumber);
        etSecurityCode = findViewById(R.id.etSecurityCode);
        etStartDate = findViewById(R.id.etStartDate);
        etExpirationDate = findViewById(R.id.etExpirationDate);
        processPaymentButton = findViewById(R.id.btnpayment);
        Price = findViewById(R.id.tvPizzaPrice);

        // Retrieve pizza name and price from Intent
        Intent intent = getIntent();
        if (intent != null) {
            String pizzaPrice = intent.getStringExtra("Pizza_Price");
            Price.setText("Price " + pizzaPrice);

        }

        // Set click listener for the "Process Payment" button
        processPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processPayment();
            }
        });
    }

    // Method to handle the "Process Payment" button click
    public void processPayment() {
        // Retrieve user input
        String fullName = etFullName.getText().toString().trim();
        String creditCardNumber = etCreditCardNumber.getText().toString().trim();
        String securityCode = etSecurityCode.getText().toString().trim();
        String startDate = etStartDate.getText().toString().trim();
        String expirationDate = etExpirationDate.getText().toString().trim();

        // Perform validation as needed
        if (fullName.isEmpty() || creditCardNumber.isEmpty() || securityCode.isEmpty() ||
                startDate.isEmpty() || expirationDate.isEmpty()) {
            // Display a Toast message if any field is empty
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
        } else {
            // Perform additional validation for the length of input fields
            if (creditCardNumber.length() > 16 || securityCode.length() > 3 ||
                    startDate.length() > 6 || expirationDate.length() > 6) {
                // Display a Toast message if any field exceeds the allowed length
                Toast.makeText(this, "Please enter valid information", Toast.LENGTH_SHORT).show();
            } else {
                // Placeholder: Display a toast indicating that payment is processed
                Toast.makeText(this, "Payment Processed", Toast.LENGTH_SHORT).show();

                // Navigate to WaitingDelivery activity or perform further actions as needed
                Intent intent = new Intent(this, WaitingDelivery.class);
                startActivity(intent);
            }
        }

    }
}
