package demo1.uit.thanhduyen.imageslider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Profile extends AppCompatActivity {
    public Button sign_out_btn;
    public LinearLayout user_ll;
    public ImageView home_iv;
    public ImageView menu_iv;
    public ImageView noti_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        onClickSignUp();
        onClickUser();
        onClickHome();
        onClickMenu();
        onClickNoti();
    }

    public void onClickSignUp(){
        sign_out_btn= findViewById(R.id.sign_out_btn);
        sign_out_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home= new Intent(Profile.this, SignIn.class);
                startActivity(home);
            }
        });
    }

    public void onClickUser(){
        user_ll= findViewById(R.id.user);
        user_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit= new Intent(Profile.this, EditProfile.class);
                startActivity(edit);
            }
        });
    }

    public void onClickHome(){
        home_iv= findViewById(R.id.home_iv);
        home_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit= new Intent(Profile.this, Home.class);
                startActivity(edit);
            }
        });
    }

    public void onClickMenu(){
        menu_iv= findViewById(R.id.menu_iv);
        menu_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu= new Intent(Profile.this, Menu.class);
                startActivity(menu);
            }
        });
    }

    public void onClickNoti(){
        noti_iv= findViewById(R.id.noti_iv);
        noti_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noti= new Intent(Profile.this, Noti.class);
                startActivity(noti);
            }
        });
    }
}
