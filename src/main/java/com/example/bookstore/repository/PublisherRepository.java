package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.entity.PublisherEntity;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {
	
}
