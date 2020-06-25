package com.aditya.bighatti.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aditya.bighatti.Model.WishlistModel;
import com.aditya.bighatti.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class wishlistAdaptor extends RecyclerView.Adapter<wishlistAdaptor.ViewHolder> {
   private  List<WishlistModel> wishlistModelList;

    public wishlistAdaptor(List<WishlistModel> wishlistModelList) {
        this.wishlistModelList = wishlistModelList;
    }

    @NonNull
    @Override
    public wishlistAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wishlistAdaptor.ViewHolder holder, int position) {
    int resorce=wishlistModelList.get(position).getProductImage();
    String title=wishlistModelList.get(position).getProductTitle();
    int freeCoupons=wishlistModelList.get(position).getFreeCoupons();
    String ratings=wishlistModelList.get(position).getProductRatings();
    int totalRatings=wishlistModelList.get(position).getTotalRatings();
    String productPrice=wishlistModelList.get(position).getProductPrice();
    String cuttedPrice=wishlistModelList.get(position).getProductCuttedPrice();
    String paymentMethod=wishlistModelList.get(position).getPaymentMethod();
    holder.setData(resorce,title,freeCoupons,ratings,totalRatings,productPrice,cuttedPrice,paymentMethod);
    }

    @Override
    public int getItemCount() {
        return wishlistModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productTitle;
        private TextView freeCoupons;
        private ImageView couponIcon;
        private TextView rating;
        private  TextView totalRatings;
        private TextView productPrice;
        private TextView productCuttedPrice;
        private View priceCut;
        private TextView paymentMethods;
        private ImageButton deleteBTN;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);
            freeCoupons=itemView.findViewById(R.id.free_coupons);
            couponIcon=itemView.findViewById(R.id.coupon_icon);
            rating=itemView.findViewById(R.id.Rating_miniView);
            totalRatings=itemView.findViewById(R.id.total_ratings);
            productPrice=itemView.findViewById(R.id.product_price);
            productCuttedPrice=itemView.findViewById(R.id.cutted_price);
            priceCut=itemView.findViewById(R.id.priceCut);
            paymentMethods=itemView.findViewById(R.id.payment_method);
            deleteBTN=itemView.findViewById(R.id.delete_btn);
        }

        private  void setData(int resource, String title, int freeCouponsNo, String averageRating, int totalRatingsNo, String price, String cutPrice, String method){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCouponsNo != 0){
                couponIcon.setVisibility(View.VISIBLE);
                if (freeCouponsNo ==1)
                freeCoupons.setText("free "+freeCouponsNo+" coupon");
                else
                freeCoupons.setText("free "+freeCouponsNo+" coupons");
            }
            else {
                couponIcon.setVisibility(View.INVISIBLE);
                freeCoupons.setVisibility(View.INVISIBLE);
            }
            rating.setText(averageRating);
            totalRatings.setText(totalRatingsNo+" ratings");
            productPrice.setText(price);
            productCuttedPrice.setText(cutPrice);
            paymentMethods.setText(method);
            deleteBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(),"Delete",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
