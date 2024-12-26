package com.kai.school_data_jpa_demo.repository;

import com.kai.school_data_jpa_demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepo.findAll();
        System.out.println("Course : " + courses);
    }
}