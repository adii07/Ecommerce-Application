package com.aditya.bighatti.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.aditya.bighatti.Adaptor.CartAdaptor;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DeliveryActivity extends AppCompatActivity {

    private RecyclerView deliveryRecyclerView;
    private Button changeORaddNewaddressBTN;
    public static  final int SELECT_ADDRESS=0;
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


        deliveryRecyclerView=findViewById(R.id.Delivery_recyclerView);
        changeORaddNewaddressBTN=findViewById(R.id.change_or_add_addressBTN);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList=new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.amul,"Amul Chesse",1,"Rs.200","Rs. 240",2,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.amul,"Amul Chesse",0,"Rs.200","Rs. 240",2,1,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.amul,"Amul Chesse",1,"Rs.200","Rs. 240",2,2,0));
        cartItemModelList.add(new CartItemModel(1,"Price(3 items)","Rs. 200/-","free","Rs. 200/-","Rs. 40/-"));
        CartAdaptor cartAdaptor =new CartAdaptor(cartItemModelList);
        deliveryRecyclerView.setAdapter(cartAdaptor);
        cartAdaptor.notifyDataSetChanged();

        changeORaddNewaddressBTN.setVisibility(View.VISIBLE);
        changeORaddNewaddressBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DeliveryActivity.this,MyAddressesActivity.class);
                intent.putExtra("MODE",SELECT_ADDRESS);
                startActivity(intent);

            }
        });


    }

    //Back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id= item.getItemId();
//        if(id==R.id.main_search_icon){
//            return true;
//            //todo search icon
//        }
//        else if (id== android.R.id.home){
//            finish();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}