package com.example.MajorProject.Entities;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Document(collection = "Student")
@Data
public class Student {
    @NonNull
    @Id
    @Indexed(unique = true)
    private String UID;

    @NonNull
    private String username;

    @NonNull
    private String password;

    private List<String>Role;
}
