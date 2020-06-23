package com.aditya.bighatti.Activity.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.bighatti.Activity.MyOrderItemModel;
import com.aditya.bighatti.Adaptor.MyOrderAdaptor;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private RecyclerView myOrderRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
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
