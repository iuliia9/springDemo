package com.example.demo.bootstrap;

import com.example.demo.domain.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {
    private final PersonRepository personRepository;

    public BootStrapData(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Person paul = new Person("Paul", "Thompson");
        personRepository.save(paul);
        Person mike = new Person("Mike", "Johnston");
        personRepository.save(mike);

        System.out.println("Number of books " + personRepository.count());

    }
}
