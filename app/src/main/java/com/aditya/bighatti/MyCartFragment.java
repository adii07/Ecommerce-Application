package com.aditya.bighatti;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.bighatti.Activity.CartItemModel;
import com.aditya.bighatti.Adaptor.CartAdaptor;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyCartFragment extends Fragment {

    public MyCartFragment() {
        // Required empty public constructor
    }

    private RecyclerView cartItemsRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_cart, container, false);

        cartItemsRecyclerView=view.findViewById(R.id.cart_items_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList=new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.amul,"Amul Chesse",1,"Rs.200","Rs. 240",2,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.amul,"Amul Chesse",0,"Rs.200","Rs. 240",2,1,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.amul,"Amul Chesse",1,"Rs.200","Rs. 240",2,2,0));
        cartItemModelList.add(new CartItemModel(1,"Price(3 items)","Rs. 200/-","free","Rs. 200/-","Rs. 40/-"));
        CartAdaptor cartAdaptor =new CartAdaptor(cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdaptor);
        cartAdaptor.notifyDataSetChanged();
        return view;
    }
}
