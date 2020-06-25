package com.aditya.bighatti.Adaptor;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aditya.bighatti.Activity.MyOrderItemModel;
import com.aditya.bighatti.Activity.order_details;
import com.aditya.bighatti.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyOrderAdaptor extends RecyclerView.Adapter<MyOrderAdaptor.ViewHolder> {

    private  List<MyOrderItemModel> myOrderItemModelsList;

    public MyOrderAdaptor(List<MyOrderItemModel> myOrderItemModelsList) {
        this.myOrderItemModelsList = myOrderItemModelsList;
    }

    @NonNull
    @Override
    public MyOrderAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order_item_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdaptor.ViewHolder holder, int position) {
    int resource=myOrderItemModelsList.get(position).getProductImage();
    int rating=myOrderItemModelsList.get(position).getRating();
    String title=myOrderItemModelsList.get(position).getProductTitle();
    String deliverDate=myOrderItemModelsList.get(position).getDeliveryStatus();
    holder.setData(resource,title,deliverDate,rating);
    }

    @Override
    public int getItemCount() {
        return myOrderItemModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private ImageView deliveryIndicator;
        private TextView productTitle;
        private  TextView deliveryStatus;
        private LinearLayout rateNowContainer;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);
            deliveryIndicator=itemView.findViewById(R.id.order_indicator);
            deliveryStatus=itemView.findViewById(R.id.order_delivered_date);
            rateNowContainer=itemView.findViewById(R.id.current_ratings_container);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(itemView.getContext(), order_details.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
        private void setData(int resource,String title,String deliveryDate,int rating){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (deliveryDate.equals("Cancelled")){
                deliveryIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.red)));}
            else {
                deliveryIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.green)));
            }
            deliveryStatus.setText(deliveryDate);

            setRatings(rating);
            for (int x=0;x<rateNowContainer.getChildCount();x++){
                final int STAR_POSITION=x;
                rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setRatings(STAR_POSITION);
                    }
                });
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


    }
}
