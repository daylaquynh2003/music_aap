package com.example.music;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DKMH5Activity extends AppCompatActivity {

    private TextView subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dkmh5_nhapmaxacnhan);

        // Khởi tạo View
        subtitle = findViewById(R.id.subtitle);

        // Lấy dữ liệu số điện thoại từ Intent
        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra("phoneNumber");

        // Hiển thị số điện thoại trong TextView
        if (phoneNumber != null) {
            subtitle.setText("Mã gồm 6 chữ số đã được gửi tới +84 " + phoneNumber);
        }
    }
}
