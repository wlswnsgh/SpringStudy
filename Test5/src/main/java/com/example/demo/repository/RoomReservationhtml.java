package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.RoomReservation;

@Controller
public class RoomReservationhtml {
	
	@Autowired
	RoomReservationRepository roomReservationRepository;
	
	
	public void 리피지토리객체생성() {
		System.out.println("roomReservationRepository = " + roomReservationRepository);
	}
	
	
	@GetMapping("/reservation/list")
	public void 주문데이터생성(Model model) {
		List<RoomReservation> list = new ArrayList<>();
		
		LocalDate date1 = LocalDate.of(2023, 06, 01);
		LocalDate date2 = LocalDate.of(2023, 06, 02);
		LocalDate date3 = LocalDate.of(2023, 06, 02);
		
		RoomReservation room1 = new RoomReservation(1, 201, "둘리", date1);
		RoomReservation room2 = new RoomReservation(2, 201, "둘리", date2);
		RoomReservation room3 = new RoomReservation(3, 202, "또치", date3);
		
		list.add(room1);
		list.add(room2);
		list.add(room3);
		
		roomReservationRepository.saveAll(list);
		
		model.addAttribute("list", roomReservationRepository.saveAll(list));
	
	}
	
}
