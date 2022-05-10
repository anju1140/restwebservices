package com.example.restwebservice.service;

import com.example.restwebservice.exception.ResourceNotFoundException;
import com.example.restwebservice.model.Person;
import com.example.restwebservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class PersonServiceImplementation  implements  PersonService{

    @Autowired
    PersonRepository personRepository;
    @Override
    public List<Person> getAllPersons() {

        return this.personRepository.findAll();
    }

    @Override
    public Person getByID(int id) {
        Optional<Person> personDb =this.personRepository.findById(id);
        if(personDb.isPresent()){
            return  personDb.get();
        }else
        throw  new ResourceNotFoundException("Resource not found"+id);
    }

    @Override
    public Person createPerson(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {

        Optional<Person> personDb = this.personRepository.findById(person.getId());
        if (personDb.isPresent()){
            Person personUpdate = personDb.get();
           personUpdate.setId(person.getId());
           personUpdate.setName(person.getName());
           personUpdate.setAge(person.getAge());
           return personUpdate;
        }else {
            throw  new ResourceNotFoundException("Record not found :"+person.getId());
        }

    }

    @Override
    public void deletePerson(int id) {

        Optional<Person> personDb = this.personRepository.findById(id);
        if(personDb.isPresent())
            this.personRepository.delete(personDb.get());
        else{
            throw  new ResourceNotFoundException("Record not found with id "+id
            );
        }
    }
}
