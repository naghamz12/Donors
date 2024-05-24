package com.example.dono.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.dono.FireBaseServises;
import com.example.dono.R;
import com.example.dono.fragments.loginbenefactorfragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        FireBaseServises fbs = FireBaseServises.getInstance();
//        if (fbs.getAuth().getCurrentUser() == null)
          gotoLoginFragment();
       // else gotoHomeFragment();
    }

    private void gotoLoginFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain,new loginbenefactorfragment());
        ft.commit();
    }

    private void gotoHome() {
        /*
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain,new PersonalpageActivity());
        ft.commit();
        */
        Intent i = new Intent(this, PersonalpageActivity.class);
        startActivity(i);
    }


}