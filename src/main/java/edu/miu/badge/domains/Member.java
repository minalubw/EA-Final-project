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
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @ManyToMany
    private List<Role> roles;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "[member_id]")
    private List<Badge> badges;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Membership> memberships;
}
