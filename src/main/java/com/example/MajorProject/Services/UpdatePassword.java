package com.example.MajorProject.Services;

import com.example.MajorProject.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdatePassword {

    @Autowired
    private StudentServices services;

    public ResponseEntity<?> updatePassword(String UID, String newPassword) {
        Optional<Student> studentOpt = services.findByUID(UID);

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setPassword(services.encodePassword(newPassword));
            services.save(student);
            return new ResponseEntity<>("Password Updated", HttpStatus.OK);
        }else {
            return  ResponseEntity.status(404).body("Student Not found");
        }
    }
}
