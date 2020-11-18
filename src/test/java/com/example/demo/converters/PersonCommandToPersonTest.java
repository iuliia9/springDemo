package com.example.demo.converters;

import com.example.demo.commands.PersonCommand;
import com.example.demo.domain.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonCommandToPersonTest {

    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final Long LONG_VALUE = 1L;

    PersonCommandToPerson converter;

    @Before
    public void setUp() throws Exception {
        converter = new PersonCommandToPerson();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new PersonCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        PersonCommand command = new PersonCommand();
        command.setId(LONG_VALUE);
        command.setName(NAME);
        command.setSurname(SURNAME);

        //when
        Person p = converter.convert(command);
        //then
        assertNotNull(p);
        assertEquals(LONG_VALUE, p.getId());
        assertEquals(NAME, p.getName());
        assertEquals(SURNAME, p.getSurname());

    }
}
