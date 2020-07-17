package com.aditya.bighatti.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.aditya.bighatti.Adaptor.GridProductLayoutAdpator;
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
        gridView=findViewById(R.id.gridView);
        int layout_code=getIntent().getIntExtra("layout_code",-1);

        if (layout_code==0)
        {
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            List<WishlistModel> wishlistModelList = new ArrayList<>();
            wishlistModelList.add(new WishlistModel(R.drawable.image7, "Lotte ChocoPie", 1, "4.7", 1169, "Rs. 100/-", "Rs. 120", "Cash On Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image7, "Lotte ChocoPie", 0, "4.7", 1169, "Rs. 100/-", "Rs. 120", "Cash On Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image7, "Lotte ChocoPie", 4, "4.7", 1169, "Rs. 100/-", "Rs. 120", "Cash On Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image7, "Lotte ChocoPie", 2, "4.7", 1169, "Rs. 100/-", "Rs. 120", "Cash On Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image7, "Lotte ChocoPie", 1, "4.7", 1169, "Rs. 100/-", "Rs. 120", "Cash On Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image7, "Lotte ChocoPie", 1, "4.7", 1169, "Rs. 100/-", "Rs. 120", "Cash On Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image7, "Lotte ChocoPie", 0, "4.7", 1169, "Rs. 100/-", "Rs. 120", "Cash On Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image7, "Lotte ChocoPie", 4, "4.7", 1169, "Rs. 100/-", "Rs. 120", "Cash On Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image7, "Lotte ChocoPie", 2, "4.7", 1169, "Rs. 100/-", "Rs. 120", "Cash On Delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.image7, "Lotte ChocoPie", 1, "4.7", 1169, "Rs. 100/-", "Rs. 120", "Cash On Delivery"));

            wishlistAdaptor adaptor = new wishlistAdaptor(wishlistModelList, false);
            recyclerView.setAdapter(adaptor);
            adaptor.notifyDataSetChanged();
        }



        else if (layout_code ==1)
        {
            gridView.setVisibility(View.VISIBLE);
            List<HorizontalProductModel> horizontalProductModelList = new ArrayList<>();
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image, "Aashirvaad Aata", "10kg", "Rs. 590"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.amul, "Amul Chesse", "120g", "Rs. 100"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image2, "Royal Aata", "10kg", "Rs. 540"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image3, "Hershey Syrup", "450 g", "Rs. 200"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image4, "Nestle Ice Tea", "1L", "Rs. 120"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image5, "Roofafza", "750mL", "Rs. 150"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image6, "Hide And Seek", "120g", "Rs. 30"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image7, "Lotte Choco Pie", "300g", "Rs. 140"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image8, "Little Hearts", "18g", "Rs. 10"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image5, "Roofafza", "750mL", "Rs. 150"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image3, "Hershey Syrup", "450 g", "Rs. 200"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image4, "Nestle Ice Tea", "1L", "Rs. 120"));
            horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image5, "Roofafza", "750mL", "Rs. 150"));
            GridProductLayoutAdpator adpator = new GridProductLayoutAdpator(horizontalProductModelList);
            gridView.setAdapter(adpator);
        }
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