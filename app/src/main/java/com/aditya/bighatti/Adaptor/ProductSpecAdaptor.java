package com.aditya.bighatti.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aditya.bighatti.Activity.ProductSpecificationModel;
import com.aditya.bighatti.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductSpecAdaptor extends RecyclerView.Adapter<ProductSpecAdaptor.ViewHolder> {

    private List<ProductSpecificationModel> productSpecificationModelList;

    public ProductSpecAdaptor(List<ProductSpecificationModel> productSpecificationModelList) {
        this.productSpecificationModelList = productSpecificationModelList;
    }

    @NonNull
    @Override
    public ProductSpecAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_specifiaction_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductSpecAdaptor.ViewHolder holder, int position) {
        String featureTitle=productSpecificationModelList.get(position).getFeatureName();
        String featureDetails=productSpecificationModelList.get(position).getFeatureValue();
        holder.setFeatures(featureTitle,featureDetails);

    }

    @Override
    public int getItemCount() {
        return productSpecificationModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featureName;
        private TextView featureValue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            featureName=itemView.findViewById(R.id.featureName);
            featureValue=itemView.findViewById(R.id.featureValue);
        }
        private void setFeatures(String featureTitle,String featureDetails){
            featureName.setText(featureTitle);
            featureValue.setText(featureDetails);
        }
    }
}
