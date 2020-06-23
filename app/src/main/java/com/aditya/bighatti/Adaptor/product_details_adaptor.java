package com.aditya.bighatti.Adaptor;

import com.aditya.bighatti.Fragments.ProductDesFragment;
import com.aditya.bighatti.Fragments.ProductSpecFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class product_details_adaptor extends FragmentPagerAdapter {

private int totalTabs;
    public product_details_adaptor(@NonNull FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs=totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProductDesFragment productDesFragment=new ProductDesFragment();
                return productDesFragment;
            case 1:
                ProductSpecFragment productSpecFragment=new ProductSpecFragment();
                return productSpecFragment;
            case 2:
                ProductDesFragment productDesFragment1=new ProductDesFragment();
                return productDesFragment1;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
