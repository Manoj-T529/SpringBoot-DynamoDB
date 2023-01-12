package com.springdynamodbdemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.springdynamodbdemo.model.Person;

@Repository
public class PersonRepository {
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public Person addPerson(Person person)
	{
		dynamoDBMapper.save(person);
		return person;
	}
	
	
	public Person findPersonById(String personId)
	{
		return dynamoDBMapper.load(Person.class, personId);
	}
	
	public String delete(Person person)
	{
		dynamoDBMapper.delete(person);
		return "Deleted";
	}
	
}
