package com.example.dono.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.dono.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VISAdonationfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VISAdonationfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText visatallnum;
    private EditText username;
    private EditText howmuch;
    private Button donate;
    private Button previous;

    public void func(){

        previous=getView().findViewById(R.id.Backbtnn);
        donate=getView().findViewById(R.id.dopaypal);
        howmuch=getView().findViewById(R.id.mablag);
        username=getView().findViewById(R.id.usernamepaypal);



        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etusername,etmablag;
                etusername=username.getText().toString();
                etmablag=howmuch.getText().toString();
                if(etmablag.trim().isEmpty()&&etusername.trim().isEmpty()){
                    Toast.makeText(getContext(), "somthing null !!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Toast.makeText(getContext(), "donate succes!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), " thank you so much!", Toast.LENGTH_SHORT).show();
                gotoTheFace();}
            }
        });



    }

    private void gotoTheFace() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutPersonalePage,new thefaceoftheappfragment());
        ft.addToBackStack(null);
        ft.commit();
    }


    public VISAdonationfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VISAdonationfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VISAdonationfragment newInstance(String param1, String param2) {
        VISAdonationfragment fragment = new VISAdonationfragment();
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
        return inflater.inflate(R.layout.fragment_v_i_s_adonationfragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        func();
    }
}