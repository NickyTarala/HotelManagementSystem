package com.androidprojects.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Nikhitha Tarala on 11/20/2016.
 */
public class ReservationActivity extends AppCompatActivity {

    Button btn_checkIn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);


        btn_checkIn=(Button)findViewById(R.id.btn_checkin);

        btn_checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ReservationActivity.this,PaymentActivity.class);
                startActivity(intent);

            }
        });

    }
}
