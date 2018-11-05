package demo1.uit.thanhduyen.imageslider;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    public Button get_started_btn;

    public void onClickGetStarted(){
        get_started_btn= (Button)findViewById(R.id.get_started_btn);
        get_started_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin= new Intent(MainActivity.this, SignIn.class);
                startActivity(signin);
            }
        });
    }

    ViewFlipper v_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Slide activity_main
        int images[] = {R.drawable.home, R.drawable.home1, R.drawable.home2};
        v_flipper = findViewById(R.id.v_flipper);
        //for loop
        for (int image: images){
            flipperImages(image);
        }

        onClickGetStarted();
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
