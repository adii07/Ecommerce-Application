package com.aditya.bighatti.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aditya.bighatti.Activity.ProductDetailsActivity;
import com.aditya.bighatti.Model.MyRewardModel;
import com.aditya.bighatti.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRewardsAdaptor extends RecyclerView.Adapter<MyRewardsAdaptor.ViewHolder> {
    private List<MyRewardModel> myRewardModelList;
    private Boolean useMiniLayout=false;

    public MyRewardsAdaptor(List<MyRewardModel> myRewardModelList,Boolean useMiniLayout) {
        this.myRewardModelList = myRewardModelList;
        this.useMiniLayout=useMiniLayout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (useMiniLayout){
           view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mini_rewards_item_layout,parent,false);
        }
        else {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rewards_item_layout,parent,false);
        }
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title=myRewardModelList.get(position).getCouponTitle();
        String expiry=myRewardModelList.get(position).getCouponValidity();
        String body=myRewardModelList.get(position).getCouponBody();
        holder.setData(title,expiry,body);


    }

    @Override
    public int getItemCount() {
        return myRewardModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView couponTitle;
        private TextView couponValidity;
        private TextView couponBody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            couponTitle=itemView.findViewById(R.id.coupon_title);
            couponValidity=itemView.findViewById(R.id.coupon_validity);
            couponBody=itemView.findViewById(R.id.coupon_body);
        }
        private  void setData(final String title, final String expiry, final String body){
            couponTitle.setText(title);
            couponValidity.setText(expiry);
            couponBody.setText(body);
            if (useMiniLayout){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ProductDetailsActivity.couponTitle.setText(title);
                        ProductDetailsActivity.couponBody.setText(body);
                        ProductDetailsActivity.couponExpiryDate.setText(expiry);
                        ProductDetailsActivity.showDialogRV();
                    }
                });
            }
        }
    }
}
