package com.kai.school_data_jpa_demo.repository;

import com.kai.school_data_jpa_demo.entity.Course;
import com.kai.school_data_jpa_demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {
    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void saveTeacher() {
        Course courseSpring = Course.builder()
                .title("Spring")
                .credit(6)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Hampton")
                .lastName("Va")
//                .courses(List.of(courseSpring, courseJava))
                .build();

        teacherRepo.save(teacher);
    }
}