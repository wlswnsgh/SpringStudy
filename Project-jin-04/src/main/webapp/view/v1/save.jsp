<%@ page import="com.example.demo.domain.MemberRepository" %>
<%@ page import="com.example.demo.domain.Member" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
    
<!-- �ڹ��ڵ带 ��� -->
<%
        MemberRepository repository = new MemberRepository();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Member member = Member.builder()
                            .userId(username).password(password)
                            .build();

        Member newMember = repository.save(member);
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%= newMember.getNo() %> ��° <%= newMember.getUserId() %> ȸ���� �߰��߽��ϴ�!
	
</body>
</html>