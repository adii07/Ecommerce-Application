package com.aditya.bighatti.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.bighatti.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDesFragment extends Fragment {

    public ProductDesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_des, container, false);
    }
}
