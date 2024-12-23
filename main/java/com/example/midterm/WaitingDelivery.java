package com.example.midterm;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WaitingDelivery extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView loadingText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_delivery);
        // Initialize views
        progressBar = findViewById(R.id.progressBar);
        loadingText = findViewById(R.id.text);
        // Execute the AsyncTask to simulate a background task
        new BackgroundTask().execute();
    }

    private class BackgroundTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            // Simulate a task that takes 10 seconds
            for (int progress = 0; progress <= 100; progress += 10) {
                try {
                    Thread.sleep(1000); // 1 seconds
                    publishProgress(progress); // Update progress
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onPreExecute() {
            // Initialize the ProgressBar and set max value
            progressBar.setMax(100);
        }
        protected void onProgressUpdate(Integer... values) {
            // Update ProgressBar and loading text during the task
            progressBar.setProgress(values[0]);
            loadingText.setText("Please wait, this will take a while...\n" + values[0] + "%");
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            finish(); // Finish the WaitingDelivery activity
            // Navigate back to the home fragment or perform the necessary action
            // (Replace HomeFragment with the actual name of your home fragment)
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
    }
}
