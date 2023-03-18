package edu.miu.badge.domains;

import edu.miu.badge.enumeration.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "[transaction_id]")
    private int id;
    @Column(name = "[date]")
    private LocalDateTime date;

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
    TransactionType type;
}

