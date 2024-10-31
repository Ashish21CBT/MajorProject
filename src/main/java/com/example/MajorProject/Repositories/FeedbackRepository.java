package com.example.MajorProject.Repositories;

import com.example.MajorProject.Entities.FeedBack;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface FeedbackRepository extends MongoRepository<FeedBack, String> {
        List<FeedBack> findByTeacherId(String teacherId);
}


