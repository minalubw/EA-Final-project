package edu.miu.badge.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int id;

    @Column(name = "[badge_number]", nullable = false)
    private int badgeNumber;
    @Column(name = "[is_active]", nullable = false)
    @Enumerated(EnumType.STRING)
    private BadgeStatus badgeStatus;
    @ManyToOne
    @JoinColumn(name = "[member_id]")
    private Member member;

}
