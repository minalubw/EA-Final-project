package edu.miu.badge.domains;

import edu.miu.badge.enumeration.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @ManyToMany(mappedBy = "roles")
    private List<Member> member;
}
