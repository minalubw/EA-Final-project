package edu.miu.badge.dto;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.domains.Member;
import edu.miu.badge.enumeration.BadgeStatus;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link Badge} entity
 */

@Data
@NoArgsConstructor
public class BadgeDTO implements Serializable {

    private  int id;
    private BadgeStatus badgeStatus;
    private  Member member;


}