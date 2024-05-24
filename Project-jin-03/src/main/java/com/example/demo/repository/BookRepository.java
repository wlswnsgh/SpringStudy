package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	// 순수쿼리
	@Query(value = "select * from book where title = :title", nativeQuery = true)
	List<Book> get1(@Param("title") String title);
	
	@Query(value = "select * from book where publisher = :publisher and price >= :price", nativeQuery = true)
	List<Book> get2(@Param("publisher") String title, @Param("price") int Price);
	
	@Query(value = "select * from book where publisher = :publisher1 or publisher = :publisher2", nativeQuery = true)
	List<Book> get3(@Param("publisher1")String publisher1, @Param("publisher2")String publisher2);
	
}
