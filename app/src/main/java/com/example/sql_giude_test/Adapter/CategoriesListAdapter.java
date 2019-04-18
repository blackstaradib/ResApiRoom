package com.example.sql_giude_test.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sql_giude_test.R;
import com.example.sql_giude_test.db.entity.CategoryEntity;

import java.util.List;

public class CategoriesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    private List<CategoryEntity> categories;

    public CategoriesListAdapter(List<CategoryEntity> categoryEntities,Context context) {
        this.context=context;
        this.categories=categoryEntities;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_item,viewGroup,false);
        CategoryHolder categoryHolder=new CategoryHolder(itemView);
        return categoryHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder categoryHolder, int pos) {
        CategoryEntity CurrentCategory = categories.get(pos);
        ((CategoryHolder)categoryHolder).id.setText(String.valueOf(CurrentCategory.getId()));
        ((CategoryHolder)categoryHolder).Type.setText(CurrentCategory.getType());
        ((CategoryHolder)categoryHolder).Desc.setText(CurrentCategory.getDescreption());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setCategory(List<CategoryEntity> categories) {
        this.categories=categories;
    }








    public class CategoryHolder extends RecyclerView.ViewHolder{

        protected TextView id;
        protected TextView Type;
        protected TextView Desc;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.TxtId);
            Type = itemView.findViewById(R.id.TxtType);
            Desc = itemView.findViewById(R.id.TxtDesc);
        }
    }






}
