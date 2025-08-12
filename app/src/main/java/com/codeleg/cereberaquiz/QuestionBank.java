package com.codeleg.cereberaquiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    public static List<Question> getScienceQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "What is the chemical symbol for water?",
                new String[]{"H2O", "O2", "CO2", "NaCl"},
                0
        ));
        questions.add(new Question(
                "How many planets are in our solar system?",
                new String[]{"7", "8", "9", "10"},
                1
        ));
        return questions;
    }

    public static List<Question> getHistoryQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Who was the first President of the USA?",
                new String[]{"George Washington", "Abraham Lincoln", "John Adams", "Thomas Jefferson"},
                0
        ));
        questions.add(new Question(
                "In which year did World War II end?",
                new String[]{"1942", "1945", "1950", "1939"},
                1
        ));
        return questions;
    }

    public static List<Question> getSportsQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "How many players are there in a football (soccer) team?",
                new String[]{"9", "10", "11", "12"},
                2
        ));
        questions.add(new Question(
                "Which country won the FIFA World Cup in 2018?",
                new String[]{"Brazil", "Germany", "France", "Argentina"},
                2
        ));
        return questions;
    }
}
