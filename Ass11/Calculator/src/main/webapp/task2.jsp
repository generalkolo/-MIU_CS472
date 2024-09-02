<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Calculator 2</title>
</head>
<body>
	<form method="POST" action="/labII/result/task2">
		<input type ="text" name = "add1" value="${add2Value}"/>
		<span> + </span>
		<input type ="text" name = "add2" value="${add2Value}"/>
		<span> = </span>
		<input type ="text" name = "add-result" value="${addResultValue}"/></br>
		
		
		<input type ="text" name = "multiply1" value="${multiply1Value}"/>
		<span> * </span>
		<input type ="text" name = "multiply2"value="${multiply2Value}"/>
		<span> = </span>
		<input type ="text" name = "multiply-result" value="${multiplyResultValue}"/></br>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>