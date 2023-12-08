package com.yakimenko.lessonhomework3fake3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProviderAdapter extends RecyclerView.Adapter<ProviderAdapter.ViewHolder> {

    private ArrayList<Provider> providerArrayList;
    private Context context;
    public ProviderAdapter(ArrayList<Provider> providers, Context context) {
        this.providerArrayList = providers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.provider_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Provider provider = providerArrayList.get(position);
        holder.name.setText("Название: " + provider.getName());
        holder.address.setText("Адрес: " + provider.getAddress());
    }

    @Override
    public int getItemCount() {
        return providerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
        }
    }
}
