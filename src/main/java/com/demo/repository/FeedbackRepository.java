package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
	 List<Feedback> findByEmailContainingIgnoreCaseOrderByCreatedAtDesc(String email);

	 List<Feedback> findAllByOrderByCreatedAtDesc();
}
