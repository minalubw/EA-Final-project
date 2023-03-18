package edu.miu.badge.dto;

import edu.miu.badge.domains.Roles;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private List<RolesDTO> roles;
}
