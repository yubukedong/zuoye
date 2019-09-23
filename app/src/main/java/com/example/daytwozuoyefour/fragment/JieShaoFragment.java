package com.example.daytwozuoyefour.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daytwozuoyefour.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JieShaoFragment extends Fragment {


    public JieShaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_jie_shao, container, false);
        return inflate;
    }

}
