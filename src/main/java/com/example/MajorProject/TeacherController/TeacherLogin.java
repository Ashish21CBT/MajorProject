package com.example.MajorProject.TeacherController;

import com.example.MajorProject.Entities.Teachers;
import com.example.MajorProject.Services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("Login")
public class TeacherLogin {

    @Autowired
    private TeacherServices teacherServices;

    @PostMapping("/Teacher-login")

    public ResponseEntity<?> loginTeacher(@RequestBody Teachers teachers) {
        Optional<Teachers> foundTeacher = teacherServices.findByIdAndPassword(teachers.getId(), teachers.getPassword());

        if (foundTeacher.isPresent()) {
            return new ResponseEntity<>(foundTeacher.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Invalid username or Password",HttpStatus.BAD_REQUEST);
    }
}
