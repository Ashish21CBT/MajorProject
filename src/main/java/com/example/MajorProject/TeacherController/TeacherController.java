package com.example.MajorProject.TeacherController;

import com.example.MajorProject.Services.TeacherServices;
import com.example.MajorProject.Services.UpdatePasswordTeacher;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Teachers-passwordUpdate")
public class TeacherController {

    @Autowired
    private UpdatePasswordTeacher updatePasswordTeacher;

    @Autowired
    private TeacherServices teacherServices;

    @Data
    public static class UpdatePasswordRequest {             //DTO  (Data Transfer Object)
        private String id;
        private String newPassword;
    }

    @PutMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        return updatePasswordTeacher.updatePassword(updatePasswordRequest.getId(), updatePasswordRequest.getNewPassword());
    }
}
