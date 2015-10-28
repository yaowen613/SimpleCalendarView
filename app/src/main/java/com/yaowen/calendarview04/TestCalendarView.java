package com.yaowen.calendarview04;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

/**
 * Created by YAOWEN on 2015/10/28.
 */
public class TestCalendarView extends Activity implements CalendarView.OnDateChangeListener, View.OnClickListener {
    private View view;
    private CalendarView calendar;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        editText = (EditText) findViewById(R.id.et);
        editText.setOnClickListener(this);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        view = View.inflate(TestCalendarView.this, R.layout.calendarview, null);
        calendar = (CalendarView) view.findViewById(R.id.calendarview2);
        calendar.setOnDateChangeListener(this);
        return new AlertDialog.Builder(TestCalendarView.this)
                .setTitle("请选择日期")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(view)
                .setPositiveButton("确定",null)
                .create();
    }

    @Override
    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
        editText.setText(year + "年" +( month+1)+ "月" + dayOfMonth+"日");
    }

    @Override
    public void onClick(View v) {
        onCreateDialog(v.getId()).show();
    }
}
