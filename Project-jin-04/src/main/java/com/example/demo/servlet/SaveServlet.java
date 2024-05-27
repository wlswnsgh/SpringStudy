package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 회원 정보를 등록할 서블릿 만들기

@WebServlet(name="SaveServlet", urlPatterns = "/servlet/save")
public class SaveServlet extends HttpServlet{

	MemberRepository memberRepository = new MemberRepository();
	
	// 사용자 요청을 처리할 service() 메소드 재정의하기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 메세지에서 사용자가 전달한 파라미터 꺼내기
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 회원 추가
		Member member = new Member(0, username, password);
		memberRepository.save(member);
		
		// 응답 메세지 만들기
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter w = resp.getWriter();
		
		// 등록 결과 HTML 만들기
		w.write("<html>\n" +
		        "<head>\n" +
		        " <meta charset=\"UTF-8\">\n" +
		        "</head>\n" +
		        "<body>\n" +
		        "성공\n" +
		        "<ul>\n" +
		        " <li>회원번호="+member.getNo()+"</li>\n" +
		        " <li>이름="+member.getUserId()+"</li>\n" +
		        " <li>비밀번호="+member.getPassString()+"</li>\n" +
		        "</ul>\n" +
		        "</body>\n" +
		        "</html>");
		
	}	
	
}