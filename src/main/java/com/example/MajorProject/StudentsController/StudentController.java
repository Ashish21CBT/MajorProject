    package com.example.MajorProject.StudentsController;

    import com.example.MajorProject.Services.StudentServices;
    import com.example.MajorProject.Services.UpdatePassword;
    import lombok.Data;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/Students")
    public class StudentController {

        @Autowired
        private StudentServices studentServices;
        @Autowired
        private UpdatePassword updatePasswordService;

        @Data
        public static class UpdatePasswordRequest {             //DTO  (Data Transfer Object)
            private String UID;
            private String newPassword;
        }

        @PutMapping("/update-password")
        public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
            return updatePasswordService.updatePassword(updatePasswordRequest.getUID(),
                    updatePasswordRequest.getNewPassword());
        }
    }
