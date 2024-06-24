package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.filter.ApiCheckFilter;
import com.example.demo.security.service.UserDetailsServiceImpl;
import com.example.demo.security.util.JWTUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// 인증서비스
	@Bean
	public UserDetailsService customUserDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	// 패스워드 암호화에 사용할 인코더
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// json 토큰 생성 클래스
	@Bean
	public JWTUtil jwtUtil() {
		return new JWTUtil();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		// 1.인증 필터 등록: /member 또는 /board 요청이 들어오면 사용자 인증 실행
		String[] arr = {"/member/*", "/board/*"};
		http.addFilterBefore(new ApiCheckFilter(arr, jwtUtil(), customUserDetailsService()), UsernamePasswordAuthenticationFilter.class);
		
		// 2권한 설정: 회원등록-아무나, 게시물-user, 회원-admin
		http
			.authorizeHttpRequests()
			.requestMatchers("/register", "/api/login").permitAll()
			.requestMatchers("/board/*").hasRole("USER")
			.requestMatchers("/member/*").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.csrf().disable() // csrf 비활성화
			// 토큰을 사용하니까 세션은 사용안함
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		return http.build();
	
	}
	
	
}
