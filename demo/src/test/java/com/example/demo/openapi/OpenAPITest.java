package com.example.demo.openapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class OpenAPITest {
	
	String serviceKey = "SVftKHc%2FCk50KBV52Qlt%2BWR97LpsO924fg1KFqLWXk8%2B9hWNcACOmRZoGW9dU6mn%2BzoJgsVcKUPakaUtVGJg%2FA%3D%3D";
	String dataType = "JSON";
	String code = "11B20201";
	
	// 날씨 예보 API를 호출하는 테스트
	@Test
	public String getWeather() throws IOException {
	  
		  StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(dataType, "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
	        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(code, "UTF-8")); /*11A00101(백령도), 11B10101 (서울), 11B20201(인천) 등... 별첨 엑셀자료 참조(‘육상’ 구분 값 참고)*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        
	        return sb.toString();
    }
	
	@Test
	public void jsonToDto() throws IOException {
		// 매퍼 객체 생성
		ObjectMapper mapper = new ObjectMapper();
		// 분석할 수 없는 구문을 무시하는 옵션
		mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		
		String weather = getWeather();
		
		Root root = mapper.readValue(weather, Root.class);
		
		System.out.println(root.response.header.resultCode);
	}
	
}
	
