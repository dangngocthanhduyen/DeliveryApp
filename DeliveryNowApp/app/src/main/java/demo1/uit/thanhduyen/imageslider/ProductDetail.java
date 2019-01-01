package demo1.uit.thanhduyen.imageslider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProductDetail extends AppCompatActivity {

    public RelativeLayout product_order_lv;

    public void onClickItemStore(){
        product_order_lv = (RelativeLayout)findViewById(R.id.product_order_lv);
        product_order_lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent product_order_lv= new Intent(ProductDetail.this, Order.class);
                startActivity(product_order_lv);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Khởi tạo RecyclerView.
        final RecyclerView lvDetails = (RecyclerView) findViewById(R.id.detail_lv);
        lvDetails.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, Detail.class);
        final JsonAdapter<List<Detail>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("https://1285d86b.ngrok.io/Web-Admin/public/api/getproductlist")
                .build();

        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String json = response.body().string();
                final List<Detail> details = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        lvDetails.setAdapter(new DetailAdapter(details, ProductDetail.this));
                    }
                });
            }
        });

        onClickItemStore();
    }
}
