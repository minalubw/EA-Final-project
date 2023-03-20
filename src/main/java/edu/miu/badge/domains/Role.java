package edu.miu.badge.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "[roles]")
public class Role {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

}
