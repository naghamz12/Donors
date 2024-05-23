package com.example.dono.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.dono.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link forgetpassfragmentpenefactor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class forgetpassfragmentpenefactor extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText etemail;
    private ImageButton email;
    private FirebaseAuth mAuth;
    private Button previous;

    private void instalize() {

        etemail = getView().findViewById(R.id.emailforgottext);
        email = getView().findViewById(R.id.sendemailbtn);
        previous=getView().findViewById(R.id.backbtnf);
        mAuth = FirebaseAuth.getInstance();

        // if the user have acount //if he has no acount send toast and go to sign up
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginbenefactorfragment loginbenefactorfragment = new loginbenefactorfragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.frameLayoutMain, loginbenefactorfragment, loginbenefactorfragment.getTag()).commit();
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emaill = etemail.getText().toString();
                if (emaill.trim().isEmpty()) {
                    Toast.makeText(getContext(), "SOMTHING FAILED ! " + "", Toast.LENGTH_SHORT).show();
                    return;}


                mAuth.sendPasswordResetEmail(emaill).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(), "Email Has send" + "", Toast.LENGTH_SHORT).show();
                        loginbenefactorfragment Loginfragmentcoustumer=new loginbenefactorfragment();
                        FragmentManager manager=getFragmentManager();
                        manager.beginTransaction().replace(R.id.frameLayoutMain,Loginfragmentcoustumer,Loginfragmentcoustumer.getTag()).commit();
                    }
                });

            }


        });
    }


    public forgetpassfragmentpenefactor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment forgetpassfragmentpenefactor.
     */
    // TODO: Rename and change types and number of parameters
    public static forgetpassfragmentpenefactor newInstance(String param1, String param2) {
        forgetpassfragmentpenefactor fragment = new forgetpassfragmentpenefactor();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgetpassfragmentpenefactor, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        instalize();
    }
}