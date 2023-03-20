package edu.miu.badge.dto;

import edu.miu.badge.domains.Badge;
import edu.miu.badge.domains.Membership;
import edu.miu.badge.domains.Roles;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Roles> roles;

    private List<Badge> badges;
    private List<Transaction> transactions;

    private List<Membership> memberships;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +

                '}';
    }
}
