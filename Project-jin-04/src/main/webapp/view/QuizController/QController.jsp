<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="QuizController" method="post">
		이름: <input type="text" name="name" />
		나이: <input type="text" name="age" />
		주소: <input type="text" name="address" />
		<button type="submit">전송</button>
	</form>
</body>
</html>