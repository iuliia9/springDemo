package com.example.demo.converters;
import com.example.demo.commands.PersonCommand;
import com.example.demo.domain.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonToPersonCommandTest {
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final Long LONG_VALUE = 1L;

    PersonToPersonCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new PersonToPersonCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        PersonCommand pc = converter.convert(null);
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new Person()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Person p = new Person();
        p.setId(LONG_VALUE);
        p.setName(NAME);
        p.setSurname(SURNAME);
        //when
        PersonCommand pc = converter.convert(p);

        //then
        assertEquals(LONG_VALUE, pc.getId());
        assertEquals(NAME, pc.getName());
        assertEquals(SURNAME, pc.getSurname());
    }
}
