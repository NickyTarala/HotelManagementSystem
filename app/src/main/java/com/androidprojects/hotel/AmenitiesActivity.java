package com.androidprojects.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Nikhitha Tarala on 11/20/2016.
 */
public class AmenitiesActivity extends AppCompatActivity {

    LinearLayout ll_one,ll_two,ll_three;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amenities);

        ll_one=(LinearLayout)findViewById(R.id.extra_one);

        ll_two=(LinearLayout)findViewById(R.id.extra_two);

        ll_three=(LinearLayout)findViewById(R.id.extra_three);



        ll_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int deluxeGym=600;

                String deluxe=Integer.toString(deluxeGym);
                Intent intent=new Intent(AmenitiesActivity.this,ReservationActivity.class);

                intent.putExtra("deluxe",deluxe);
                startActivity(intent);




            }
        });

      /*  ll_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                deluxeSpa=150+500;
                String deluxe=Integer.toString(deluxeSpa);
                Intent intent=new Intent(AmenitiesActivity.this,BillActivity.class);
                    intent.putExtra("deluxe",deluxe);
                startActivity(intent);


            }
        });

        ll_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                deluxePool=500+150;
                String deluxe=Integer.toString(deluxePool);
                Intent intent=new Intent(AmenitiesActivity.this,BillActivity.class);
               intent.putExtra("deluxe",deluxe);
                startActivity(intent);

            }
        });

*/


    }
}
