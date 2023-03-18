package edu.miu.badge.domains;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

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
    private TransactionType transactionType;
}

enum TransactionType {
    ALLOWED, DENIED
}
