package com.smile.mohamed.restaurant.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.smile.mohamed.restaurant.R;

public class MayOrdersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may_orders);
        getSupportActionBar().setTitle("My Orders");

    }

    public void accept(View view) {
        Intent startIntent = new Intent(this, OnGoingActivity.class);
        startActivity(startIntent);
    }
}
