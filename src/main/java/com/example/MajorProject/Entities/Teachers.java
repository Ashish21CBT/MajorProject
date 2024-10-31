package com.example.MajorProject.Entities;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "teachers")
@Data
public class Teachers {
    @Id
    @Indexed(unique = true)
    private String id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private List<String>Role;

    @DBRef
    private List<FeedBack> feedBacks = new ArrayList<>();

    public Teachers(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }
    public void Add(FeedBack feedback) { // Accept a FeedBack object
        this.feedBacks.add(feedback);
    }
}

