package edu.miu.badge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BadgeMembershipSystemApplication implements CommandLineRunner {
@Autowired
private PersonService personService;
	public static void main(String[] args) {
		SpringApplication.run(BadgeMembershipSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Person person = new Person(2, "John", "jhon@gmail.com");
		personService.save(person);
		System.out.println(personService.get(2));
	}
}
