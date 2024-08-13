package com.example.dailysales.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailysales.databinding.SalesRvItemBinding;
import com.example.dailysales.utils.GlobalUtil;
import com.example.dailysales.view.MainActivity;
import com.example.dailysales.viewmodel.database.entities.SaleRecord;

import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.CustomItemListHolder> {
    private final MainActivity context;
    private final List<SaleRecord> list;

    public SalesAdapter(MainActivity context, List<SaleRecord> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomItemListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SalesRvItemBinding binding = SalesRvItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new CustomItemListHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomItemListHolder holder, int position) {
        final SaleRecord item = list.get(position);
        String date = item.getDay()+" "+item.getMonth()+", "+item.getYear();
        holder.itemListBinding.tvDate.setText(date);
        holder.itemListBinding.tvPrice.setText("Rs: "+ GlobalUtil.roundOff2Decimal(item.getTotalSalesAmount()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class CustomItemListHolder extends RecyclerView.ViewHolder {
        public final SalesRvItemBinding itemListBinding;

        public CustomItemListHolder(@NonNull SalesRvItemBinding itemView) {
            super(itemView.getRoot());
            this.itemListBinding = itemView;
        }
    }
}

