package cs472.miu.edu;

import java.util.Scanner;

public class ConsoleQuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Scanner scanner = new Scanner(System.in);

        while (quiz.hasNextQuestion()) {
            String currentQuestion = quiz.getCurrentQuestion();
            System.out.println("Current Question: " + currentQuestion);

            System.out.print("Your Answer: ");
            int guess = scanner.nextInt();

            if (quiz.checkAnswer(guess)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }

            quiz.moveToNextQuestion();
        }

        System.out.println("Quiz Completed! Your Score: " + quiz.getScore());
    }
}
