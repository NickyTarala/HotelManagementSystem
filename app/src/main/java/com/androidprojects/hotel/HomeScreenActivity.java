package com.androidprojects.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Nikhitha Tarala on 11/17/2016.
 */
public class HomeScreenActivity extends AppCompatActivity {

    LinearLayout layout_book_rooms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        layout_book_rooms=(LinearLayout)findViewById(R.id.layout_book_rooms);
        layout_book_rooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeScreenActivity.this,ScrollingActivity.class);
                startActivity(intent);

            }
        });

    }
}
