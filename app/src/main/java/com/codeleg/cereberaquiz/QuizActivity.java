package com.codeleg.cereberaquiz;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.Build;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    String catogary;
    private List<Question> questionList;
    TextView questionNoview,questionTextView,optionATextView,optionBTextView,optionCTextView,optionDTextView,optionAIconView,optionBIconView,optionCIconView,optionDIconView;
    CardView optionAView,optionBView,optionCView,optionDView;
    int currentQuestionIndex = 0;
    Boolean isChoosed = false;
    ArrayList<CardView> changedCardView = new ArrayList<>(1);
    ArrayList<TextView> changedTextView = new ArrayList<>(1);
    AppCompatButton nextBtn;
    Intent resultIntent;
    LinearLayout mainLayout;
    int correctAnswers = 0;
    Animation introAnim , clickAnim , slideAnim , activityTransitionAnim;
    Toolbar customToolbar;

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
        setCustomToolbar();
        setHeading();
        setQuestion();
//        showAnimations();
        // Set click listeners for option buttons
        optionAView.setOnClickListener(v -> {
            if (isChoosed) {
            } else {
                v.startAnimation(clickAnim);
                if (checkAnswer(0)) {
                    changeColor(v, optionAIconView , 0);
                    isChoosed = true;
                }else {
                    changeColor(v, optionAIconView, 1);
                    isChoosed = true;
                }
            }
        });
        optionBView.setOnClickListener(v -> {
            if (isChoosed) {
            } else {
                v.startAnimation(clickAnim);
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
                v.startAnimation(clickAnim);
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
                v.startAnimation(clickAnim);
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
                showAnimations();
                nextBtn.setVisibility(View.GONE);
            } else {
                resultIntent.putExtra("catogary", catogary);
                resultIntent.putExtra("correctAnswers", correctAnswers);
                resultIntent.putExtra("total", questionList.size());
                transitionActivity(resultIntent , true);
                Toast.makeText(QuizActivity.this, "Quiz Completed", Toast.LENGTH_SHORT).show();

            }

        });

    }
    private void init() {
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
        resultIntent = new Intent(QuizActivity.this, Result.class);
        introAnim = AnimationUtils.loadAnimation(this, R.anim.intro_anim);
        clickAnim = AnimationUtils.loadAnimation(this, R.anim.click_anim);
        slideAnim = AnimationUtils.loadAnimation(this, R.anim.slide_anim);
        customToolbar = findViewById(R.id.quiz_toolbar);
        activityTransitionAnim = AnimationUtils.loadAnimation(this , R.anim.activity_transition_anim);
        mainLayout = findViewById(R.id.main_layout);
    }
    private void setHeading() {

        switch (catogary) {
            case "science":
                questionList = new ArrayList<>(QuestionBank.getScienceQuestions());
                break;
            case "history":
                questionList = new ArrayList<>(QuestionBank.getHistoryQuestions());
                break;
            case "sports":
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
        nextBtn.startAnimation(introAnim);
        if (selectedOptionIndex == questionList.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            currentQuestionIndex++;
            correctAnswers++;
            return true;
        } else {
            currentQuestionIndex++;
            vibrate(100);
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

    private void showAnimations(){

        mainLayout.startAnimation(slideAnim);

    }
    private void vibrate(int time){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            vibrator.vibrate(time); // Vibrate for 100 milliseconds
        }
    }

    public void setCustomToolbar(){
        setSupportActionBar(customToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setTitle(catogary);
        customToolbar.setSubtitle("CereberaQuiz");



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu, menu);
        return true;
        // return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.see_result_option){
            resultIntent.putExtra("catogary", catogary);
            resultIntent.putExtra("correctAnswers", correctAnswers);

                resultIntent.putExtra("total", currentQuestionIndex);

            transitionActivity(resultIntent , true);// implement confirming
        } else if (item.getItemId() == R.id.exit_quiz_option) {
            transitionActivity(new Intent(this , MainActivity.class) , true);
        }else {
            transitionActivity(new Intent(this , MainActivity.class) , true);
        }
        return super.onOptionsItemSelected(item);
    }

    private void transitionActivity(Intent activity , Boolean isFinish){

        startActivity(activity);
        overridePendingTransition(R.anim.activity_transition_anim, R.anim.activity_reverse);
        if (isFinish){
            finish();
        }

    }

}
