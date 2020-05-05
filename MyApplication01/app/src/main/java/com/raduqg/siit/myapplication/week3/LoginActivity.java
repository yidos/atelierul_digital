package com.raduqg.siit.myapplication.week3;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.raduqg.siit.myapplication.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPhone;
    private CheckBox tc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        tc = findViewById(R.id.cb_t_c);
        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tc.isChecked()) {
                    handleSubmit(etEmail.getText(), etPhone.getText());
                } else {
                    Toast.makeText(LoginActivity.this, "Yo uhave to accept terms and conditions",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    private void handleSubmit(CharSequence email, CharSequence phone) {
        if (email == null || email.length() == 0) {
            // email error
            etEmail.setError("Email cannot be empty");
        } else if (phone == null || phone.length() == 0) {
            // phone error
            etPhone.setError("Phone cannot be empty");
        } else {
            // submit data
            Toast.makeText(this, "Well done", Toast.LENGTH_SHORT).show();
            // clear input data
            etEmail.setText("");
            etPhone.setText("");
        }
    }
}
