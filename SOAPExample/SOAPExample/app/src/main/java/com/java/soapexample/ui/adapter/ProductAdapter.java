package com.java.soapexample.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.java.soapexample.R;
import com.java.soapexample.listener.ItemSelectedListener;
import com.java.soapexample.model.Response;

import java.util.List;

public class ProductAdapter extends RecyclerSwipeAdapter<ProductAdapter.ViewHolder> {
    private List<Response> product;
    private ItemSelectedListener itemSelectedListener;

    public ProductAdapter(List<Response> product,ItemSelectedListener itemSelectedListener){
        this.product = product;
        this.itemSelectedListener = itemSelectedListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.tvProductName.setText(product.get(position).getName());
        viewHolder.tvProductPrice.setText(String.valueOf(product.get(position).getPurchaseprice()));

        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Right, viewHolder.swipeLayout.findViewById(R.id.bottom_wrapper));
        viewHolder.tvDelete.setOnClickListener(view ->
                itemSelectedListener.onItemDeleted(product.get(position)));
        viewHolder.tvDetails.setOnClickListener(view ->
                itemSelectedListener.onItemSelected(product.get(position)));
    }

    @Override
    public int getItemCount() {
        return product.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName,tvProductPrice,tvDetails,tvDelete;
        SwipeLayout swipeLayout;
         ViewHolder(@NonNull View itemView) {
            super(itemView);
            swipeLayout = itemView.findViewById(R.id.swipe);
            tvDelete = itemView.findViewById(R.id.tvDelete);
            tvDetails = itemView.findViewById(R.id.tvDetails);
            tvProductName = itemView.findViewById(R.id.product_name);
            tvProductPrice = itemView.findViewById(R.id.product_price);
        }
    }
}
