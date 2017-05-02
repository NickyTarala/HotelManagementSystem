package com.androidprojects.hotel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class BillActivity  extends AppCompatActivity{

    TextView total,textView,textView1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        total=(TextView)findViewById(R.id.total);
        textView=(TextView)findViewById(R.id.textView);





















        textView1=(TextView)findViewById(R.id.textView1);
        textView.setText("Congratulations!!");
        textView1.setText("Your Room has been booked!");
        //String d1=getIntent().getStringExtra("deluxe");










        total.setText("Your Total bill is $600");






    }
}
