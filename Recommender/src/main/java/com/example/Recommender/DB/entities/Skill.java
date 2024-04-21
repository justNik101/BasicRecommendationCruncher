package com.example.Recommender.DB.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name = "skill",
        uniqueConstraints = @UniqueConstraint(columnNames = {"skill_group"})
        )
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "skill_group", unique = true, nullable = false)
    private String skillGroup;
    @Column(name = "parent_skill_group_id", nullable = false)
    private Integer parentSkillGroupId;
}
