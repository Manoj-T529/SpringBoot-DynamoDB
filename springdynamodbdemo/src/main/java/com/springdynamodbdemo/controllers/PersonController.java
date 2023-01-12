package com.springdynamodbdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdynamodbdemo.model.Person;
import com.springdynamodbdemo.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@PostMapping("/save")
	public Person savePerson(@RequestBody Person person)
	{
		return personRepository.addPerson(person);
	}
	
	@GetMapping("/get/{id}")
	public Person getPerson(@PathVariable("id") String personId)
	{
		return personRepository.findPersonById(personId);
	}
	
	@DeleteMapping("/delete")
	public String deletePerson(@RequestBody Person person)
	{
		return personRepository.delete(person);
	}

}
