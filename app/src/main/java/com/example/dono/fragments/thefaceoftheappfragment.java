package com.example.dono.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dono.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link thefaceoftheappfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class thefaceoftheappfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button etbenefactorbtn, btnBuy;

    public void clickmain()
    {

    etbenefactorbtn=getView().findViewById(R.id.benefactorbtn);
    btnBuy = getView().findViewById(R.id.btnBuy);
    btnBuy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        gotoBuyFragment();
    }
});

etbenefactorbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //benefactor
        loginbenefactorfragment loginbenefactorfragment=new loginbenefactorfragment();
        FragmentManager manager=getFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayoutMain,loginbenefactorfragment,loginbenefactorfragment.getTag()).commit();
    }
    });
    }


    public thefaceoftheappfragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment thefaceoftheappfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static thefaceoftheappfragment newInstance(String param1, String param2) {
        thefaceoftheappfragment fragment = new thefaceoftheappfragment();
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
        return inflater.inflate(R.layout.fragment_thefaceoftheappfragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        clickmain();
    }

    private void gotoBuyFragment(){
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new SellFragment());
        ft.commit();
    }
}