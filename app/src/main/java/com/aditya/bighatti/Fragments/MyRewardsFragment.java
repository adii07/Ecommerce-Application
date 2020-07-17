package com.aditya.bighatti.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.bighatti.Adaptor.MyRewardsAdaptor;
import com.aditya.bighatti.Model.MyRewardModel;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyRewardsFragment extends Fragment {
    public MyRewardsFragment() {
    }

    private RecyclerView rewardsRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       // ((MainActivity)getActivity()).updateStatusBarColor("#5B04B1");
        View view= inflater.inflate(R.layout.fragment_my_rewards, container, false);
        rewardsRecyclerView=view.findViewById(R.id.myRewards_RecyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardsRecyclerView.setLayoutManager(layoutManager);

        List<MyRewardModel> myRewardModelList=new ArrayList<>();
        myRewardModelList.add(new MyRewardModel("CashBack","Till 30th June,2020","20% cashback Applicable on any product above Rs.200/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 4th July,2020","30% cashback Applicable on any product above Rs.500/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 30th July,2020","10% cashback Applicable on any product above Rs.100/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 10th August,2020","50% cashback Applicable on any product above Rs.5000/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 30th June,2020","20% cashback Applicable on any product above Rs.200/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 4th July,2020","30% cashback Applicable on any product above Rs.500/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 30th July,2020","10% cashback Applicable on any product above Rs.100/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 10th August,2020","50% cashback Applicable on any product above Rs.5000/- using Google Pay."));

        MyRewardsAdaptor myRewardsAdaptor=new MyRewardsAdaptor(myRewardModelList,false);
        rewardsRecyclerView.setAdapter(myRewardsAdaptor);
        myRewardsAdaptor.notifyDataSetChanged();
        return view;
    }
}