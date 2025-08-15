package com.codeleg.cereberaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {
    String category;
    int correctAnswers, totalQuestions, score;
    CardView resultCard;
    TextView congratsTextView;
    TextView scoreTextView;
    TextView resultTextView;
    AppCompatButton homeBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        calculateScore();
        setResultText();
        setColors();
        homeBtn.setOnClickListener(v -> {
            transitionActivity(new Intent(this , MainActivity.class) , true);
        });
    }
    private void init() {
        category = getIntent().getStringExtra("category");
        correctAnswers = getIntent().getIntExtra("correctAnswers", 0);
        totalQuestions = getIntent().getIntExtra("total", 0);
        resultCard = findViewById(R.id.result_card);
        congratsTextView = findViewById(R.id.congrats_text);
        scoreTextView = findViewById(R.id.score_text);
        resultTextView = findViewById(R.id.result_text);
        homeBtn = findViewById(R.id.home_btn);



    }
    private void calculateScore(){
        try {
            this.score =  (correctAnswers * 100) / totalQuestions;
        } catch (Exception e) {
            this.score = 0;
        }
        scoreTextView.setText(this.score + "% Score");

    }


    private void setResultText() {
        StringBuffer result = new StringBuffer("You attempt " + totalQuestions + " questions and from that " + correctAnswers + " is correct.");
        resultTextView.setText(result);
    }
    private void setColors() {
        if (score < 50) {
            congratsTextView.setTextColor(getResources().getColor(R.color.errorColor, getTheme()));
            resultTextView.setTextColor(getResources().getColor(R.color.errorColor, getTheme()));
            scoreTextView.setTextColor(getResources().getColor(R.color.errorColor, getTheme()));
        } else if(score < 75){
            congratsTextView.setTextColor(getResources().getColor(R.color.secondaryColor, getTheme()));
            resultTextView.setTextColor(getResources().getColor(R.color.secondaryColor, getTheme()));
            scoreTextView.setTextColor(getResources().getColor(R.color.secondaryColor, getTheme()));

        }else {
            congratsTextView.setTextColor(getResources().getColor(R.color.lightGreen, getTheme()));
            resultTextView.setTextColor(getResources().getColor(R.color.lightGreen, getTheme()));
            scoreTextView.setTextColor(getResources().getColor(R.color.lightGreen, getTheme()));
        }

    }
    private void transitionActivity(Intent activity , Boolean isFinish){

        startActivity(activity);
        overridePendingTransition(R.anim.activity_transition_anim, R.anim.activity_reverse);
        if (isFinish){
            finish();
        }

    }
}