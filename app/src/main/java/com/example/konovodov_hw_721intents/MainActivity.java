package com.example.konovodov_hw_721intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button searchButton;
    EditText searchLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchButton = findViewById(R.id.searchButton);
        searchLine = findViewById(R.id.searchLine);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchData = searchLine.getText().toString();
                if (searchData.length() != 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    if (Character.isLetter(searchData.charAt(0))) {
                        intent.setData(Uri.parse("geo:?q=" + searchData));
                    }
                    else {
                        intent.setData(Uri.parse("geo:" + searchData));
                    }
                    startActivity(intent);
                }
            }
        });
    }
}
