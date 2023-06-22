package com.example.assg1;

import android.content.Intent;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class animation extends AppCompatActivity {
    private Animation splash1, splash2;
    private TextView txt;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        splash1 = AnimationUtils.loadAnimation(this, R.anim.splash_screen);
        splash2 = AnimationUtils.loadAnimation(this, R.anim.splash_screen2);

        txt = findViewById(R.id.repTxt);
        img = findViewById(R.id.repImg);

        txt.setAnimation(splash1);
        img.setAnimation(splash2);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(animation.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}