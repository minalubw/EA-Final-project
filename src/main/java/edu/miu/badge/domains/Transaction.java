package edu.miu.badge.domains;

import edu.miu.badge.enumeration.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "[transaction_id]")
    private int id;

    @Column(name = "[date]")
    private LocalDateTime date = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @Column(name = "[type]")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

}

