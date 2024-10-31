package com.example.MajorProject.Services;
import com.example.MajorProject.Repositories.TeachersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class FindAllFeedBackByID {

    @Autowired
    private TeachersRepositories teachersRepositories;

    public void find(String Id) {
        teachersRepositories.findById(Id);
    }
}
