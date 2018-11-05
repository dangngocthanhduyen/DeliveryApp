package demo1.uit.thanhduyen.imageslider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignIn extends AppCompatActivity {
    public Button sign_up_btn;
    public Button sign_in_btn;

    public void onClickSignIn(){
        sign_up_btn= (Button)findViewById(R.id.sign_up_btn);
        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin= new Intent(SignIn.this, SignUp.class);
                startActivity(signin);
            }
        });
    }

    public void onClickSignUp(){
        sign_in_btn= (Button)findViewById(R.id.sign_in_btn);
        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home= new Intent(SignIn.this, Home.class);
                startActivity(home);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        onClickSignIn();
        onClickSignUp();
    }
}
