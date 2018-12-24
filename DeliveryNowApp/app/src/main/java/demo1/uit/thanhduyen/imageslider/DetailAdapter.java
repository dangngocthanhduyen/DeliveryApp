package demo1.uit.thanhduyen.imageslider;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailItemViewHolder> {
    private List<Detail> details;
    private Context context;
    public RelativeLayout product_order_lv;

    public DetailAdapter(List<Detail> details, Context c) {
        this.details = details;
        this.context = c;
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    @Override
    public DetailItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_detail_product, parent, false);

        return new DetailItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DetailItemViewHolder holder, int position) {
        Detail u = details.get(position);
        Picasso.with(context)
                .load(u.image)
                .into(holder.ivAvatar);
        holder.tvName.setText(u.name);
//        holder.tvAddress.setText(String.valueOf(u.id));
        holder.tvPrice.setText((u.price) + " .000Đ");

        holder.lnLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                Toast.makeText(context, "Clicked " + products.get(position), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, Order.class);
                context.startActivity(intent);
            }
        });
    }

    public static class DetailItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvPrice;
        public ImageView ivAvatar;
        public LinearLayout lnLayout;

        public DetailItemViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.name_tv);
            tvPrice = (TextView) itemView.findViewById(R.id.price_tv);
            ivAvatar = (ImageView) itemView.findViewById(R.id.avatar_iv);
            lnLayout = (LinearLayout) itemView.findViewById(R.id.layout_ln);
        }
    }
}