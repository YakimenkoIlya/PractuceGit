package com.yakimenko.lessonhomework3fake3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ArrayList<Product> productArrayList;
    private Context context;
    public ProductAdapter(ArrayList<Product> products, Context context) {
        this.productArrayList = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productArrayList.get(position);
        holder.name.setText("Название: " + product.getName());
        holder.type.setText("Тип: " + product.getType());
        holder.provider.setText("Поставщик: " + product.getProvider());
        holder.store.setText("Точка сбыта: " + product.getStore());
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, type, provider, store;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.productName);
            type = itemView.findViewById(R.id.type);
            provider = itemView.findViewById(R.id.provider);
            store = itemView.findViewById(R.id.store);
        }
    }
}
