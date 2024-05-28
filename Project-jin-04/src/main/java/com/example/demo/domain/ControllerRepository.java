package com.example.demo.domain;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.controller.QController;

public class ControllerRepository {

	static Map<Integer, QController> list = new HashMap<>();
	
	public QController save(QController Qcon) {
		list.put(Qcon.getAge(), Qcon);
		return Qcon;
	}

}
