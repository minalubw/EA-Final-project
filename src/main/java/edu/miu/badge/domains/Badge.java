package edu.miu.badge.domains;


import edu.miu.badge.enumeration.BadgeStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "[is_active]")
    @Enumerated(EnumType.STRING)
    BadgeStatus badgeStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "[member_id]")
    Member member;

}
