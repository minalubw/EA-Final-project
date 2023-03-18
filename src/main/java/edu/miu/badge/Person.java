package edu.miu.badge;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
@Table(name = "person")
public class Person {
    @Id
    private int id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "email")
    private String email;

    public Person() {
    }

    public Person(int id, String fname, String email) {
        this.id = id;
        this.fname = fname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "Person [id=" + id + ", name=" + fname + ", email=" + email + "]";
    }
}
