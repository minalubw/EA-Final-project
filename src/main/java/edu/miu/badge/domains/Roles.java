package edu.miu.badge.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.badge.enumeration.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private List<Member> member;
}
