package demo1.uit.thanhduyen.imageslider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Product> mProductList;

    //Constructor

    public ProductListAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    public void addListItemToAdapter(List<Product> list) {
        //Add list to current array list of data
        mProductList.addAll(list);
        //Notify UI
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.item_product, null);
        TextView tvName = (TextView)v.findViewById(R.id.name_coffee_tv);
        TextView tvAddress = (TextView)v.findViewById(R.id.address_tv);
        TextView tvDistance = (TextView)v.findViewById(R.id.distance_tv);
        //Set text for TextView
        tvName.setText(mProductList.get(position).getName());
        tvAddress.setText(mProductList.get(position).getAddress());
        tvDistance.setText("> " + String.valueOf(mProductList.get(position).getDistance()) + " km");

        //Save product id to tag
        v.setTag(mProductList.get(position).getId());

        return v;
    }
}
