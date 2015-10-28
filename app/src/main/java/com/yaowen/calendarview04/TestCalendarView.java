package com.yaowen.calendarview04;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import java.text.SimpleDateFormat;

/**
 * Created by HelloWorld on 2015/10/28.
 */
public class TestCalendarView extends Activity {

    private CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        calendar= (CalendarView) findViewById(R.id.calendarView);
        long nowTime=calendar.getDate();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH：mm：ss");
        String time=sdf.format(nowTime);
        Log.d("TestCalendarView","time:"+time );
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                month+=1;
                Log.d("Test","year:"+year +",month:"+month+",dayOfMonth:"+dayOfMonth);
            }
        });


    }

}
