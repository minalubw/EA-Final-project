package edu.miu.badge.dto;

import edu.miu.badge.domains.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MemberDTO {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final List<Role> roles;
}
