package com.example.MajorProject.FindAllFeedBackById;

import com.example.MajorProject.Entities.FeedBack;
import com.example.MajorProject.Repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FindAllFeedBackID {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/teacher/{id}")
    public ResponseEntity<List<FeedBack>> findFeedBackByTeacherId(@PathVariable String id) {
        List<FeedBack> feedbackList = feedbackRepository.findByTeacherId(id);

        if (!feedbackList.isEmpty()) {
            return new ResponseEntity<>(feedbackList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
