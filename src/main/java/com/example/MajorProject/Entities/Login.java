package com.example.MajorProject.Entities;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class Login {

    @NonNull
    @Id
    @Indexed(unique = true)
    private String UID;

    @NonNull
    private String password;
}
