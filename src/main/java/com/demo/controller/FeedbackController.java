package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.FeedbackRequestDTO;
import com.demo.dto.FeedbackResponseDTO;
import com.demo.service.FeedbackService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/feedback")

public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<FeedbackResponseDTO> submitFeedback(
            @Valid @RequestBody FeedbackRequestDTO dto) {

        return new ResponseEntity<>(
                feedbackService.createFeedback(dto),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<FeedbackResponseDTO>> getFeedbacks(
            @RequestParam(required = false) String email) {

        return ResponseEntity.ok(
                feedbackService.getFeedbacks(email)
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<FeedbackResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody FeedbackRequestDTO dto) {

        return ResponseEntity.ok(
                feedbackService.updateFeedback(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}

