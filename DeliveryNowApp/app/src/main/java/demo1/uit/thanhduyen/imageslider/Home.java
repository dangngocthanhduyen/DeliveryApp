package demo1.uit.thanhduyen.imageslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home extends AppCompatActivity {
    ViewFlipper v_flipperHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int imagesHome[] = {R.drawable.banner_1, R.drawable.banner_2, R.drawable.banner_3};
        v_flipperHome = findViewById(R.id.v_flipperHome);
        //for loop
        for (int imageHome: imagesHome){
            flipperImagesHome(imageHome);
        }
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
}
