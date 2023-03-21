package edu.miu.badge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.miu.badge.domains.Transaction;
import edu.miu.badge.enumeration.TransactionType;
import lombok.*;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link Transaction} entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTransactionDTO {
    private  int id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime date;
    private RequestMemberDTO member;
    private MembershipDTO membership;
    private LocationDTO location;
    private TransactionType type;
}
