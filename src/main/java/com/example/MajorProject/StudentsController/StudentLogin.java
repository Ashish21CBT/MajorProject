package com.example.MajorProject.StudentsController;

import com.example.MajorProject.Entities.Login;
import com.example.MajorProject.Entities.Student;
import com.example.MajorProject.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/Login")
public class StudentLogin {
    @Autowired
    private StudentServices studentServices;

    @PostMapping("Student-login")
    public ResponseEntity<?> loginStudent(@RequestBody Login login) {
        Optional<Student> foundStudent = studentServices.findByUsernameAndPassword(login.getUID(), login.getPassword());

        if (foundStudent.isPresent()) {
            return new ResponseEntity<>(foundStudent.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Invalid Username or Password", HttpStatus.UNAUTHORIZED);
        }
    }
}
