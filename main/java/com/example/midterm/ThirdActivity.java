package com.example.midterm;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText mobileNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        fullNameEditText = findViewById(R.id.editTextFullName);
        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        mobileNumberEditText = findViewById(R.id.editTextMobileNumber);

        Button signupButton = findViewById(R.id.btnSignup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        String fullName = fullNameEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String mobileNumber = mobileNumberEditText.getText().toString().trim();

        if (!fullName.isEmpty() && !username.isEmpty() && !password.isEmpty() && !mobileNumber.isEmpty()) {
            DBHelper dbHelper = new DBHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // Check if the username already exists
            if (!usernameExists(db, username)) {
                ContentValues values = new ContentValues();
                values.put(DBContract.Login.COLUMN_FULLNAME, fullName);
                values.put(DBContract.Login.COLUMN_USERNAME, username);
                values.put(DBContract.Login.COLUMN_PASSWORD, password);
                values.put(DBContract.Login.COLUMN_MOBILE, mobileNumber);

                long newRowId = dbHelper.insertData(fullName, username, password, mobileNumber);

                if (newRowId != -1) {
                    // Insert successful
                    Toast.makeText(this, "Signup successful! log in " + username, Toast.LENGTH_SHORT).show();
                    // Go back to the login page
                    Intent intent = new Intent(this, SecondActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Insert failed
                    Toast.makeText(this, "Signup failed. Please try again.", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Username already exists
                Toast.makeText(this, "Username already exists. Please choose a different username.", Toast.LENGTH_SHORT).show();
            }

            // Close the database connection
            //db.close();
        } else {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean usernameExists(SQLiteDatabase db, String username) {
        String[] projection = {
                DBContract.Login.COLUMN_USERNAME
        };
        String selection = DBContract.Login.COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(
                DBContract.Login.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        boolean exists = cursor.getCount() > 0;

        cursor.close();

        return exists;
    }
}