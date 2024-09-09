package cs472.miu.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NumberQuizServlet")
public class NumberQuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = Quiz.getSessionQuiz(session);

        if (quiz.isQuizOver()) {
            request.getRequestDispatcher("/quizOverPage.jsp").forward(request, response);
        } else {
            String currentQuestion = quiz.getCurrentQuestion();
            request.setAttribute("hasNextQuestion", quiz.hasNextQuestion());
            request.setAttribute("quiz", quiz);
            request.setAttribute("score", quiz.getScore());
            request.setAttribute("currQuest", currentQuestion);

            request.getRequestDispatcher("/quizPage.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = Quiz.getSessionQuiz(session);
        String currentQuestion = quiz.getCurrentQuestion();
        String ageStr = request.getParameter("txtAge"); // Get the age input

        // Initialize error as null
        Boolean error = null;

        // Initialize age as null
        Integer age = null;

        try {
            if (ageStr != null && !ageStr.isEmpty()) {
                age = Integer.parseInt(ageStr);

                // Validate age within the range of 4 to 100
                if (age < 4 || age > 100) {
                    error = true;
                    request.setAttribute("error", "Age must be between 4 and 100.");
                }
            } else {
                error = true;
                request.setAttribute("error", "Age is required.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid input by setting error to true
            error = true;
            request.setAttribute("error", "Age must be a valid integer.");
        }

        if (quiz.isQuizOver()) {
            request.getRequestDispatcher("/quizOverPage.jsp").forward(request, response);
            return;
        }

        String answerStr = request.getParameter("txtAnswer");
        int userAnswer = -1;

        if (request.getParameter("btnHint") != null) {
            // Handle hint button click
            String hint = quiz.getHint(); // Replace with your hint logic
            request.setAttribute("hint", hint);
        } else {
            try {
                userAnswer = Integer.parseInt(answerStr);
            } catch (NumberFormatException e) {
                // Handle invalid input by setting error to true
                error = true;
                request.setAttribute("error", "Please enter a numeric value");
            }

            if (userAnswer >= 0 && error == null) {
                boolean isCorrect = quiz.checkAnswer(userAnswer);

                if (isCorrect) {
                    quiz.scoreAnswer(); // Increment score and move to the next question if correct
                } else {
                    // Set error to true if the answer is incorrect
                    error = true;
                    request.setAttribute("answer", answerStr);

                    int remainingTries = quiz.getMaxTries() - quiz.getTries() ;
                    String message = "You have entered a wrong answer. Please try again, "+ remainingTries +" Remaining tries";

                    request.setAttribute("error", message);

                    // If the user has exhausted all tries, provide the correct answer
                    if (quiz.getTries() >= quiz.getMaxTries()) {
                        request.setAttribute("error", null);
                        request.setAttribute("correctAnswer", quiz.getCorrectAnswer());
                        quiz.resetTries();
                        quiz.moveToNextQuestion(); // Move to the next question
                    }
                }
            }
        }

        request.setAttribute("quiz", quiz);
        request.setAttribute("score", quiz.getScore());

        if (quiz.isQuizOver()) {
            request.setAttribute("finalGrade", quiz.calculateFinalGrade());
            request.getRequestDispatcher("/quizOverPage.jsp").forward(request, response);
        } else {
            request.setAttribute("hasNextQuestion", quiz.hasNextQuestion());
            request.setAttribute("currQuest", quiz.getCurrentQuestion());
            request.setAttribute("age", age); // Set the age attribute
            request.getRequestDispatcher("/quizPage.jsp").forward(request, response);
        }
    }
}
