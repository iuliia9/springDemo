package com.example.demo.services;

import com.example.demo.domain.Person;
import com.example.demo.commands.PersonCommand;
import java.util.Set;

public interface PersonService {

    Set<Person> getPeople();

    PersonCommand savePersonCommand(PersonCommand command);
}
