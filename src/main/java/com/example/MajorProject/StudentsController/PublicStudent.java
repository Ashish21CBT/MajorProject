package com.example.MajorProject.StudentsController;

import com.example.MajorProject.Entities.Student;
import com.example.MajorProject.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class PublicStudent {

    @Autowired
    private StudentServices studentServices;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        try {
            if(student.getUID() == null || student.getPassword() == null) {
                return new ResponseEntity<>("UID and Password can't be null", HttpStatus.BAD_REQUEST);
            }
            studentServices.save(student);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e){
            return new ResponseEntity<>("UID already Exist", HttpStatus.CONFLICT);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Unable to Create Student", HttpStatus.CONFLICT);
        }
    }
}

