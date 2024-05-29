<%@ page import="com.example.demo.domain.ControllerRepository" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ControllerRepository controller = new ControllerRepository();
		
		String name = request.getParameter("name");
		int age = request.getParameter("age");
		String address = request.getParameter("address");
		
		QController Qcon = QController.builder()
									  .name("name")
									  .age("age")
									  .address("address")
									  .build();
		
		QController newQcon = controller.QuizController(Qcon);
	%>
</body>
</html>