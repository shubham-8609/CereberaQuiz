package com.codeleg.cereberaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {
Intent mainIntent ;
Animation slideAnim;
TextView developerTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        developerTextView = findViewById(R.id.developer_text);
        mainIntent = new Intent(SplashActivity.this, MainActivity.class);
        slideAnim = AnimationUtils.loadAnimation(this, R.anim.slide_anim);
        developerTextView.startAnimation(slideAnim);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(mainIntent);
            finish();
        }, 1500);

    }
}