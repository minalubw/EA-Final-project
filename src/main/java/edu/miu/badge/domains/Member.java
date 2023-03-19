package edu.miu.badge.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> roles;
    @OneToMany(mappedBy = "member" , cascade = CascadeType.ALL)
    @JoinTable(name = "member_badges")
    private List<Badge> badges;


}
