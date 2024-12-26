package com.kai.school_data_jpa_demo.repository;

import com.kai.school_data_jpa_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstname, String lastname);

    // JPQL
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1") // Not using '*' as in SQL. ?1 refers to first argument.
    Student getStudentByEmailAddress(String emailAddress);

    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailAddress);
}
