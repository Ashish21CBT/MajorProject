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
@RequestMapping("/Public-Teacher")
public class PublicTeacher {

    @Autowired
    private TeacherServices teacherServices;
    @PostMapping
    public ResponseEntity<?> createNewTeacher(@RequestBody Teachers teachers) {

        try{
            teacherServices.save(teachers);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")

    public ResponseEntity<?>loginTeacher(@RequestBody Teachers teachers) {
        Optional<Teachers> foundTeacher = teacherServices.findByIdAndPassword(teachers.getId(), teachers.getPassword());

        if (foundTeacher.isPresent()) {
            return new ResponseEntity<>(foundTeacher.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Invalid username or Password",HttpStatus.BAD_REQUEST);
    }
}
