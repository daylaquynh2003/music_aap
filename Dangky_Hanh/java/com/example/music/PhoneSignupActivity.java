package com.example.music;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PhoneSignupActivity extends AppCompatActivity {

    private ImageView btnBack; // Nút "Back"
    private TextView tabEmail; // Tab "Email"
    private Button btnSendCode; // Nút "GỬI MÃ"
    private EditText etPhoneNumber; // Trường nhập số điện thoại
    private CheckBox termsCheckbox; // Checkbox đồng ý điều khoản

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dkmh4_dangkysdt); // Liên kết với layout "Đăng ký số điện thoại"

        // Ánh xạ các thành phần
        btnBack = findViewById(R.id.btnBack);
        tabEmail = findViewById(R.id.tabEmail);
        btnSendCode = findViewById(R.id.btnSendCode);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        termsCheckbox = findViewById(R.id.agreePolicy); // Ánh xạ checkbox từ layout


        // Xử lý sự kiện khi click vào tab "Email"
        tabEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển về màn hình "Đăng ký email"
                Intent intent = new Intent(PhoneSignupActivity.this, EmailSignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Xử lý sự kiện nút "GỬI MÃ"
        btnSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etPhoneNumber.getText().toString().trim();

                if (!termsCheckbox.isChecked()) {
                    // Nếu checkbox chưa được tick
                    Toast.makeText(PhoneSignupActivity.this, "Vui lòng đồng ý các điều khoản về chính sách bảo mật và thỏa thuận sử dụng.", Toast.LENGTH_LONG).show();
                } else if (phoneNumber.isEmpty()) {
                    // Nếu chưa nhập số điện thoại
                    Toast.makeText(PhoneSignupActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu mọi thứ hợp lệ, chuyển sang màn hình nhập mã xác nhận
                    Intent intent = new Intent(PhoneSignupActivity.this, DKMH5Activity.class);
                    intent.putExtra("phoneNumber", phoneNumber);
                    startActivity(intent);
                }
            }
        });
    }
}
