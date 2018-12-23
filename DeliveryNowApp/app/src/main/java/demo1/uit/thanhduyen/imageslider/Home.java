package demo1.uit.thanhduyen.imageslider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Home extends AppCompatActivity {
    ViewFlipper v_flipperHome;

    //list view
    private ListView lvProduct;
    private ProductListAdapter adapter;
    private List<Product> mProductList;
    public Handler mHandler;
    public View ftView;
    public ImageView person_icon;
    public ImageView menu_iv;
    public ImageView noti_iv;
    public RecyclerView listview;

    public void onClickPersonIcon() {
        person_icon = findViewById(R.id.person_iv);
        person_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile= new Intent(Home.this, Profile.class);
                startActivity(profile);
            }
        });
    }
    public void onClickMenu(){
        menu_iv= findViewById(R.id.menu_iv);
        menu_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu= new Intent(Home.this, Menu.class);
                startActivity(menu);
            }
        });
    }

    public void onClickNoti(){
        noti_iv= findViewById(R.id.noti_iv);
        noti_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noti= new Intent(Home.this, Noti.class);
                startActivity(noti);
            }
        });
    }



    //event click vào mỗi item store
    public void onClickStore(){
        listview = (RecyclerView)findViewById(R.id.listview);
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lv= new Intent(Home.this, DetailProduct.class);
                startActivity(lv);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Khởi tạo RecyclerView.
        final RecyclerView lvProducts = (RecyclerView) findViewById(R.id.listview);
        lvProducts.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, Product.class);
        final JsonAdapter<List<Product>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("https://eb4aaabd.ngrok.io/Web-Admin/public/api/getstorelist")
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
                final List<Product> products = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        lvProducts.setAdapter(new ProductListAdapter(products, Home.this));
                    }
                });
            }
        });

        onClickPersonIcon();
        onClickMenu();
        onClickNoti();
        onClickStore();

        //Init Slide
        int imagesHome[] = {R.drawable.banner_1, R.drawable.banner_2, R.drawable.banner_3};
        v_flipperHome = findViewById(R.id.v_flipperHome);
        //for loop
        for (int imageHome: imagesHome){
            flipperImagesHome(imageHome);
        }
        //edited (ListView)
//        lvProduct = findViewById(R.id.listview);

//        LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        ftView = li.inflate(R.layout.load_footer, null);
//        mHandler = new MyHandler();
//        mProductList = new ArrayList<>();
        //Add sample data for list
        //We can get data from DB, webservice here
//        mProductList.add(new Product(1, "The Coffee House", "444A, Cộng Hòa, Tân Bình, TP.HCM", 2));
//        mProductList.add(new Product(2, "Royal Tea", "444A, Cộng Hòa, Tân Bình, TP.HCM", 3));
//        mProductList.add(new Product(3, "Phúc Long", "444A, Cộng Hòa, Tân Bình, TP.HCM", 5.5));
//        mProductList.add(new Product(4, "Bobapop", "444A, Cộng Hòa, Tân Bình, TP.HCM", 10));
//        mProductList.add(new Product(5, "Cheese Coffee", "444A, Cộng Hòa, Tân Bình, TP.HCM", 3));

        //Init adapter
//        adapter = new ProductListAdapter(getApplicationContext(), mProductList);
//        lvProduct.setAdapter(adapter);

//        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //Do something
//                //Ex: display msg with product id get from view.getTag
//                Toast.makeText(getApplicationContext(), "Clicked product id =" + view.getTag(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        lvProduct.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//
//                //Check when scroll to last item in listview, in this tut, init data in listview = 10 item
//                if(view.getLastVisiblePosition() == totalItemCount-1 && lvProduct.getCount() >=10 && !isLoading) {
//                    isLoading = true;
//                    Thread thread = new ThreadGetMoreData();
//                    //Start thread
//                    thread.start();
//                }
//
//            }
//        });
    }

    public void flipperImagesHome (int imageHome){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(imageHome);
        v_flipperHome.addView(imageView);
        v_flipperHome.setFlipInterval(4000);
        v_flipperHome.setAutoStart(true);

        //aniamation
        v_flipperHome.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipperHome.setOutAnimation(this, android.R.anim.slide_out_right);
    }


//    public class MyHandler extends Handler {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 0:
//                    //Add loading view during search processing
//                    lvProduct.addFooterView(ftView);
//                    break;
//                case 1:
//                    //Update data adapter and UI
//                    adapter.addListItemToAdapter((ArrayList<Product>)msg.obj);
//                    //Remove loading view after update listview
//                    lvProduct.removeFooterView(ftView);
//                    isLoading=false;
//                    break;
//                default:
//                    break;
//            }
//        }
//    }

//    private ArrayList<Product> getMoreData() {
//        ArrayList<Product>lst = new ArrayList<>();
//        //Sample code get new data :P
//        lst.add(new Product(++currentId, "The Ren Tea", "444A, Cộng Hòa, Tân Bình, TP.HCM", 4));
//        lst.add(new Product(++currentId, "Lotteria", "444A, Cộng Hòa, Tân Bình, TP.HCM", 2));
//        lst.add(new Product(++currentId, "Pizzahut", "444A, Cộng Hòa, Tân Bình, TP.HCM", 6));
//        return lst;
//    }

//    public class ThreadGetMoreData extends Thread {
//        @Override
//        public void run() {
//            //Add footer view after get data
//            mHandler.sendEmptyMessage(0);
//            //Search more data
//            ArrayList<Product> lstResult = getMoreData();
//            //Delay time to show loading footer when debug, remove it when release
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //Send the result to Handle
//            Message msg = mHandler.obtainMessage(1, lstResult);
//            mHandler.sendMessage(msg);
//
//        }
//    }

}
