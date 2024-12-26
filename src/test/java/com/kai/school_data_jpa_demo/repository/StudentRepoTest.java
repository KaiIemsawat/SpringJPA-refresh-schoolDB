package com.kai.school_data_jpa_demo.repository;

import com.kai.school_data_jpa_demo.entity.Guardian;
import com.kai.school_data_jpa_demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("zukkiii@email.com")
                .firstName("Zukkii")
                .lastName("Iem")
//                .guardianName("Kai")
//                .guardianEmail("kaii@email.com")
//                .guardianMobile("777-777-7777")
                .build();
        studentRepo.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Kai")
                .email("kaii@email.com")
                .mobile("777-777-7777")
                .build();

        Student student = Student.builder()
                .firstName("Titan")
                .emailId("titanni@email.com")
                .lastName("Iem")
                .guardian(guardian)
                .build();

        studentRepo.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepo.findAll();
        System.out.println("Student List : " + students);
    }
}