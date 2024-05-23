package com.example.dono;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.dono.fragments.RecylerViewFragment;

public class FrameLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FRAME,new RecylerViewFragment());
        ft.commit();
    }
}