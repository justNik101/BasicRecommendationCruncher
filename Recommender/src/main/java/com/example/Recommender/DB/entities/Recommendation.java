package com.example.Recommender.DB.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "recommendation",
        uniqueConstraints = @UniqueConstraint(columnNames = {"sender_uid", "receiver_uid"})
        )
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sender_uid", nullable = false)
    private Long senderUid;
    @Column(name = "receiver_uid", nullable = false)
    private Long receiverUid;
    @Column(name = "score", nullable = false)
    private Integer score;
}
