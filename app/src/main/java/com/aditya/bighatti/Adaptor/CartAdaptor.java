package com.aditya.bighatti.Adaptor;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.aditya.bighatti.Activity.CartItemModel;
import com.aditya.bighatti.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdaptor extends RecyclerView.Adapter {

    public CartAdaptor(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    List<CartItemModel> cartItemModelList;
    @Override
    public int getItemViewType(int position) {
        switch (cartItemModelList.get(position).getType()){
            case 0:
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case CartItemModel.CART_ITEM:
                View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
                return new cartItemViewHolder(itemView);
            case CartItemModel.TOTAL_AMOUNT:
                View totalView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_amount_layout,parent,false);
                return new cartTotalAmountViewHolder(totalView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    switch (cartItemModelList.get(position).getType()){
        case CartItemModel.CART_ITEM:
            int resource=cartItemModelList.get(position).getProductImage();
            String title=cartItemModelList.get(position).getProductTitle();
            int freeCoupons=cartItemModelList.get(position).getFreeCoupons();
            String productPrice=cartItemModelList.get(position).getProductPrice();
            String cuttedPrice=cartItemModelList.get(position).getProductCuttedPrice();
            int offersApplied=cartItemModelList.get(position).getOffersApplied();

            ((cartItemViewHolder)holder).setItemsDetails(resource,title,freeCoupons,productPrice,cuttedPrice,offersApplied);
            break;
            case CartItemModel.TOTAL_AMOUNT:
                String totalItems=cartItemModelList.get(position).getTotalItems();
                String totalItemsPrice=cartItemModelList.get(position).getTotalItemPrice();
                String deliveryPrice=cartItemModelList.get(position).getDeliveryPrice();
                String totalAmount=cartItemModelList.get(position).getTotalAmount();
                String savedAmount=cartItemModelList.get(position).getSavedAmount();

                ((cartTotalAmountViewHolder)holder).setTotalAmount(totalItems,totalItemsPrice,deliveryPrice,totalAmount,savedAmount);
                break;
        default:
            return;
    }
    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    class cartItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private ImageView freeCouponsIcon;
        private TextView productTitle;
        private TextView freeCoupons;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offersApplied;
        private TextView couponsApplied;
        private TextView productQuantity;

        public cartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.ProductImage);
            productTitle = itemView.findViewById(R.id.ProductTitle);
            freeCouponsIcon = itemView.findViewById(R.id.free_coupon_icon);
            freeCoupons = itemView.findViewById(R.id.tv_free_coupon);
            productPrice = itemView.findViewById(R.id.product_price);
            cuttedPrice = itemView.findViewById(R.id.cutted_price);
            offersApplied = itemView.findViewById(R.id.offers_applied);
            couponsApplied = itemView.findViewById(R.id.coupons_applied);
            productQuantity = itemView.findViewById(R.id.product_quantity);
        }

        private void setItemsDetails(int resource, String title, int freeCouponsNumber,String price,String cutPrice,int offersAppliedNumber ) {
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCouponsNumber > 0) {
                freeCouponsIcon.setVisibility(View.VISIBLE);
                freeCoupons.setVisibility(View.VISIBLE);
                if (freeCouponsNumber == 1) {
                    freeCoupons.setText("free " + freeCouponsNumber + "Coupon.");
                }
             else
                 {
                freeCoupons.setText("free " + freeCouponsNumber + "Coupons.");
            }
        }else {
                freeCouponsIcon.setVisibility(View.INVISIBLE);
                freeCoupons.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(price);
            cuttedPrice.setText(cutPrice);
            if (offersAppliedNumber>0)
            {
                offersApplied.setVisibility(View.VISIBLE);
                offersApplied.setText(offersAppliedNumber+" Offers Applied");
            }
            else
            {
                offersApplied.setVisibility(View.INVISIBLE);
            }

            productQuantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Dialog quantityDialog=new Dialog(itemView.getContext());
                    quantityDialog.setContentView(R.layout.quantity_dialog);
                    quantityDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    quantityDialog.setCancelable(false);
                    final EditText quantTXT=quantityDialog.findViewById(R.id.quantity_txt);
                    Button cancelBTN=quantityDialog.findViewById(R.id.cancelBtn);
                    Button okayBTN=quantityDialog.findViewById(R.id.OkayBTN);
                    cancelBTN.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            quantityDialog.dismiss();
                        }
                    });
                    okayBTN.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String num=quantTXT.getText().toString();
                            productQuantity.setText("Qty: "+num);
                            quantityDialog.dismiss();
                        }
                    });
                    quantityDialog.show();
                }
            });
        }

    }


    class cartTotalAmountViewHolder extends RecyclerView.ViewHolder{

        private TextView totalItems;
        private TextView totalItemsPrice;
        private TextView deliveryPrice;
        private TextView totalAmount;
        private TextView savedAmount;
        public cartTotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);
            totalItems=itemView.findViewById(R.id.total_items);
            totalItemsPrice=itemView.findViewById(R.id.total_items_price);
            deliveryPrice=itemView.findViewById(R.id.delivery_charge);
            totalAmount=itemView.findViewById(R.id.total_price);
            savedAmount=itemView.findViewById(R.id.saved_amount);
        }
        private void setTotalAmount(String totalItemText,String totalItemPriceText,String deliveryPriceText,String totalAmountText,String savedAmountText){
            totalItems.setText(totalItemText);
            totalItemsPrice.setText(totalItemPriceText);
            deliveryPrice.setText(deliveryPriceText);
            totalAmount.setText(totalAmountText);
            savedAmount.setText(savedAmountText);
        }
    }
}
