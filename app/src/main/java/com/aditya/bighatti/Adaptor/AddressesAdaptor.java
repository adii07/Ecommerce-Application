package com.aditya.bighatti.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aditya.bighatti.Model.AddressesModel;
import com.aditya.bighatti.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AddressesAdaptor extends RecyclerView.Adapter<AddressesAdaptor.ViewHolder> {
    public AddressesAdaptor(List<AddressesModel> addressesModels) {
        this.addressesModels = addressesModels;
    }

    private  List<AddressesModel> addressesModels;
    @NonNull
    @Override
    public AddressesAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.addresses_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressesAdaptor.ViewHolder holder, int position) {
        String name=addressesModels.get(position).getFullName();
        String address=addressesModels.get(position).getAddress();
        String pincode=addressesModels.get(position).getPincode();
        holder.setData(name,address,pincode);

    }

    @Override
    public int getItemCount() {
        return addressesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fullName;
        private TextView address;
        private TextView pincode;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
            pincode=itemView.findViewById(R.id.pincode);
        }
        private void setData(String username, String userAddress,String userPincode){
            fullName.setText(username);
            address.setText(userAddress);
            pincode.setText(userPincode);

        }
    }
}
