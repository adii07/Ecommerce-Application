package com.aditya.bighatti.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.bighatti.Adaptor.wishlistAdaptor;
import com.aditya.bighatti.Model.WishlistModel;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyWishlistFragment extends Fragment {
    public MyWishlistFragment() {

    }

    private RecyclerView wishlistRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        wishlistRecyclerView=view.findViewById(R.id.myWishlistRecyclerView);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(layoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(layoutManager);

        List<WishlistModel> wishlistModelList=new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",1,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",0,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",4,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",2,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",1,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));

        wishlistAdaptor wishlistAdaptor=new wishlistAdaptor(wishlistModelList,true);
        wishlistRecyclerView.setAdapter(wishlistAdaptor);
        wishlistAdaptor.notifyDataSetChanged();
        return view;
    }
}