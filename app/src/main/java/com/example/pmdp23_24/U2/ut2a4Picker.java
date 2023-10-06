package com.example.pmdp23_24.U2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.pmdp23_24.R;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.TextView;
import java.util.Calendar;

public class ut2a4Picker extends AppCompatActivity {

    private Button pickDateBtn;
    private TextView selectedDateTV;
    private Button pickTimeBtn;
    private TextView selectedTimeTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ut2a4_picker);

        // on below line we are initializing our variables.
        pickDateBtn = findViewById(R.id.idBtnPickDate);
        selectedDateTV = findViewById(R.id.idTVSelectedDate);

        // on below line we are adding click listener for our pick date button
        pickDateBtn.setOnClickListener(v -> {
            // on below line we are getting
            // the instance of our calendar.
            final Calendar c = Calendar.getInstance();

            // on below line we are getting
            // our day, month and year.
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // on below line we are creating a variable for date picker dialog.
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    // on below line we are passing context.
                    ut2a4Picker.this,
                    (view, year1, monthOfYear, dayOfMonth) -> {
                        // on below line we are setting date to our text view.
                        selectedDateTV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1);

                    },
                    // on below line we are passing year,
                    // month and day for selected date in our date picker.
                    year, month, day);
            // at last we are calling show to
            // display our date picker dialog.
        });

        pickTimeBtn = findViewById(R.id.idBtnPickTime);
        selectedTimeTV = findViewById(R.id.idTVSelectedTime);

        // on below line we are adding click
        // listener for our pick date button
        pickTimeBtn.setOnClickListener(v -> {
            // on below line we are getting the
            // instance of our calendar.
            final Calendar c = Calendar.getInstance();

            // on below line we are getting our hour, minute.
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // on below line we are initializing our Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(ut2a4Picker.this,
                    (view, hourOfDay, minute1) -> {
                        // on below line we are setting selected time
                        // in our text view.
                        selectedTimeTV.setText(hourOfDay + ":" + minute1);
                    }, hour, minute, false);
            // at last we are calling show to
            // display our time picker dialog.
            timePickerDialog.show();
        });

    }
}