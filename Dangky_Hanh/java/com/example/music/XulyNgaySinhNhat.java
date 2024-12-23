package com.example.music;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class XulyNgaySinhNhat extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dkmh6_nhapngaysinh); // Giao diện XML chứa birthdayEditText

        EditText birthdayEditText = findViewById(R.id.birthdayEditText);

        birthdayEditText.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker = new DatePickerDialog(
                    XulyNgaySinhNhat.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        String formattedDate = "Ngày " + selectedDay + " tháng " + (selectedMonth + 1) + " năm " + selectedYear;
                        birthdayEditText.setText(formattedDate);
                    },
                    year, month, day
            );

            datePicker.show();
        });
    }
}
