package edu.miu.badge.dto;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.domains.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link Badge} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class BadgeDTO implements Serializable {
    private final int id;
    private final boolean isActive;
    private final Member member;

}