package edu.miu.badge.dto;

import edu.miu.badge.domains.Location;
import edu.miu.badge.domains.Member;
import edu.miu.badge.domains.Membership;
import edu.miu.badge.domains.Transaction;
import edu.miu.badge.enumeration.TransactionType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Transaction} entity
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class TransactionDTO implements Serializable {
    private  int id;
    private  LocalDateTime date;
    private  Member member;
    private  Membership membership;
    private  Location location;
    private  TransactionType type;
}