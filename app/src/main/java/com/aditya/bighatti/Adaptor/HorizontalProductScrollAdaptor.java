package com.aditya.bighatti.Adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aditya.bighatti.Activity.HorizontalProductModel;
import com.aditya.bighatti.Activity.ProductDetailsActivity;
import com.aditya.bighatti.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalProductScrollAdaptor extends RecyclerView.Adapter<HorizontalProductScrollAdaptor.MyviewHolder> {
   private List<HorizontalProductModel> horizontalProductModelList;

    public HorizontalProductScrollAdaptor(List<HorizontalProductModel> horizontalProductModelList) {
        this.horizontalProductModelList = horizontalProductModelList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdaptor.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,parent,false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdaptor.MyviewHolder holder, int position) {
    int resouce=horizontalProductModelList.get(position).getProductImage();
    String title=horizontalProductModelList.get(position).getProductTitle();
    String description=horizontalProductModelList.get(position).getProductDescription();
    String price=horizontalProductModelList.get(position).getProductPrice();
        holder.setProductTitle(title);holder.setProductImage(resouce);holder.setProductDescription(description);holder.setProductPrice(price);

    }

    @Override
    public int getItemCount() {
        if (horizontalProductModelList.size()>8)
        {
            return 8;
        }
        return horizontalProductModelList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{

        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrice;

        public MyviewHolder(@NonNull final View itemView) {

            super(itemView);
            productImage=itemView.findViewById(R.id.hs_product_image);
            productTitle=itemView.findViewById(R.id.hs_product_title);
            productDescription=itemView.findViewById(R.id.hs_product_description);
            productPrice=itemView.findViewById(R.id.hs_product_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent productDetailsIntent=new Intent(itemView.getContext(), ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });
        }

        private void setProductImage(int resouce){
            productImage.setImageResource(resouce);
        }

        private void setProductTitle(String title){
            productTitle.setText(title);
        }
        private void setProductDescription(String des)
        {
            productDescription.setText(des);
        }
        private void setProductPrice(String price){
            productPrice.setText(price);
        }

    }


}
