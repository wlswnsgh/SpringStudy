package com.example.demo.security.filter;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.security.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;

/*
 * 요청이 들어오면 토큰이 있는지, 토큰이 유효한지 확인하는 필터
 * */

@Log4j2
public class ApiCheckFilter extends OncePerRequestFilter {

	AntPathMatcher antPathMatcher;
	String[] patternArr;
	JWTUtil jwtUtil;
	UserDetailsService userDetailsService;
	
	
	public ApiCheckFilter(String[] patternArr, JWTUtil jwtUtil, UserDetailsService userDetailsService) {
		this.antPathMatcher = new AntPathMatcher();
		this.patternArr = patternArr;
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}
	
	// 사용자 요청이 들어왔을때, 토큰이 유효한지 확인하는 메소드
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		log.info("REQUESTURI: " + request.getRequestURI());

		for (String pattern : patternArr) {
			log.info(antPathMatcher.match(pattern, request.getRequestURI()));

			// 검사해야하는 url주소인지 확인
			if (antPathMatcher.match(pattern, request.getRequestURI())) {

				log.info("ApiCheckFilter.....");
				log.info("ApiCheckFilter.....");
				log.info("ApiCheckFilter.....");
				
				// 토큰이 유효한지 확인
				boolean checkHeader = checkAuthHeader(request);
				
				// 토큰이 유효하면 인증 객체를 생성해서 컨테이너에 담기
				if (checkHeader) {
					String username = getUserId(request);
					UserDetails userDetails = userDetailsService.loadUserByUsername(username);
					if (userDetails != null) {
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
								userDetails, null, userDetails.getAuthorities());
						authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

						SecurityContextHolder.getContext().setAuthentication(authentication);
					}

					filterChain.doFilter(request, response);
					return;
					
				} else {
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
					
					response.setContentType("application/json;charset=utf-8");
					JSONObject json = new JSONObject();
					String message = "FAIL CHECK API TOKEN";
					json.put("code", "403");
					json.put("message", message);

					PrintWriter out = response.getWriter();
					out.print(json);
					return;
				}
			}
		}

		filterChain.doFilter(request, response);
	}

	// 헤더에 담긴 토큰이 유효한지 확인하는 메소드
	private boolean checkAuthHeader(HttpServletRequest request) {

		boolean checkResult = false;
		
		// 요청 메세지에서 인증키 꺼내기
		String authHeader = request.getHeader("Authorization");
		
		// 값이 있는지 확인
		if (StringUtils.hasText(authHeader)) {
			
			try {
				String email = jwtUtil.validateAndExtract(authHeader);
				checkResult = email.length() > 0;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 인증에 성공했으면 true 반환
		return checkResult;
	}

	private String getUserId(HttpServletRequest request) {

		String authHeader = request.getHeader("Authorization");

		if (StringUtils.hasText(authHeader)) {

			try {
				String email = jwtUtil.validateAndExtract(authHeader);
				return email;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}
