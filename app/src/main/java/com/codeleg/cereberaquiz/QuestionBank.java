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
        questions.add(new Question(
                "What is the largest planet in our solar system?",
                new String[]{"Earth", "Mars", "Jupiter", "Saturn"},
                2
        ));
        questions.add(new Question(
                "What force keeps planets in orbit around the Sun?",
                new String[]{"Magnetism", "Gravity", "Friction", "Tension"},
                1
        ));
        questions.add(new Question(
                "What is the speed of light?",
                new String[]{"300,000 km/s", "150,000 km/s", "500,000 km/s", "1,000,000 km/s"},
                0
        ));
        questions.add(new Question(
                "What is the process by which plants make their own food?",
                new String[]{"Respiration", "Photosynthesis", "Digestion", "Transpiration"},
                1
        ));
        questions.add(new Question(
                "What is the unit of electric current?",
                new String[]{"Volt", "Watt", "Ampere", "Ohm"},
                2
        ));
        questions.add(new Question(
                "Which gas is most abundant in Earth's atmosphere?",
                new String[]{"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"},
                2
        ));
        questions.add(new Question(
                "What type of star is the Sun?",
                new String[]{"Red Giant", "White Dwarf", "Neutron Star", "Yellow Dwarf"},
                3
        ));
        questions.add(new Question(
                "What is the hardest known natural substance?",
                new String[]{"Gold", "Iron", "Diamond", "Quartz"},
                2
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
        questions.add(new Question(
                "What ancient civilization built the pyramids?",
                new String[]{"Roman", "Greek", "Egyptian", "Mesopotamian"},
                2
        ));
        questions.add(new Question(
                "Who discovered America?",
                new String[]{"Christopher Columbus", "Vasco da Gama", "Ferdinand Magellan", "James Cook"},
                0
        ));
        questions.add(new Question(
                "The Cold War was primarily between which two superpowers?",
                new String[]{"USA and China", "USA and USSR", "UK and Germany", "France and USSR"},
                1
        ));
        questions.add(new Question(
                "Who was the first emperor of Rome?",
                new String[]{"Julius Caesar", "Augustus", "Nero", "Constantine"},
                1
        ));
        questions.add(new Question(
                "The Renaissance began in which country?",
                new String[]{"France", "Spain", "Italy", "England"},
                2
        ));
        questions.add(new Question(
                "Who wrote 'Romeo and Juliet'?",
                new String[]{"Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain"},
                1
        ));
        questions.add(new Question(
                "The Magna Carta was signed in which year?",
                new String[]{"1066", "1215", "1492", "1776"},
                1
        ));
        questions.add(new Question(
                "Which ancient empire was ruled by Alexander the Great?",
                new String[]{"Roman Empire", "Persian Empire", "Macedonian Empire", "Ottoman Empire"},
                2
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
        questions.add(new Question(
                "In which sport would you perform a slam dunk?",
                new String[]{"Volleyball", "Basketball", "Tennis", "Badminton"},
                1
        ));
        questions.add(new Question(
                "How many rings are there in the Olympic symbol?",
                new String[]{"4", "5", "6", "7"},
                1
        ));
        questions.add(new Question(
                "Which country is famous for originating the sport of sumo wrestling?",
                new String[]{"China", "Korea", "Japan", "Thailand"},
                2
        ));
        questions.add(new Question(
                "In cricket, what is the term for a score of 100 runs by a single batsman?",
                new String[]{"Fifty", "Century", "Wicket", "Duck"},
                1
        ));
        questions.add(new Question(
                "Which city hosted the 2016 Summer Olympics?",
                new String[]{"London", "Tokyo", "Rio de Janeiro", "Beijing"},
                2
        ));
        questions.add(new Question(
                "What is the maximum number of clubs a golfer can carry in their bag during a round?",
                new String[]{"10", "12", "14", "16"},
                2
        ));
        questions.add(new Question(
                "Which tennis Grand Slam tournament is played on clay courts?",
                new String[]{"Wimbledon", "US Open", "Australian Open", "French Open"},
                3
        ));
        questions.add(new Question(
                "How long is a marathon race?",
                new String[]{"20 kilometers", "26.2 miles", "30 kilometers", "40.2 miles"},
                1
        ));
        return questions;
    }
}

