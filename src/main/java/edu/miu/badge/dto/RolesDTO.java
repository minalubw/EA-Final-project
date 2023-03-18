package edu.miu.badge.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.badge.domains.Member;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesDTO {
    private int id;
    private String roleType;
    @JsonIgnore
    private List<MemberDTO> member;
}
