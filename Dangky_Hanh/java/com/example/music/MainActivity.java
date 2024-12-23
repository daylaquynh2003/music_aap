package com.example.music;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import model.User;

public class MainActivity extends AppCompatActivity {

    private TextView signupText; // Khai báo TextView "Đăng ký ngay"
    private CheckBox termsCheckbox; // Khai báo CheckBox

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dkmh1_dangky); // Liên kết với layout

        // Ánh xạ TextView "Đăng ký ngay" và CheckBox
        signupText = findViewById(R.id.signup);
        termsCheckbox = findViewById(R.id.policyCheckbox);

        // Xử lý sự kiện khi click vào "Đăng ký ngay"
        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra trạng thái của checkbox
                if (termsCheckbox.isChecked()) {
                    // Chuyển sang màn hình đăng ký email
                    Intent intent = new Intent(MainActivity.this, EmailSignupActivity.class);
                    startActivity(intent);


                } else {
                    // Hiển thị thông báo nếu chưa tick vào checkbox
                    Toast.makeText(MainActivity.this, "Vui lòng đồng ý các điều khoản về chính sách bảo mật và thỏa thuận sử dụng.", Toast.LENGTH_LONG).show();
                }
            }
        });


        DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://bold-apricot-445309-p8-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference("/save_data/User/user1");
        User user = new User("id","username")
        databaseReference.setValue("Hello, World!");
    }
}
