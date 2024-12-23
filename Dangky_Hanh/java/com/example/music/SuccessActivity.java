package com.example.music;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dkmh3_dangkythanhcong); // Liên kết với layout đăng ký thành công
        // Ánh xạ Button "ĐI ĐẾN ĐĂNG NHẬP"
        btnBack = findViewById(R.id.btnBack);

        // Xử lý sự kiện click
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay lại màn hình chính
                Intent intent = new Intent(SuccessActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish(); // Kết thúc màn hình hiện tại
            }
        });
    }
}
