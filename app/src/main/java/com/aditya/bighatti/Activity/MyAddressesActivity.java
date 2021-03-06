package com.aditya.bighatti.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.aditya.bighatti.Adaptor.AddressesAdaptor;
import com.aditya.bighatti.Model.AddressesModel;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import static com.aditya.bighatti.Activity.DeliveryActivity.SELECT_ADDRESS;

public class MyAddressesActivity extends AppCompatActivity {

    private RecyclerView myaddressesRV;
    private Button deliverHereBTN;
    private static AddressesAdaptor addressesAdaptor;//static cause defined under a static method
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
        deliverHereBTN=findViewById(R.id.deliver_hereBTN);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myaddressesRV.setLayoutManager(layoutManager);


        List<AddressesModel> addressesModelList=new ArrayList<>();
        addressesModelList.add(new AddressesModel("Modi","7 Race cource road","1000129",true));
        addressesModelList.add(new AddressesModel("Modi","Gujrat","100019",false));
        addressesModelList.add(new AddressesModel("Modi","Banglore","1000129",false));
        addressesModelList.add(new AddressesModel("Modi","7 Race cource road","1000129",false));

        int mode=getIntent().getIntExtra("MODE",-1);
        if (mode ==SELECT_ADDRESS){
            deliverHereBTN.setVisibility(View.VISIBLE);
        }
        else deliverHereBTN.setVisibility(View.GONE);
        addressesAdaptor=new AddressesAdaptor(addressesModelList,mode);
        myaddressesRV.setAdapter(addressesAdaptor);
        ((SimpleItemAnimator)myaddressesRV.getItemAnimator()).setSupportsChangeAnimations(false);//disable the default animation as ripple effect added
        addressesAdaptor.notifyDataSetChanged();
    }

    public static void refreshItem(int deSelect,int select){
        addressesAdaptor.notifyItemChanged(deSelect);
        addressesAdaptor.notifyItemChanged(select);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}