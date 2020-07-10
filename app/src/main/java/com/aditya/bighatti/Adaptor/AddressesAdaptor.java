package com.aditya.bighatti.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aditya.bighatti.Model.AddressesModel;
import com.aditya.bighatti.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.aditya.bighatti.Activity.DeliveryActivity.SELECT_ADDRESS;
import static com.aditya.bighatti.Activity.MyAddressesActivity.refreshItem;
import static com.aditya.bighatti.Fragments.MyAccountFragment.MANAGE_ADDRESS;

public class AddressesAdaptor extends RecyclerView.Adapter<AddressesAdaptor.ViewHolder> {
    private  List<AddressesModel> addressesModels;
    private int MODE;
    private int preSelectedPosition=-1;
    public AddressesAdaptor(List<AddressesModel> addressesModels,int MODE) {
        this.addressesModels = addressesModels;
        this.MODE=MODE;
    }
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
        Boolean selected=addressesModels.get(position).getSelected();
        holder.setData(name,address,pincode,selected,position);

    }

    @Override
    public int getItemCount() {
        return addressesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fullName;
        private TextView address;
        private TextView pincode;
        private ImageView icon;
        private LinearLayout optionCONT;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
            pincode=itemView.findViewById(R.id.pincode);
            icon=itemView.findViewById(R.id.icon_view);
            optionCONT=itemView.findViewById(R.id.editBTN);
        }
        private void setData(String username, String userAddress, String userPincode, Boolean selected, final int position){
            fullName.setText(username);
            address.setText(userAddress);
            pincode.setText(userPincode);

            if (MODE ==SELECT_ADDRESS){
                icon.setImageResource(R.drawable.check);
                if (selected){
                    icon.setVisibility(View.VISIBLE);
                    preSelectedPosition=position;
                }
                else{
                    icon.setVisibility(View.GONE);
                }
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (preSelectedPosition!=position){
                            addressesModels.get(position).setSelected(true);
                            addressesModels.get(preSelectedPosition).setSelected(false);
                            refreshItem(preSelectedPosition,position);
                            preSelectedPosition=position;
                        } }});

            }
            else if(MODE == MANAGE_ADDRESS){
                optionCONT.setVisibility(View.GONE);
                icon.setImageResource(R.drawable.more);
                icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        optionCONT.setVisibility(View.VISIBLE);
                        refreshItem(preSelectedPosition,preSelectedPosition);
                        preSelectedPosition=position;
                    }
                });

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        refreshItem(preSelectedPosition,preSelectedPosition);
                        preSelectedPosition=-1;
                    }
                });

            }

        }
    }
}
