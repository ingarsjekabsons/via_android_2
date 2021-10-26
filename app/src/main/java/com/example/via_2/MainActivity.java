package com.example.via_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSecond(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.setClass(this, SecondActivity.class);
        startActivity(intent);
    }

    public void openDialog(View view) {
        FragmentManager fm = getSupportFragmentManager();
        ModalDialog dialog = new ModalDialog();
        dialog.show(fm, "dialog");
    }
}