package com.codeleg.cereberaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout scienceOption , historyOption , sportsOption ;
    Animation clickAnim;
    Intent quizPageInent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        quizPageInent = new Intent(this, QuizActivity.class);
        scienceOption = findViewById(R.id.science_option);
        historyOption = findViewById(R.id.history_option);
        sportsOption = findViewById(R.id.sports_option);
        clickAnim = AnimationUtils.loadAnimation(this, R.anim.click_anim);

        scienceOption.setOnClickListener(v -> {
            quizPageInent.putExtra("catogary" , "science");
            transitionActivity(quizPageInent ,false);

        });
        historyOption.setOnClickListener(v -> {
            quizPageInent.putExtra("catogary" , "history");
            transitionActivity(quizPageInent ,false);
        });
        sportsOption.setOnClickListener(v -> {
            quizPageInent.putExtra("catogary" , "sports");
            transitionActivity(quizPageInent ,false);
        });




    }
    private void transitionActivity(Intent activity , Boolean isFinish){

        startActivity(activity);
        overridePendingTransition(R.anim.activity_transition_anim, R.anim.activity_reverse);
        if (isFinish){
            finish();
        }

    }
}