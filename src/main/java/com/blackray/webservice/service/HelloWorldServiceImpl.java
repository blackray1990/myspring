package com.blackray.webservice.service;

import java.util.List;

import javax.jws.WebService;

import com.blackray.webservice.model.Person;

@WebService
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String sayHi(String text) {
		return "Hello, "+text;
	}

	@Override
	public String sayHiToUser(Person person) {
		
		return "Hello, "+person.getName()+"¡¾"+person.getDescription()+"¡¿";
	}

	@Override
	public String[] SayHiToUserList(List<Person> personList) {
		
		String[] persons = null;
		for (int i = 0;i<personList.size();i++) {
			persons[i] = personList.get(i).getName();
		}
		return persons;
	}

}
