package com.codeleg.cereberaquiz;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

String catogary;
private List<Question>questionList;
TextView catogary_heading;
TextView question_no_view;
TextView question_text_view;
CardView optionAView;
CardView optionBView;
CardView optionCView;
CardView optionDView;
TextView optionA_text_view;
TextView optionB_text_view;
TextView optionC_text_view;
TextView optionD_text_view;

AppCompatButton next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        setHeading();
        setQuestion();


    }
    private void init(){
        catogary_heading = findViewById(R.id.catogary_heading);
        catogary = getIntent().getStringExtra("catogary");
        question_no_view = findViewById(R.id.question_no);
        question_text_view = findViewById(R.id.question_text);
        optionAView = findViewById(R.id.option_A);
        optionBView = findViewById(R.id.option_B);
        optionCView = findViewById(R.id.option_C);
        optionDView = findViewById(R.id.option_D);
        next_btn = findViewById(R.id.next_btn);
        optionA_text_view = findViewById(R.id.optin_A_text);
        optionB_text_view = findViewById(R.id.optin_B_text);
        optionC_text_view = findViewById(R.id.optin_C_text);
        optionD_text_view = findViewById(R.id.optin_D_text);

    }

    private void setHeading(){
        switch (catogary){
            case "science":
                catogary_heading.setText(R.string.science_quiz_text);
                questionList = new ArrayList<>(QuestionBank.getScienceQuestions());

                break;
            case "history":
                catogary_heading.setText(R.string.history_quiz_text);
                questionList = new ArrayList<>(QuestionBank.getHistoryQuestions());
                break;
            case "sports":
                catogary_heading.setText(R.string.sports_quiz_text);
                questionList = new ArrayList<>(QuestionBank.getSportsQuestions());
                break;
            default:
                break;
        }
    }

    private void setQuestion(){

    }

}