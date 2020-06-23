package com.aditya.bighatti.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.bighatti.Activity.MyOrderItemModel;
import com.aditya.bighatti.Adaptor.MyOrderAdaptor;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrdersFragment extends Fragment {

    public MyOrdersFragment() {
        // Required empty public constructor
    }
    private RecyclerView myOrderRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_orders, container, false);
    myOrderRecyclerView=view.findViewById(R.id.my_orders_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myOrderRecyclerView.setLayoutManager(layoutManager);

        List<MyOrderItemModel> myOrderItemModelList=new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.image7,"Lotte Choco Pie","Delivered. Mon 15 Jan,2020",4));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.image6,"Hide and seek","Cancelled",1));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.image8,"Little Hearts","Delivered. Mon 25 Jan,2020",5));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.image3,"Hershey's syrup","Delivered. Mon 15 Jan,2020",3));
        MyOrderAdaptor myOrderAdaptor=new MyOrderAdaptor(myOrderItemModelList);
        myOrderRecyclerView.setAdapter(myOrderAdaptor);
        myOrderAdaptor.notifyDataSetChanged();
        return view;
    }
}
