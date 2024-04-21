package com.example.Recommender.DB.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "user",
      uniqueConstraints = @UniqueConstraint(columnNames = {"email_id"})
    )
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;
    @Column(name = "company_name", nullable = false)
    private String companyName;
    @Column(name = "total_years_of_experience", nullable = false)
    private Integer totalYearsOfExperience;
    @Column(name = "skill_id", nullable = false)
    private Integer skillId;
}
