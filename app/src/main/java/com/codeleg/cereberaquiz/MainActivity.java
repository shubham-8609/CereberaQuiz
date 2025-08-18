package com.codeleg.cereberaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout scienceOption, historyOption, sportsOption;
    Intent quizPageInent;

    public static final String KEY_CATEGORY = "catogary";
    public static final String CATEGORY_SCIENCE = "science";
    public static final String CATEGORY_HISTORY = "history";
    public static final String CATEGORY_SPORTS = "sports";


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

        scienceOption.setOnClickListener(v -> {
            quizPageInent.putExtra(KEY_CATEGORY, CATEGORY_SCIENCE);
            transitionActivity(quizPageInent, false, false);

        });
        historyOption.setOnClickListener(v -> {
            quizPageInent.putExtra(KEY_CATEGORY, CATEGORY_HISTORY);
            transitionActivity(quizPageInent, false, false);
        });
        sportsOption.setOnClickListener(v -> {
            quizPageInent.putExtra(KEY_CATEGORY, CATEGORY_SPORTS);
            transitionActivity(quizPageInent, false, false);
        });


    }

    private void transitionActivity(Intent activity, Boolean isFinish, Boolean isClear) {

        startActivity(activity);
//        overridePendingTransition(R.anim.activity_transition_anim, R.anim.activity_reverse);
        if (isFinish) {
            finish();
        }
        if (isClear) {
            finishAffinity();
        }

    }
}