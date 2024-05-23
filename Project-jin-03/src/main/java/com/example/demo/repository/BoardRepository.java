package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.board;

public interface BoardRepository extends JpaRepository<board, Integer>{
	
	
}
