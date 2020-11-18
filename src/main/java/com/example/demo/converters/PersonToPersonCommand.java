package com.example.demo.converters;

import com.example.demo.commands.PersonCommand;
import com.example.demo.domain.Person;
import org.springframework.core.convert.converter.Converter;
import com.sun.istack.Nullable;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonCommand implements Converter<Person, PersonCommand> {

        @Synchronized
        @Nullable
        @Override
        public PersonCommand convert(Person person) {
            if (person!= null) {
                final PersonCommand p = new PersonCommand();
                p.setId(person.getId());
                p.setName(person.getName());
                p.setSurname(person.getSurname());
                return p;
            }
            return null;
        }
}

