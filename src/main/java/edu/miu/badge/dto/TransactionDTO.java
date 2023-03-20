package edu.miu.badge.dto;

import edu.miu.badge.domains.Location;
import edu.miu.badge.domains.Member;
import edu.miu.badge.domains.Membership;
import edu.miu.badge.domains.Transaction;
import edu.miu.badge.enumeration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Transaction} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class TransactionDTO implements Serializable {
    private final int id;
    private final LocalDateTime date;
    private final Member member;
    private final Membership membership;
    private final Location location;
    private final TransactionType type;
}