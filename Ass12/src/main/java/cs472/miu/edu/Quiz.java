package cs472.miu.edu;

import javax.servlet.http.HttpSession;

public class Quiz {
    private static String[] questions = {
            "3, 1, 4, 1, 5", // pi
            "1, 1, 2, 3, 5", // fibonacci
            "1, 4, 9, 16, 25", // squares
            "2, 3, 5, 7, 11", // primes
            "1, 2, 4, 8, 16" // powers of 2
    };

    private static int[] answers = {9, 8, 36, 13, 32};

    private int currentQuestionIndex = 0;
    private int numCorrect = 0;
    private int tries = 0;
    private int score = 0;

    private static final int MAX_TRIES = 3; // Maximum allowed tries per question

    public void setCurrentQuestionIndex(int index) {
        currentQuestionIndex = index;
    }

    public int getQuestionLength() {
        return questions.length;
    }

    public String getCurrentQuestion() {
        return questions[currentQuestionIndex];
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public boolean hasNextQuestion() {
        return currentQuestionIndex < questions.length;
    }

    public boolean checkAnswer(int userAnswer) {
        tries++;
        if (userAnswer == answers[currentQuestionIndex]) {
            if (tries == 1) {
                score += 10; // Correct on the first try
            } else if (tries == 2) {
                score += 5; // Correct on the second try
            } else if (tries == 3) {
                score += 2; // Correct on the third try
            }
            numCorrect++;
            tries = 0; // Reset the number of tries on a correct answer
            return true;
        }

        return false;
    }

    public int getNumCorrect() {
        return numCorrect;
    }

    public int getNumQuestions() {
        return questions.length;
    }

    public void scoreAnswer() {
        if (!isQuizOver()) {
            numCorrect++;
            tries = 0; // Reset the number of tries on a correct answer
            currentQuestionIndex++; // Move to the next question
        }
    }

    public boolean isCorrect(String userAnswer) {
        try {
            int answer = Integer.parseInt(userAnswer);
            return checkAnswer(answer);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isQuizOver() {
        return currentQuestionIndex >= questions.length;
    }

    public static Quiz getSessionQuiz(HttpSession session) {
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        if (quiz == null) {
            quiz = new Quiz();
            session.setAttribute("quiz", quiz);
        }
        return quiz;
    }

    public int getScore() {
        return score;
    }

    public String getHint() {
        String currentQuestion = getCurrentQuestion();
        String hint = "No hint available."; // Default hint if not found

        // Map questions to hints
        if (currentQuestion.equals("3, 1, 4, 1, 5")) {
            hint = "This sequence represents the first few digits of pi (π).";
        } else if (currentQuestion.equals("1, 1, 2, 3, 5")) {
            hint = "This sequence is known as the Fibonacci sequence.";
        } else if (currentQuestion.equals("1, 4, 9, 16, 25")) {
            hint = "These are the squares of consecutive integers.";
        } else if (currentQuestion.equals("2, 3, 5, 7, 11")) {
            hint = "All these numbers are prime numbers.";
        } else if (currentQuestion.equals("1, 2, 4, 8, 16")) {
            hint = "Each number is double the previous one.";
        }

        return hint;
    }

    public int getTries() {
        return tries;
    }

    public void incrementTries() {
        tries++;
    }

    public void resetTries() {
        tries = 0;
    }

    public int getCorrectAnswer() {
        return answers[currentQuestionIndex];
    }

    public void moveToNextQuestion() {
        if (hasNextQuestion()) {
            currentQuestionIndex++;
        }
    }

    public int getMaxTries() {
        return MAX_TRIES;
    }

    // Calculate the final grade based on the total score
    public String calculateFinalGrade() {
        if (score >= 45 && score <= 50) {
            return "A";
        } else if (score >= 35 && score <= 44) {
            return "B";
        } else if (score >= 25 && score <= 34) {
            return "C";
        } else {
            return "NC";
        }
    }
}
