package com.example.MajorProject.Repositories;
import com.example.MajorProject.Entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepositories extends MongoRepository<Student, String> {

    Optional<Student>findByUID(String UID);
}
