<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cs472.miu.edu.Quiz" %>
<!DOCTYPE html>
<html>
<head>
    <title>NumberQuiz</title>
</head>
<body>
    <form method='post'>
        <h3>Have fun with NumberQuiz!</h3>
        <p>Your current score is: <%= request.getAttribute("score") %></p>

        <!-- Input field for age -->
        <p>Enter your age:</p>
        <p><input type='text' name='txtAge' value='<%= (request.getAttribute("age") != null ? request.getAttribute("age") : "") %>' /></p>

        <p>Guess the next number in the sequence</p>
        <% Quiz quiz = (Quiz) request.getAttribute("quiz"); %>
        <p><%= (quiz != null) ? quiz.getCurrentQuestion() : "Question not available" %></p>

        <p>Your answer:<input type='text' name='txtAnswer' value='<%= (request.getAttribute("answer") != null ? request.getAttribute("answer") : "") %>' /></p>

        <% if (request.getAttribute("error") != null) { %>
            <!-- Display error message -->
            <p style='color:red'><%= request.getAttribute("error") %></p>
        <% } %>

        <% if (request.getAttribute("correctAnswer") != null) { %>
            <!-- Display the correct answer when the user has exhausted all tries -->
            <p>The correct answer was: <%= request.getAttribute("correctAnswer") %></p>
        <% } %>

        <% if (request.getAttribute("hint") != null) { %>
            <p>Hint: <%= request.getAttribute("hint") %></p>
        <% } %>

        <p><input type='submit' name='btnNext' value='Next' /></p>
        <p><input type='submit' name='btnHint' value='Hint' /></p>

        <% if (!(Boolean) request.getAttribute("hasNextQuestion")) { %>
            <!-- Display final grade when the quiz is over -->
            <p style='color:red'>Quiz is over. Final Grade: <%= request.getAttribute("finalGrade") %></p>
        <% } %>
    </form>
</body>
</html>
