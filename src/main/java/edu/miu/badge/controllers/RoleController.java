package edu.miu.badge.controllers;

import edu.miu.badge.domains.Role;
import edu.miu.badge.enumeration.RoleType;
import edu.miu.badge.repositories.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
    
    @Autowired
    RoleRepository roleRepository;
    
    @GetMapping
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
    
    @PostMapping
    public List<Role> addAllRoles(){
        Role faculty = new Role(0, RoleType.FACULTY, null);
        Role admin = new Role(0, RoleType.ADMIN, null);
        Role staff = new Role(0, RoleType.STAFF, null);
        Role student = new Role(0, RoleType.STUDENT, null);
        
        roleRepository.save(faculty);
        roleRepository.save(admin);
        roleRepository.save(staff);
        roleRepository.save(student);
        return getAllRoles();
    }
    @DeleteMapping
    public String deleteAllRoles(){
        roleRepository.deleteAll();
        return "All Roles are deleted";
    }
    
    
}
