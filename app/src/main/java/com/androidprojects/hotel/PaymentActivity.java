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
public class PaymentActivity extends AppCompatActivity {


    Button btn_payment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btn_payment=(Button)findViewById(R.id.btn_payment);
        btn_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PaymentActivity.this,BillActivity.class);
                startActivity(intent);


            }
        });

    }
}
