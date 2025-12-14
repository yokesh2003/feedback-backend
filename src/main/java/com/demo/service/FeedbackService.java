package com.demo.service;

import java.util.List;

import com.demo.dto.FeedbackRequestDTO;
import com.demo.dto.FeedbackResponseDTO;

public interface FeedbackService {

    FeedbackResponseDTO createFeedback(FeedbackRequestDTO dto);

    List<FeedbackResponseDTO> getFeedbacks(String email);
    
    FeedbackResponseDTO updateFeedback(Long id, FeedbackRequestDTO dto);

    void deleteFeedback(Long id);
}
