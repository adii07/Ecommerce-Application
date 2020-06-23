package com.aditya.bighatti.Adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aditya.bighatti.Activity.CategoryActivity;
import com.aditya.bighatti.Activity.CategoryModel;
import com.aditya.bighatti.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.MyviewHolder> {

    private List<CategoryModel> categoryModelList;

    public CategoryAdaptor(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.category_item,parent,false);
        final MyviewHolder myviewHolder=new MyviewHolder(view);

        return  myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        String icon=categoryModelList.get(position).getCategory_icon_link();
        String name=categoryModelList.get(position).getCategory_name();
        holder.setCategory(name,position);

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

       private ImageView category_icn;
       private TextView category_nme;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            category_icn=itemView.findViewById(R.id.category_icon);
            category_nme=itemView.findViewById(R.id.category_name);
        }

        private void setCategoryIcon(){
        ////todo:Set category icon
        }
        private void setCategory(final String name,final int position){
            category_nme.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position !=0){
                    Intent categoryIntent=new Intent(itemView.getContext(), CategoryActivity.class);
                    categoryIntent.putExtra("CategoryName",name);
                    itemView.getContext().startActivity(categoryIntent);}
                }
            });

        }
    }
}
