package com.example.arbintaj.wastemanagement;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    Gps gps;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Uri uri=Uri.parse("https://mail.google.com/mail/u/0/#inbox?compose=15a842dededd0f2a");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }
    public void a(View view)
    {
        Intent i=new Intent(this, Wet_Waste.class);
        startActivity(i);
    }

    public void b(View view)
    {
        Intent i=new Intent(this, Dry_Waste.class);
        startActivity(i);
    }

    public void c(View view)
    {
        gps=new Gps(this);
        if(gps.canGetLocation()){
            Double lat=gps.getLatitude();
            Double lan=gps.getLongitude();
            //Toast.makeText(getActivity(), "the lat is:"+lat+"long :"+lan+".", Toast.LENGTH_LONG).show();
            Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/d/edit?hl=en&hl=en&authuser=0&mid=19AyTeHg1Ws5DouNZkc6FwtktOLQ&ll=12.983367085306934%2C77.76770804463786&z=20"));

            //https://www.google.co.in/maps/dir/12.983963,77.7618532/12.9604329,77.5357086,11z
            //https://www.google.co.in/maps/dir/12.983963,77.7618532/12.9604329,77.5357086,11z
            startActivity(i);

        }else{
            gps.showSettingsAlert();
        }
    }

    public void d(View view)
    {
        Intent i=new Intent(this, Sanitary_Waste.class);
        startActivity(i);
    }

}
