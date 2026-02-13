package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.entity.BookDetailEntity;

public interface BookDetailRepository extends JpaRepository<BookDetailEntity, Long> {
	
}
