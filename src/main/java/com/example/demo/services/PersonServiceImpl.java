package com.example.demo.services;

import com.example.demo.commands.PersonCommand;
import com.example.demo.converters.PersonToPersonCommand;
import com.example.demo.domain.Person;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.converters.PersonCommandToPerson;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;
    private final PersonCommandToPerson personCommandToPerson;
    private final PersonToPersonCommand personToPersonCommand;

    public PersonServiceImpl(PersonRepository personRepository, PersonCommandToPerson personCommandToPerson, PersonToPersonCommand personToPersonCommand) {
        this.personRepository = personRepository;
        this.personCommandToPerson = personCommandToPerson;
        this.personToPersonCommand = personToPersonCommand;
    }

    @Override
    public Set<Person> getPeople() {

        Set<Person> personSet = new HashSet<>();
        personRepository.findAll().iterator().forEachRemaining(personSet::add);
        return personSet;
    }

    @Override
    @Transactional
    public PersonCommand savePersonCommand(PersonCommand command) {
        Person detachedPerson = personCommandToPerson.convert(command);
        Person savedPerson = personRepository.save(detachedPerson);
        return personToPersonCommand.convert(savedPerson);
    }
}
