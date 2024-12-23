package com.example.midterm;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {
    GridView grid;
    String[] maintitle = {"Pizza Margherita", "Pizza Pepperoni", "Vegeterian Pizza", "Cheese Pizza"};
    String[] subtitle = {"red tomato sauce, white mozzarella and fresh green basil", " meat mixture of beef and pork that has been cured and seasoned with paprika and chili powder", "Fresh tomatoes, onions, arugula, kale, eggplants, bell peppers, spinach, zucchini, mushrooms ", "a soft spun-curd cheese similar to Mozzarella made from cow's milk"};
    Integer[] imgid = {R.drawable.pizza_margherita, R.drawable.download3, R.drawable.download1, R.drawable.download5, R.drawable.downnload2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        PizzaListAdapter adapter = new PizzaListAdapter(this, maintitle, subtitle, imgid);
        grid = findViewById(R.id.grid_list);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "Price= 20$", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(FormActivity.this,PaymentMethod.class);
                    intent.putExtra("Pizza_Price",getPrice(position));
                    startActivity(intent);
                } else if (position == 1) {
                    Toast.makeText(getApplicationContext(), "Price= 30$", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(FormActivity.this,PaymentMethod.class);
                    intent.putExtra("Pizza_Price",getPrice(position));
                    startActivity(intent);
                } else if (position == 2) {
                    Toast.makeText(getApplicationContext(), "Price= 5$", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(FormActivity.this,PaymentMethod.class);
                    intent.putExtra("Pizza_Price",getPrice(position));
                    startActivity(intent);
                } else if (position == 3) {
                    Toast.makeText(getApplicationContext(), "Price= 15$", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(FormActivity.this,PaymentMethod.class);
                    intent.putExtra("Pizza_Price",getPrice(position));
                    startActivity(intent);
                } else if (position == 4) {
                    Toast.makeText(getApplicationContext(), "Price= 10$", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(FormActivity.this,PaymentMethod.class);
                    intent.putExtra("Pizza_Price",getPrice(position));
                    startActivity(intent);
                }
            }
        });
    }

    private String getPrice(int position) {
        // Replace this with your actual logic to get the price based on the position
        switch (position) {
            case 0:
                return "20$";
            case 1:
                return "30$";
            case 2:
                return "5$";
            case 3:
                return "15$";
            case 4:
                return "10$";
            default:
                return "0$";
        }
    }
}

