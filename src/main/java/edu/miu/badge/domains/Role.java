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
public class Role {
    @Id
    @GeneratedValue
    private int id;
    private RoleType roleType;
    @ManyToMany(mappedBy = "roles")
    private List<Member> member;
}
