package com.androidprojects.hotel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Calendar;

public class ScrollingActivity extends AppCompatActivity implements com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener {

    LinearLayout deluxeLayout, suiteLayout, roomsLayout, roomdetailLayout,single_item_bgcolor;
    MaterialEditText et_checkin, et_checkout;
    Button btn_availability;
    TextView tv_room_count;
    int roomAvailable=0;
    Button btn_amenities;
    int totalCount=32;
    private Integer[] mThumbIds = {
            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,
            R.drawable.ic_bed,            R.drawable.ic_bed, R.drawable.ic_bed,            R.drawable.ic_bed,R.drawable.ic_bed,            R.drawable.ic_bed,
            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,
            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,
            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,
            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,
            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed,            R.drawable.ic_bed
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_room_count=(TextView)findViewById(R.id.roomsCount);
        single_item_bgcolor=(LinearLayout)findViewById(R.id.singleitem_bgcolor);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new MyAdapter(this));
        gridview.setNumColumns(4);


        btn_amenities=(Button)findViewById(R.id.btn_amenities);
        btn_amenities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScrollingActivity.this,AmenitiesActivity.class);
                startActivity(intent);
            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                roomAvailable = totalCount-1;
                tv_room_count.setText("Available Rooms:" +roomAvailable);
               // single_item_bgcolor.setBackgroundColor(getResources().getColor(R.drawable.customshape_header_two));

            }
        });
        deluxeLayout = (LinearLayout) findViewById(R.id.deluxe_room_layout);
        suiteLayout = (LinearLayout) findViewById(R.id.suite_room_layout);
        roomsLayout = (LinearLayout) findViewById(R.id.rooms_layout);
        roomdetailLayout = (LinearLayout) findViewById(R.id.room_detail);
        et_checkin = (MaterialEditText) findViewById(R.id.checkin);
        et_checkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                com.wdullaer.materialdatetimepicker.date.DatePickerDialog dpd = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(
                        ScrollingActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");


            }
        });
        btn_availability=(Button)findViewById(R.id.btn_availability);
        btn_availability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout seatingLayout;
                btn_amenities.setVisibility(View.VISIBLE);
                tv_room_count.setVisibility(View.VISIBLE);
                seatingLayout=(LinearLayout)findViewById(R.id.seatingLayout);
                seatingLayout.setVisibility(View.VISIBLE);

            }
        });

        deluxeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                roomsLayout.setVisibility(View.GONE);
                roomdetailLayout.setVisibility(View.VISIBLE);





            }
        });

    }

    public class MyAdapter extends BaseAdapter {

        private Context mContext;

        public MyAdapter(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int arg0) {
            return mThumbIds[arg0];
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View grid;

            if(convertView==null){
                grid = new View(mContext);
                LayoutInflater inflater=getLayoutInflater();
                grid=inflater.inflate(R.layout.activity_single_gridview, parent, false);
            }else{
                grid = (View)convertView;
            }

            ImageView imageView = (ImageView)grid.findViewById(R.id.image);
            imageView.setImageResource(mThumbIds[position]);

            return grid;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        com.wdullaer.materialdatetimepicker.date.DatePickerDialog dpd = (com.wdullaer.materialdatetimepicker.date.DatePickerDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");
        if (dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = +dayOfMonth + "-" + (++monthOfYear) + "-" + year;
        et_checkin.setText(date);
    }
}
