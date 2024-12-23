package com.example.midterm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    ListView list;
    String[] maintitle = {"Pizza Hut", "Papa John's", "Domino's Pizza"};
    String[] subtitle = {"No one outpizzas the hut", "Better ingredients. Better pizza. Papa John's", "We'll deliver in 30 minutes or less, or it's free!"};
    Integer[] imgid = {R.drawable.pizzahut, R.drawable.papajohns, R.drawable.dominos};

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        TextView newsTitle = rootView.findViewById(R.id.news);
        newsTitle.setText("Recent News");

        TextView news1 = rootView.findViewById(R.id.new1);
        news1.setText("Snake pizza in Pizza Hut\n09 Nov, 2023, 02:41 AM IST");

        ImageView imageView = rootView.findViewById(R.id.img1);
        imageView.setImageResource(R.drawable.download5);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebpage();
            }
        });

        TextView orgTitle = rootView.findViewById(R.id.org);
        orgTitle.setText("Pizza Order");

        list = rootView.findViewById(R.id.list);
        ArrayAdapter<String> adapter = new MyListAdapter(requireContext(), maintitle,subtitle,imgid);
        list.setAdapter(adapter);
        // Set an OnItemClickListener for the ListView
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the subtitle of the selected item
                String selectedSubtitle = subtitle[position];

                // Display a toast message with the subtitle
                Toast.makeText(requireContext(), selectedSubtitle, Toast.LENGTH_SHORT).show();
            }
        });

        TextView questionText = rootView.findViewById(R.id.question);
        questionText.setText("If you want to order pizza press here");

        Button questionButton = rootView.findViewById(R.id.questionbtn);
        questionButton.setText("Head to Questionnaire");
        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForm();
            }
        });

        return rootView;
    }

    private void openWebpage() {
        // Replace this URL with the actual URL you want to open
        String url = "https://edition.cnn.com/2023/11/08/travel/snake-pizza-in-hong-kong-intl-hnk/index.html";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void openForm() {
        Intent intent = new Intent(requireContext(), FormActivity.class);
        startActivity(intent);
    }
}

