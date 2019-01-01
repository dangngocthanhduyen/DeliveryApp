package demo1.uit.thanhduyen.imageslider;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.List;

public class Order extends AppCompatActivity {
    private ListView lvProduct;
    private ProductListAdapter adapter;
    private List<Product> mProductList;
    public Handler mHandler;
    public View ftView;
    public ImageView person_icon;
    public ImageView menu_iv;
    public ImageView noti_iv;
    public Button submit_btn;
//    public ImageView menu_iv;

    public void onClickPersonIcon() {
        person_icon = findViewById(R.id.person_iv);
        person_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile= new Intent(Order.this, Profile.class);
                startActivity(profile);
            }
        });
    }
    public void onClickHome(){
        menu_iv= findViewById(R.id.home_iv);
        menu_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu= new Intent(Order.this, Home.class);
                startActivity(menu);
            }
        });
    }

    public void onClickNoti(){
        noti_iv= findViewById(R.id.noti_iv);
        noti_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noti= new Intent(Order.this, Noti.class);
                startActivity(noti);
            }
        });
    }

    public void onClickOrder(){
        submit_btn= findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu= new Intent(Order.this, Menu.class);
                startActivity(menu);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        onClickPersonIcon();
        onClickHome();
        onClickNoti();
        onClickOrder();
    }
}
