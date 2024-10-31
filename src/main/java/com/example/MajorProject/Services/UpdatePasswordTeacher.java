package com.example.MajorProject.Services;

import com.example.MajorProject.Entities.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UpdatePasswordTeacher {
    @Autowired
    private TeacherServices services;

    private String newPassword;

    public ResponseEntity<String> updatePassword(String Id, String newPassword) {
        Optional<Teachers> teacherOpt = services.findByUid(Id);

        if (teacherOpt.isPresent()) {
            Teachers teachers = teacherOpt.get();
            teachers.setPassword(services.passwordEncoder(newPassword));
            services.save(teachers);
            return new ResponseEntity<>("Password Updated", HttpStatus.OK);
        }else {
            return  ResponseEntity.status(404).body("Teacher Id Not found");
        }
    }
}
