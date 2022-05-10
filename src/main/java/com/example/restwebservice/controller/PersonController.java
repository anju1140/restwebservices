package com.example.restwebservice.controller;

import com.example.restwebservice.model.Person;
import com.example.restwebservice.service.PersonService;
import com.example.restwebservice.service.PersonServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static int id = 0;

    @Autowired
    PersonService personService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> getAllProducts(){

        return  ResponseEntity.ok().body(this.personService.getAllPersons());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id){

        return ResponseEntity.ok().body(this.personService.getByID(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        person.setId(++id);
        return ResponseEntity.ok().body(this.personService.createPerson(person));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id,@RequestBody Person person){
        person.setId(id);
        return ResponseEntity.ok().body(this.personService.updatePerson(person));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteProduct(@PathVariable int id){
        this.personService.deletePerson(id);
        return HttpStatus.OK;
    }

}
