package demo1.uit.thanhduyen.imageslider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {
    public ImageView home_iv;
    public ImageView menu_iv;
    public ImageView noti_iv;
    public ImageView person_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        onClickHome();
        onClickNoti();
        onClickPersonIcon();
    }
    public void onClickHome(){
        home_iv= findViewById(R.id.home_iv);
        home_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit= new Intent(Menu.this, Home.class);
                startActivity(edit);
            }
        });
    }

    public void onClickNoti(){
        noti_iv= findViewById(R.id.noti_iv);
        noti_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noti= new Intent(Menu.this, Noti.class);
                startActivity(noti);
            }
        });
    }

    public void onClickPersonIcon() {
        person_icon = findViewById(R.id.person_iv);
        person_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile= new Intent(Menu.this, Profile.class);
                startActivity(profile);
            }
        });
    }
}
