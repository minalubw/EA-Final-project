package edu.miu.badge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public void save(Person person) {
        personRepo.save(person);
    }

    public Person get(int id) {
        return personRepo.findById(id).get();
    }

}
