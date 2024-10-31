package com.example.MajorProject.Services;

import com.example.MajorProject.Entities.Student;
import com.example.MajorProject.Repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;


@Component
@Service
public class StudentServices {

    @Autowired
    StudentRepositories studentRepositories;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public void save(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setRole(Arrays.asList("Student"));
        studentRepositories.save(student);
    }

    public Optional<Student> findByUID(String UID) {
        return studentRepositories.findByUID(UID);
    }

    public Optional<Student> findByUsernameAndPassword(String UID, String password) {
        System.out.println("Finding student with UID: " + UID);
        Optional<Student> studentOPT = studentRepositories.findByUID(UID);

        if (studentOPT.isPresent()) {
            Student student = studentOPT.get();
            boolean passwordMatches = passwordEncoder.matches(password, student.getPassword());
            System.out.println("Password matches: " + passwordMatches);

            if (passwordMatches) {
                return Optional.of(student);
            }
        } else {
            System.out.println("No student found with UID: " + UID);
        }
        return Optional.empty();
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
