package com.aditya.bighatti.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.aditya.bighatti.Adaptor.AddressesAdaptor;
import com.aditya.bighatti.Model.AddressesModel;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyAddressesActivity extends AppCompatActivity {

    private RecyclerView myaddressesRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_addresses);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("MY Address");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myaddressesRV=findViewById(R.id.addresses_RV);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myaddressesRV.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList=new ArrayList<>();
        addressesModelList.add(new AddressesModel("Modi","7 Race cource road","1000129"));
        addressesModelList.add(new AddressesModel("Modi","Gujrat","100019"));
        addressesModelList.add(new AddressesModel("Modi","Banglore","1000129"));
        addressesModelList.add(new AddressesModel("Modi","7 Race cource road","1000129"));
        AddressesAdaptor addressesAdaptor=new AddressesAdaptor(addressesModelList);
        myaddressesRV.setAdapter(addressesAdaptor);
        addressesAdaptor.notifyDataSetChanged();


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}