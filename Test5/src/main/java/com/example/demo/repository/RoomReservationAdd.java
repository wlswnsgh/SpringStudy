package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.RoomReservation;

@Controller
@RequestMapping("/reservation")
public class RoomReservationAdd {
	
	@Autowired
	RoomReservationRepository room;
	
	@GetMapping("/form")
	public String 리피지토리객체생성() {
		return "/reservation/form";
	}
	
	@PostMapping("/save")
	public String 데이터추가(@RequestMapping(name= "add1")int add1, 
						@RequestMapping(name= "add2")String add2, Model model) {
	
		
		RoomReservation room2 = new RoomReservation(add1,add2);
		
	}
	
}
