package com.example.shahd.datepicker2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener
{
    TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date= (TextView)findViewById(R.id.showdate);
    }

    public void datepicker(View view)
    {
        DatePickerFragment fragment=new DatePickerFragment();
        fragment.show(getSupportFragmentManager(),"date");
    }

    private void setDate(final Calendar calendar)
    {
        final DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.MEDIUM);
        date.setText(dateFormat.format(calendar.getTime()));
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        Calendar cal=new GregorianCalendar(year,month,dayOfMonth);
        setDate(cal);
    }


    public static class DatePickerFragment extends DialogFragment
    {
        @Override
        public Dialog onCreateDialog(Bundle bundle) {
            final  Calendar c=Calendar.getInstance();
            int year=c.get(Calendar.YEAR);
            int month=c.get(Calendar.MONTH);
            int date=c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener)getActivity(),year,month,date);
        }
    }
}
