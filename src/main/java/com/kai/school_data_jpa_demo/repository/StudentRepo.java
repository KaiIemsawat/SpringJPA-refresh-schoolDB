package com.kai.school_data_jpa_demo.repository;

import com.kai.school_data_jpa_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    // Native Query
    @Query(value = "SELECT * FROM student_tbl WHERE email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailAddress);

    @Query(value = "SELECT * FROM student_tbl WHERE email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailAddress);

    @Modifying
    @Transactional // Import from 'spring framework'. // Used when modifying database
    @Query(value = "UPDATE student_tbl SET first_name = ?1 WHERE email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstname, String emailId);

}
