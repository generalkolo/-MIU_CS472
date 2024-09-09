<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="cs472.miu.edu.Quiz" %>
<!DOCTYPE html>
<html>
<head>
    <title>NumberQuiz - Quiz Over</title>
</head>
<body>
    <h3>NumberQuiz - Quiz Over</h3>
    <p>Your final score is: <%= request.getAttribute("score") %></p>
    <p>Final Grade: <span style="color:red"><%= request.getAttribute("finalGrade") %></span></p>
</body>
</html>
