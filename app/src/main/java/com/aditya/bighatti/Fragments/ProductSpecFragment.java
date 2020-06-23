package com.aditya.bighatti.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.bighatti.Activity.ProductSpecificationModel;
import com.aditya.bighatti.Adaptor.ProductSpecAdaptor;
import com.aditya.bighatti.R;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductSpecFragment extends Fragment {

    public ProductSpecFragment() {
        // Required empty public constructor
    }
    private RecyclerView productSpecificationRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product_spec, container, false);
        productSpecificationRecyclerView=view.findViewById(R.id.product_specification_RecyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productSpecificationRecyclerView.setLayoutManager(linearLayoutManager);

        List<ProductSpecificationModel> productSpecificationModelList=new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel("Protien      ","10g"));
        productSpecificationModelList.add(new ProductSpecificationModel("carbohydrates","8g"));
        productSpecificationModelList.add(new ProductSpecificationModel("Fats         ","10g"));
        productSpecificationModelList.add(new ProductSpecificationModel("Protien      ","10g"));
        productSpecificationModelList.add(new ProductSpecificationModel("carbohydrates","8g"));
        productSpecificationModelList.add(new ProductSpecificationModel("Fats         ","10g"));
        ProductSpecAdaptor productSpecAdaptor=new ProductSpecAdaptor(productSpecificationModelList);
        productSpecificationRecyclerView.setAdapter(productSpecAdaptor);
        productSpecAdaptor.notifyDataSetChanged();

        return view;
    }
}
