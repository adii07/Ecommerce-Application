package com.aditya.bighatti.Activity;

import android.os.Bundle;

import com.aditya.bighatti.Adaptor.CartAdaptor;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView cartItemsRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Back button
        getSupportActionBar ().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");


        cartItemsRecyclerView=findViewById(R.id.cart_items_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
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
    }
}