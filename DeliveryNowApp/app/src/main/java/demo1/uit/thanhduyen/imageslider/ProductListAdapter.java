package demo1.uit.thanhduyen.imageslider;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductItemViewHolder> {
    private List<Product> products;
    private Context context;

    public ProductListAdapter(List<Product> products, Context c) {
        this.products = products;
        this.context = c;
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public ProductItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new ProductItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductItemViewHolder holder, int position) {
        Product u = products.get(position);
        Picasso.with(context)
                .load(u.image)
                .into(holder.ivAvatar);
        holder.tvName.setText(u.name);
//        holder.tvAddress.setText(String.valueOf(u.id));
        holder.tvAddress.setText((u.address));
    }

    public static class ProductItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvAddress;
        public ImageView ivAvatar;

        public ProductItemViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.name_coffee_tv);
            tvAddress = (TextView) itemView.findViewById(R.id.address_tv);
            ivAvatar = (ImageView) itemView.findViewById(R.id.avatar_iv);
        }
    }
}