package com.example.MajorProject.Services;

import com.example.MajorProject.Entities.Teachers;
import com.example.MajorProject.Repositories.TeachersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class TeacherServices {

    @Autowired
    private TeachersRepositories teachersRepositories;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void save(Teachers teachers) {
        teachers.setPassword(passwordEncoder.encode(teachers.getPassword()));
        teachers.setRole(Arrays.asList("Teacher"));
        teachersRepositories.save(teachers);
    }
    public Optional<Teachers>findByUid(String ID) {
        return teachersRepositories.findById(ID);
    }

    public Optional<Teachers> findByIdAndPassword(String Id, String password) {
        Optional<Teachers> teachersOpt = teachersRepositories.findById(Id);

        if (teachersOpt.isPresent()) {

            Teachers teachers = teachersOpt.get();
            if (passwordEncoder.matches(password,teachers.getPassword())){
                return teachersOpt;
            }
        }
        return Optional.empty();
    }

    public String passwordEncoder(String newPassword) {
        return passwordEncoder.encode(newPassword);
    }
}
