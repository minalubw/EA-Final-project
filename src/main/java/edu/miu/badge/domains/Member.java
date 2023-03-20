package edu.miu.badge.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToMany
    @JsonManagedReference
    private List<Roles> roles;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "[member_id]")
    private List<Badge> badges;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Transaction> transactions;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Membership> memberships;



    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<Membership> memberships;


}
