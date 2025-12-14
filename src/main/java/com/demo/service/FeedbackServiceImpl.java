package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.FeedbackRequestDTO;
import com.demo.dto.FeedbackResponseDTO;
import com.demo.entity.Feedback;
import com.demo.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public FeedbackResponseDTO createFeedback(FeedbackRequestDTO dto) {

        Feedback feedback = new Feedback();
        feedback.setName(dto.getName());
        feedback.setEmail(dto.getEmail());
        feedback.setMessage(dto.getMessage());

        Feedback saved = feedbackRepository.save(feedback);
        return mapToDTO(saved);
    }

    @Override
    public List<FeedbackResponseDTO> getFeedbacks(String email) {

        List<Feedback> feedbackList;

        if (email != null && !email.isBlank()) {
            feedbackList =
                feedbackRepository.findByEmailContainingIgnoreCaseOrderByCreatedAtDesc(email);
        } else {
            feedbackList = feedbackRepository.findAllByOrderByCreatedAtDesc();
        }

        return feedbackList.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public FeedbackResponseDTO updateFeedback(Long id, FeedbackRequestDTO dto) {

        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));

        // Update only fields
        feedback.setName(dto.getName());
        feedback.setEmail(dto.getEmail());
        feedback.setMessage(dto.getMessage());

        // DO NOT touch id or createdAt
        Feedback updated = feedbackRepository.save(feedback);

        return mapToDTO(updated);
    }

    @Override
    public void deleteFeedback(Long id) {
        if (!feedbackRepository.existsById(id)) {
            throw new RuntimeException("Feedback not found");
        }
        feedbackRepository.deleteById(id);
    }
    private FeedbackResponseDTO mapToDTO(Feedback feedback) {
        FeedbackResponseDTO dto = new FeedbackResponseDTO();
        dto.setId(feedback.getId());
        dto.setName(feedback.getName());
        dto.setEmail(feedback.getEmail());
        dto.setMessage(feedback.getMessage());
        dto.setCreatedAt(feedback.getCreatedAt());
        return dto;
    }
}

