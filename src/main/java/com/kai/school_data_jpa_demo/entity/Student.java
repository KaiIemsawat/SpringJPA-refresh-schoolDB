package com.kai.school_data_jpa_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "student_tbl",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique", columnNames = "email_address"
        )
)
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;

    @Embedded // With '@Embedded', now, Student class have access to Guardian
    private Guardian guardian;
}
