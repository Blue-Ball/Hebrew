package com.adebayo.hebrewtext;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.HebrewCalendar;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kosherjava.zmanim.hebrewcalendar.HebrewDateFormatter;
import com.kosherjava.zmanim.hebrewcalendar.JewishCalendar;
import com.kosherjava.zmanim.hebrewcalendar.JewishDate;

import net.time4j.calendar.frenchrev.FrenchRepublicanCalendar;

import java.util.Calendar;
import java.util.Date;


public class HebrewDateActivity extends AppCompatActivity {
TextView datetxt;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hebrew_date);

        datetxt = findViewById(R.id.datetext);
        JewishCalendar jd = new JewishCalendar();
        HebrewDateFormatter hdf = new HebrewDateFormatter();


        String s = "Todays day is";
        int n = jd.getJewishDayOfMonth();

        String dayof = String.format("%d", n);
      //  String interpolated  = String.format("%0"+ n +"d", 0).replace("0", s );
      //  System.out.println(interpolated );


      //  int dayOfWeek = jd.getJewishDayOfMonth();
//        jd.setJewishDate(5781, JewishDate.NISSAN, 12);
//        jd.getDayOfWeek();
//        System.out.println(jd.isTaanisBechoros());


        datetxt.setText(s + " "  + dayof);
       // datetxt.setText(dayOfWeek);


        datetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HebrewDateActivity.this, MainActivity.class);
                intent.putExtra("DAY", n);
                startActivity(intent);
            }
        });

        Log.e(
                "response error ",
                "response error " + "   " + s + " " + dayof
        );
    }
}