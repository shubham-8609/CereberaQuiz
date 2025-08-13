package com.codeleg.cereberaquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    private List<Question> questionList;
    TextView catogaryHeading;
    TextView questionNoview;
    TextView questionTextView;
    CardView optionAView;
    CardView optionBView;
    CardView optionCView;
    CardView optionDView;
    TextView optionATextView;
    TextView optionBTextView;
    TextView optionCTextView;
    TextView optionDTextView;
    TextView optionAIconView;
    TextView optionBIconView;
    TextView optionCIconView;
    TextView optionDIconView;
    int currentQuestionIndex = 0;
    Boolean isChoosed = false;
    ArrayList<CardView> changedCardView = new ArrayList<>(1);
    ArrayList<TextView> changedTextView = new ArrayList<>(1);
    AppCompatButton nextBtn;

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
        // Set click listeners for option buttons
        optionAView.setOnClickListener(v -> {
            if (isChoosed) {
            } else {
                if (checkAnswer(0)) {
                    changeColor(v, optionAIconView , 0);
                    isChoosed = true;
//                    if (currentQuestionIndex < questionList.size()){
//
//                    }else{
//                        Toast.makeText(QuizActivity.this, "Quiz Completed", Toast.LENGTH_SHORT).show();
//                    }
                }else {
                    changeColor(v, optionAIconView, 1);
                    isChoosed = true;
                }
            }
        });
        optionBView.setOnClickListener(v -> {
            if (isChoosed) {
            } else {
                if (checkAnswer(1)) {
                    changeColor(v, optionBIconView , 0);
                }
                else {
                    changeColor(v, optionBIconView, 1);
                    isChoosed = true;
                }
            }
        });
        optionCView.setOnClickListener(v -> {
            if (isChoosed) {
            } else {
                if (checkAnswer(2)) {
                    changeColor(v, optionCIconView , 0);
                }
                else {
                    changeColor(v, optionCIconView, 1);
                    isChoosed = true;
                }
            }
        });
        optionDView.setOnClickListener(v -> {
            if (isChoosed) {
            } else {
                if (checkAnswer(3)) {
                        changeColor(v, optionDIconView , 0);
                }else {
                    changeColor(v, optionDIconView, 1);
                    isChoosed = true;
                }
            }
        });
        nextBtn.setOnClickListener(v -> {
            if (currentQuestionIndex < questionList.size()) {
                changedCardView.get(0).setBackgroundColor(getResources().getColor(R.color.secondaryColor, getTheme()));
                changedTextView.get(0).setTextColor(getResources().getColor(R.color.primaryColor, getTheme()));
                changedCardView.remove(0);
                changedTextView.remove(0);
                setQuestion();
                isChoosed = false;
                nextBtn.setVisibility(View.GONE);
            } else {
                Toast.makeText(QuizActivity.this, "Quiz Completed", Toast.LENGTH_SHORT).show();
            }

        });

    }
    private void init() {
        catogaryHeading = findViewById(R.id.catogary_heading);
        catogary = getIntent().getStringExtra("catogary");
        questionNoview = findViewById(R.id.question_no);
        questionTextView = findViewById(R.id.question_text);
        optionAView = findViewById(R.id.option_A);
        optionBView = findViewById(R.id.option_B);
        optionCView = findViewById(R.id.option_C);
        optionDView = findViewById(R.id.option_D);
        nextBtn = findViewById(R.id.next_btn);
        optionATextView = findViewById(R.id.optin_A_text);
        optionBTextView = findViewById(R.id.optin_B_text);
        optionCTextView = findViewById(R.id.optin_C_text);
        optionDTextView = findViewById(R.id.optin_D_text);
        optionAIconView = findViewById(R.id.option_A_icon);
        optionBIconView = findViewById(R.id.option_B_icon);
        optionCIconView = findViewById(R.id.option_C_icon);
        optionDIconView = findViewById(R.id.option_D_icon);
    }
    private void setHeading() {
        switch (catogary) {
            case "science":
                catogaryHeading.setText(R.string.science_quiz_text);
                questionList = new ArrayList<>(QuestionBank.getScienceQuestions());
                break;
            case "history":
                catogaryHeading.setText(R.string.history_quiz_text);
                questionList = new ArrayList<>(QuestionBank.getHistoryQuestions());
                break;
            case "sports":
                catogaryHeading.setText(R.string.sports_quiz_text);
                questionList = new ArrayList<>(QuestionBank.getSportsQuestions());
                break;
            default:
                break;
        }
    }
    // Method to set the question text and options based on the current question index;
    private void setQuestion() {
        questionNoview.setText("Q." + (currentQuestionIndex + 1) + "  ");
        questionTextView.setText(questionList.get(currentQuestionIndex).getQuestionText());
        optionATextView.setText(questionList.get(currentQuestionIndex).getOptions()[0]);
        optionBTextView.setText(questionList.get(currentQuestionIndex).getOptions()[1]);
        optionCTextView.setText(questionList.get(currentQuestionIndex).getOptions()[2]);
        optionDTextView.setText(questionList.get(currentQuestionIndex).getOptions()[3]);
    }
    // Method to check the selected answer and update the UI accordingly;
    private Boolean checkAnswer(int selectedOptionIndex) {
        // Implementation for checking the answer will go here
        nextBtn.setVisibility(View.VISIBLE);
        currentQuestionIndex++;
        if (selectedOptionIndex == questionList.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            Toast.makeText(this, "Correct Answer !!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Wrong Answer !!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    private void changeColor(View v, TextView icon , int color) {
        if (color == 0){
            v.setBackgroundColor(getResources().getColor(R.color.green, getTheme()));
            icon.setTextColor(getResources().getColor(R.color.green, getTheme()));
            changedCardView.add((CardView) v);
            changedTextView.add(icon);
        }else{
            v.setBackgroundColor(getResources().getColor(R.color.errorColor, getTheme()));
            icon.setTextColor(getResources().getColor(R.color.errorColor, getTheme()));
            changedCardView.add((CardView) v);
            changedTextView.add(icon);
        }

    }
}