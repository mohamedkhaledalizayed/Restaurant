package com.smile.mohamed.restaurant.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.smile.mohamed.restaurant.R;

public class PindingOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinding_order);
        getSupportActionBar().setTitle("Home");
    }

    public void myStore(View view) {
        Intent startIntent = new Intent(this, MainActivity.class);
        startActivity(startIntent);
    }

    public void orders(View view) {
        Intent startIntent = new Intent(this, MayOrdersActivity.class);
        startActivity(startIntent);
    }
}
