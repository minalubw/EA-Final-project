package edu.miu.badge.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.badge.domains.Badge;
import edu.miu.badge.domains.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Role> roles;

    private List<Badge> badges;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
