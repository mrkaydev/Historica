package com.kay.historica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {
    ImageButton reg, hp, cr, comm, bot, vlogs, plan,about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!DetectConnection.checkInternetConnection(this)) {
            Toasty.warning(getApplicationContext(), "No Internet! Connection ,app will not work ,please connect and try again", Toast.LENGTH_SHORT).show();
            this.finishAffinity();}
        SliderView sliderView = findViewById(R.id.imageSlider);
        SliderAdapterExample adapter = new SliderAdapterExample(this);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
        bot = (ImageButton) findViewById(R.id.bot);
        cr = (ImageButton) findViewById(R.id.chatroom);
        hp = (ImageButton) findViewById(R.id.hp);
        reg = (ImageButton) findViewById(R.id.reg);
        comm = (ImageButton) findViewById(R.id.comm);
        vlogs = (ImageButton) findViewById(R.id.vlogs);
        plan = (ImageButton) findViewById(R.id.plan);
        about=(ImageButton)findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TripPlanner.class);
                Toasty.success(MainActivity.this, "All resource's are taken from https://www.triphobo.com", Toast.LENGTH_LONG, true).show();
                startActivity(intent);
            }
        });
        vlogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Videos.class);
                Toasty.success(MainActivity.this, "Welcome to Vlog's Section...Enjoy...", Toast.LENGTH_LONG, true).show();
                startActivity(intent);
            }
        });
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Guide.class);
                Toasty.success(MainActivity.this, "All resource's are taken from https://www.incredibleindia.org", Toast.LENGTH_LONG, true).show();
                startActivity(intent);
            }
        });
        comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewImageActivity.class);
                Toasty.success(MainActivity.this, "Welcome to Community Post", Toast.LENGTH_LONG, true).show();
                startActivity(intent);
            }
        });
        cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                Toasty.info(MainActivity.this, "Welcome to GlobalChat ,here you can chat with other user's on this app..\n", Toast.LENGTH_LONG, true).show();
                startActivity(intent);
            }
        });
        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Monument_Reg.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
     //   this.finishAffinity();

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this app???")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}
