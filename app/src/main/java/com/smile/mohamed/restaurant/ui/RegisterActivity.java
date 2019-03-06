package com.smile.mohamed.restaurant.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.smile.mohamed.restaurant.R;
import com.smile.mohamed.restaurant.adapters.DatabaseAdapter;
import com.smile.mohamed.restaurant.models.User;

import java.util.Calendar;
import java.util.Date;


public class RegisterActivity extends ToolbarActivity {

    private DatabaseAdapter databaseAdapter;

    private TextInputLayout mUsername;
    private TextInputLayout mFullname;
    private TextInputLayout mEmail;
    private TextInputLayout mPassword;

    Date now;
    Calendar c;
    TimePickerDialog picker;
    DatePickerDialog picker_2;

    TextView date_txt, time_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseAdapter = DatabaseAdapter.getInstance(this);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mUsername = findViewById(R.id.reg_display_name);
        mFullname = findViewById(R.id.login_fullname);
        mEmail = findViewById(R.id.login_email);
        mPassword = findViewById(R.id.login_password);
        c = Calendar.getInstance();

        date_txt = findViewById(R.id.date);
        time_txt = findViewById(R.id.time);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCreateAccountPressed(View view) {
        String username = mUsername.getEditText().getText().toString();
        String fullname = mFullname.getEditText().getText().toString();
        String email = mEmail.getEditText().getText().toString();
        String password = mPassword.getEditText().getText().toString();

        registerUser(new User(username, fullname, email, password));
    }

    private void registerUser(User user) {
        databaseAdapter.addNewUser(user);

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void selectDate(View view) {
        picker_2=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                date_txt.setText(i+":"+(i1+1)+":"+i2);
            }
        },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));

        picker_2.show();
    }

    public void selectTime(View view) {
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minutes = c.get(Calendar.MINUTE);
        // time picker dialog
        picker = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker tp, int sHour, int sMinute) {

                        time_txt.setText(sHour + ":" + sMinute+": 00");

                    }
                }, hour, minutes, false);

        picker.show();

    }
}
