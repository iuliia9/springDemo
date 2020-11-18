package com.example.demo.converters;

import com.example.demo.commands.PersonCommand;
import com.example.demo.domain.Person;
import org.springframework.core.convert.converter.Converter;
import com.sun.istack.Nullable;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

@Component
public class PersonCommandToPerson implements Converter<PersonCommand, Person> {


        @Synchronized
        @Nullable
        @Override
        public Person convert(PersonCommand source) {
            if (source == null) {
                return null;
            }

            final Person p = new Person();
            p.setId(source.getId());
            p.setName(source.getName());
            p.setSurname(source.getSurname());
            return p;
        }
    }

