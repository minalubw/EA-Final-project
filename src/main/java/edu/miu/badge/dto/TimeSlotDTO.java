package edu.miu.badge.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@Setter @Getter @AllArgsConstructor
@NoArgsConstructor @ToString
public class TimeSlotDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
