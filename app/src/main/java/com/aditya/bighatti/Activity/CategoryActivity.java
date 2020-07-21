package com.aditya.bighatti.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.aditya.bighatti.Adaptor.HomePageAdaptor;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title=getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar ().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView=findViewById(R.id.category_recycler_view);


        //////////////////////////////////////banner slider
//        List<SliderModel> sliderModelList =new ArrayList<SliderModel>();

        ////////////////////last 2 banners
//        sliderModelList.add(new SliderModel(R.drawable.banner5));
//        sliderModelList.add(new SliderModel(R.drawable.banner6));
//        ////////////original sequence
//        sliderModelList.add(new SliderModel(R.drawable.banner));
//        sliderModelList.add(new SliderModel(R.drawable.banner4));
//        sliderModelList.add(new SliderModel(R.drawable.banner2));
//        sliderModelList.add(new SliderModel(R.drawable.banner3));
//        sliderModelList.add(new SliderModel(R.drawable.banner5));
//        sliderModelList.add(new SliderModel(R.drawable.banner6));
        ////////////original sequence
        ///////first 2 banner
//        sliderModelList.add(new SliderModel(R.drawable.banner));
//        sliderModelList.add(new SliderModel(R.drawable.banner4));

        /////////////////////////////Horizontal Product Layout
//        List<HorizontalProductModel> horizontalProductModelList=new ArrayList<>();
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image,"Aashirvaad Aata","10kg","Rs. 590"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image2,"Royal Aata","10kg","Rs. 540"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image3,"Hershey Syrup","450 g","Rs. 200"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image4,"Nestle Ice Tea","1L","Rs. 120"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image5,"Roofafza","750mL","Rs. 150"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image6,"Hide And Seek","120g","Rs. 30"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image7,"Lotte Choco Pie","300g","Rs. 140"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image8,"Little Hearts","18g","Rs. 10"));
//        horizontalProductModelList.add(new HorizontalProductModel(R.drawable.image5,"Roofafza","750mL","Rs. 150"));



        LinearLayoutManager testingLayoutManager=new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);
        List<HomePageModel> homePageModelList=new ArrayList<>();
//        homePageModelList.add(new HomePageModel(0,sliderModelList));
//        homePageModelList.add(new HomePageModel(1,R.drawable.stipadd1,"#000000"));
//        homePageModelList.add(new HomePageModel(2,"Deals of the day!",horizontalProductModelList));
//        homePageModelList.add(new HomePageModel(3,"Categories",horizontalProductModelList));
//        homePageModelList.add(new HomePageModel(1,R.drawable.stipadd,"#ff0000"));
//        homePageModelList.add(new HomePageModel(2,"Deals of the day!",horizontalProductModelList));
//        homePageModelList.add(new HomePageModel(1,R.drawable.banner,"#ffff00"));
        HomePageAdaptor adaptor=new HomePageAdaptor(homePageModelList);
        categoryRecyclerView.setAdapter(adaptor);
        adaptor.notifyDataSetChanged();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.main_search_icon){
            return true;
            //todo search icon
        }
        else if (id== android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
