package com.aditya.bighatti.Adaptor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ProductImagesAdaptor extends PagerAdapter {

    private List<Integer> productImages;

    public ProductImagesAdaptor(List<Integer> productImages) {
        this.productImages = productImages;
    }

    @Override
    public int getCount() {
        return productImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view==object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView productImage=new ImageView(container.getContext());
        productImage.setImageResource(productImages.get(position));
        container.addView(productImage,0);
        return productImage;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);

    }
}
