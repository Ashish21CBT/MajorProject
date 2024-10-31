package com.example.MajorProject.Repositories;
import com.example.MajorProject.Entities.Teachers;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface TeachersRepositories extends MongoRepository<Teachers, String> {

    Optional<Teachers>findById(String id);
}
