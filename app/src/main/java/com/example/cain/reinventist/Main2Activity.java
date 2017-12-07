package com.example.cain.reinventist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    CalendarView calendarView;
    int Myear,Mmonth,Mday;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=(TextView)findViewById(R.id.textView4);
        calendarView=(CalendarView)findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Myear =i;
                Mmonth = i1;
                Mday = i2;

                textView.setText(new StringBuilder().append(Myear).append("-").
                        append(Mmonth+12).append("-").append(Mday));
            }
        });




    }
}
