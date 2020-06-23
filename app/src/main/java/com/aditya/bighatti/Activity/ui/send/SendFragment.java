package com.aditya.bighatti.Activity.ui.send;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.aditya.bighatti.Activity.login;
import com.aditya.bighatti.Activity.ui.home.HomeFragment;
import com.aditya.bighatti.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SendFragment extends Fragment {
    Button btnYes,btnNo;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_send, container, false);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity().getApplicationContext(), login.class);
                startActivity(intent);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity().getApplicationContext(), HomeFragment.class);
                startActivity(intent);
            }
        });

        return root;
    }
    public void bind(View view)
    {

    }
}