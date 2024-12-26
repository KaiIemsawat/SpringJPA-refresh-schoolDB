package com.kai.school_data_jpa_demo.repository;

import com.kai.school_data_jpa_demo.entity.Course;
import com.kai.school_data_jpa_demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo courseRepo;

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepo.findAll();
        System.out.println("Course : " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Vernon")
                .lastName("Va")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepo.save(course);
    }
}