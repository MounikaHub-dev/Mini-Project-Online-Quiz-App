package com.task8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

      
        questions.add(new Question("What is the Capital of France?", new String[]{"1. Berlin", "2. Paris", "3. Rome", "4. Madrid"}, 2));
        questions.add(new Question("Which programming language is platform-independent?", new String[]{"1. C", "2. Java", "3. Python", "4. Assembly"}, 2));
        questions.add(new Question("Which data structure uses FIFO?", new String[]{"1. Stack", "2. Queue", "3. Tree", "4. Graph"}, 2));

        int score = 0;

        System.out.println("********* Welcome to the Quiz App ***********");

      
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);

            for (String option : q.options) {
                System.out.println(option);
            }

            int answer = 0;
            while (true) {
                System.out.print("Enter your answer (1-4): ");
                if (sc.hasNextInt()) {
                    answer = sc.nextInt();
                    if (answer >= 1 && answer <= 4) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                    sc.next(); // clear invalid input
                }
            }

          
            if (answer == q.correctOption) {
                score++;
                System.out.println("✅ Correct!");
            } else {
                System.out.println("❌ Wrong! Correct answer was option " + q.correctOption);
            }
        }

     
        System.out.println("\n=== Quiz Over! ===");
        System.out.println("Your score: " + score + " out of " + questions.size());

        sc.close();
    }
}
