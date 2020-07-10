package com.aditya.bighatti.Adaptor;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aditya.bighatti.Activity.HorizontalProductModel;
import com.aditya.bighatti.Activity.ProductDetailsActivity;
import com.aditya.bighatti.R;

import java.util.List;

public class GridProductLayoutAdpator extends BaseAdapter {

    List<HorizontalProductModel> horizontalProductModelList;

    public GridProductLayoutAdpator(List<HorizontalProductModel> horizontalProductModelList) {
        this.horizontalProductModelList = horizontalProductModelList;
    }

    @Override
    public int getCount() {
        return horizontalProductModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, final View convertView, final ViewGroup viewGroup) {
        View view;
        if (convertView==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent productDetailsIntent =new Intent(viewGroup.getContext(),ProductDetailsActivity.class);
                    viewGroup.getContext().startActivity(productDetailsIntent);
                }
            });
            ImageView productImage=view.findViewById(R.id.hs_product_image);
            TextView productTitle=view.findViewById(R.id.hs_product_title);
            TextView productDescription=view.findViewById(R.id.hs_product_description);
            TextView productPrice=view.findViewById(R.id.hs_product_price);

            productImage.setImageResource(horizontalProductModelList.get(i).getProductImage());
            productTitle.setText(horizontalProductModelList.get(i).getProductTitle());
            productDescription.setText(horizontalProductModelList.get(i).getProductDescription());
            productPrice.setText(horizontalProductModelList.get(i).getProductPrice());

        }else
        {
            view =convertView;
        }
        return view;
    }
}
