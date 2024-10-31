package com.example.MajorProject.FeedBackController;

import com.example.MajorProject.Entities.FeedBack;
import com.example.MajorProject.Services.FeedBackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackServices feedBackServices;

    @PostMapping("/create")
    public ResponseEntity<String> createFeedback(@RequestBody FeedBack feedback) {
        try {
            feedBackServices.saveFeedbackForTeacher(feedback.getTeacherId(), feedback.getFeedback());
            return new ResponseEntity<>("Feedback created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to create feedback: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}


