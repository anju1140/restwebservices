package com.example.restwebservice.service;

import com.example.restwebservice.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonService {

    public List<Person> getAllPersons();

    public Person getByID(int id);

    Person createPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(int id);

}
