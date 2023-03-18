package edu.miu.badge.domains;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "[Badge_id]")
    int id;
    @Column(name = "[is_active]")
    boolean isActive;
    @ManyToOne
    @JoinColumn(name = "[member_id]")
    Member member;

}
