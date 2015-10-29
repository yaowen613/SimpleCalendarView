package com.yaowen.calendarview04;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

/**
 * Created by YAOWEN on 2015/10/28.
 */
public class TestCalendarView extends Activity implements View.OnClickListener {
    private View view;
    private CalendarView calendar;
    private EditText editText;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        editText = (EditText) findViewById(R.id.et);//初始化edittext控件
        editText.setOnClickListener(this);//设置edittext控件的点击响应事件
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        //实例化一个view
        view = View.inflate(TestCalendarView.this, R.layout.calendarview, null);
        //初始化一个calendarView控件
        calendar = (CalendarView) view.findViewById(R.id.calendarview2);
        //自定义一个类 并实例化一个类的对象；
        Event event = new Event();
        //设置calendarView的事件监听
        calendar.setOnDateChangeListener((CalendarView.OnDateChangeListener) event);
        if (dialog == null) {//如果dialog为null时创建dialog，否则直接return一个dialog；
            dialog = new AlertDialog.Builder(TestCalendarView.this)//新建一个AlertDialog
                    // .setTitle("选择日期")
                    // .setIcon(android.R.drawable.ic_dialog_info)
                    .setView(view)
                    .setPositiveButton("确定", (DialogInterface.OnClickListener) event)
                    .create();
        }
        return dialog;
    }

    @Override
    public void onClick(View v) {
        // 控件的响应事件onClick方法
        onCreateDialog(v.getId()).show();
    }

    /**
     * 实现一个内部类，使之能监听事件的点击和calendarView的选中改变的响应事件
     **/
    public class Event implements DialogInterface.OnClickListener, CalendarView.OnDateChangeListener {
        private String text;

        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
            String date = year + "年" + (month + 1) + "月" + dayOfMonth + "日";
            text = date;
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            editText.setText(text);
        }
    }
}
