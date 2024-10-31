package com.example.MajorProject.Services;

import com.example.MajorProject.Entities.FeedBack;
import com.example.MajorProject.Entities.Teachers;
import com.example.MajorProject.Repositories.FeedbackRepository;
import com.example.MajorProject.Repositories.TeachersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedBackServices {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private TeachersRepositories teachersRepositories;

    @Transactional
    public void saveFeedbackForTeacher(String teacherId, String feedbackContent) {

        Teachers teacher = teachersRepositories.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + teacherId));

        FeedBack feedback = new FeedBack();
        feedback.setTeacherId(teacherId);
        feedback.setFeedback(feedbackContent);
        feedbackRepository.save(feedback);

        teacher.Add(feedback);

        teachersRepositories.save(teacher);
    }
}

