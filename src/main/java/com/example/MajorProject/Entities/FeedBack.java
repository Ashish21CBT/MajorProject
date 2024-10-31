package com.example.MajorProject.Entities;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feed_back")
@Data
public class FeedBack {

    @Id
    private String id;

    @NonNull
    private String studentId;
    @NonNull
    private String teacherId;

    @NonNull
    private String feedback;

    public FeedBack() {

    }
    public FeedBack(String teacherId, String feedback) {
        this.teacherId = teacherId;
        this.feedback = feedback;
    }

}

