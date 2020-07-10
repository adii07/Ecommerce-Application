package com.aditya.bighatti.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.aditya.bighatti.Adaptor.wishlistAdaptor;
import com.aditya.bighatti.Model.WishlistModel;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAllActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the day(DEMO)");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<WishlistModel> wishlistModelList=new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",1,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",0,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",4,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",2,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",1,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",1,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",0,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",4,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",2,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.image7,"Lotte ChocoPie",1,"4.7",1169,"Rs. 100/-","Rs. 120","Cash On Delivery"));

        wishlistAdaptor adaptor=new wishlistAdaptor(wishlistModelList,false);
        recyclerView.setAdapter(adaptor);
        adaptor.notifyDataSetChanged();


    }

    //Back Button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home){
             finish();
             return true;
        }
        return super.onOptionsItemSelected(item);

    }
}