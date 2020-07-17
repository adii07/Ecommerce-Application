package com.aditya.bighatti.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aditya.bighatti.Adaptor.MyRewardsAdaptor;
import com.aditya.bighatti.Adaptor.ProductImagesAdaptor;
import com.aditya.bighatti.Adaptor.product_details_adaptor;
import com.aditya.bighatti.Model.MyRewardModel;
import com.aditya.bighatti.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class ProductDetailsActivity extends AppCompatActivity {

    private ViewPager productImagesViewPager;
    private TabLayout viewPagerIndicator;
    private FloatingActionButton addToWishlistButton;
    private static Boolean AlreadyAddedToWishList=false;
    private ViewPager productDetailsViewPager;
    private TabLayout productDetailsTabLayout;
    private Button buyNowBTN;
    private Button couponRedeemBTN;
    ///ratings layout
    private LinearLayout rateNowContainer;
    ///ratings layout

    ///coupon dialog
    public static TextView couponTitle,couponBody,couponExpiryDate;
    private static RecyclerView couponRv;
    private static LinearLayout selectedCoupon;
    ///coupon dialog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar ().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImagesViewPager=findViewById(R.id.product_image_viewPager);
        viewPagerIndicator=findViewById(R.id.viewPager_indicator);
        addToWishlistButton=findViewById(R.id.add_to_wishList_button);
        productDetailsViewPager=findViewById(R.id.product_details_viewPager);
        productDetailsTabLayout=findViewById(R.id.product_details_tab_layout);
        buyNowBTN=findViewById(R.id.buy_now_button);
        couponRedeemBTN=findViewById(R.id.coupon_redemption_btn);
        List<Integer>  productImages =new ArrayList<>();
        productImages.add(R.drawable.amul);
        productImages.add(R.drawable.amul);
        productImages.add(R.drawable.amul);
        productImages.add(R.drawable.amul);

        ProductImagesAdaptor productImagesAdaptor=new ProductImagesAdaptor(productImages);
        productImagesViewPager.setAdapter(productImagesAdaptor);

        viewPagerIndicator.setupWithViewPager(productImagesViewPager,true);

        addToWishlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AlreadyAddedToWishList){
                    AlreadyAddedToWishList=false;
                    addToWishlistButton.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                }else {
                    AlreadyAddedToWishList=true;
                    addToWishlistButton.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#d92027")));
                }
            }
        });

        productDetailsViewPager.setAdapter(new product_details_adaptor(getSupportFragmentManager(),productDetailsTabLayout.getTabCount()));
        productDetailsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTabLayout));
        productDetailsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ///ratings layout
        rateNowContainer=findViewById(R.id.current_ratings_container);
        for (int x=0;x<rateNowContainer.getChildCount();x++){
            final int STAR_POSITION=x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setRatings(STAR_POSITION);
                }
            });
        }
        ///ratings layout

        buyNowBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buyNowIntent= new Intent(ProductDetailsActivity.this,DeliveryActivity.class);
                startActivity(buyNowIntent);
            }
        });

        /////coupon dialog
        final Dialog redeemDialog=new Dialog(ProductDetailsActivity.this);
        redeemDialog.setContentView(R.layout.coupon_redeem_dialog);
        redeemDialog.setCancelable(true);
        redeemDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        ImageView toggleCouponRV=redeemDialog.findViewById(R.id.toggle_rv);
        couponRv=redeemDialog.findViewById(R.id.coupons_rv);
        selectedCoupon=redeemDialog.findViewById(R.id.selected_coupon);
        couponTitle=redeemDialog.findViewById(R.id.coupon_title);
        couponBody=redeemDialog.findViewById(R.id.coupon_body);
        couponExpiryDate=redeemDialog.findViewById(R.id.coupon_validity);

        TextView originalPrice=redeemDialog.findViewById(R.id.original_price);
        TextView couponPrice=redeemDialog.findViewById(R.id.after_price);

        LinearLayoutManager layoutManager=new LinearLayoutManager(ProductDetailsActivity.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        couponRv.setLayoutManager(layoutManager);

        List<MyRewardModel> myRewardModelList=new ArrayList<>();
        myRewardModelList.add(new MyRewardModel("CashBack","Till 30th June,2020","20% cashback Applicable on any product above Rs.200/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 4th July,2020","30% cashback Applicable on any product above Rs.500/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 30th July,2020","10% cashback Applicable on any product above Rs.100/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 10th August,2020","50% cashback Applicable on any product above Rs.5000/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 30th June,2020","20% cashback Applicable on any product above Rs.200/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 4th July,2020","30% cashback Applicable on any product above Rs.500/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 30th July,2020","10% cashback Applicable on any product above Rs.100/- using Google Pay."));
        myRewardModelList.add(new MyRewardModel("CashBack","Till 10th August,2020","50% cashback Applicable on any product above Rs.5000/- using Google Pay."));


        MyRewardsAdaptor myRewardsAdaptor=new MyRewardsAdaptor(myRewardModelList,true);
        couponRv.setAdapter(myRewardsAdaptor);
        myRewardsAdaptor.notifyDataSetChanged();


        toggleCouponRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogRV();
            }
        });
        ///coupon dialog
        couponRedeemBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                               redeemDialog.show();
            }
        });
    }

    public static void showDialogRV(){
        if (couponRv.getVisibility()==View.GONE){
            couponRv.setVisibility(View.VISIBLE);
            selectedCoupon.setVisibility(View.GONE);
        }
        else {
            couponRv.setVisibility(View.GONE);
            selectedCoupon.setVisibility(View.VISIBLE);
        }

    }

    private void setRatings(int star_position) {
        for (int x=0;x<rateNowContainer.getChildCount();x++){
            ImageView starBTN=(ImageView)rateNowContainer.getChildAt(x);
            starBTN.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
            if (x<=star_position){
                starBTN.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id== android.R.id.home){
            finish();
            return true;
            //todo back icon

        }
        else if (id==R.id.main_search_icon){
            return true;
            //todo search icon
        }

        else if (id==R.id.main_cart_icon){
            return true;
            //todo cart icon
        }
        return super.onOptionsItemSelected(item);
    }
}
