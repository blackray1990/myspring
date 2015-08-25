package com.blackray.webservice.service;

import java.util.List;

import javax.jws.WebService;

import com.blackray.webservice.model.Person;

@WebService
public class HelloWorldServiceImpl implements HelloWorldService {

	public String sayHi(String text) {
		return "Hello, "+text;
	}

	public String sayHiToUser(Person person) {
		
		return "Hello, "+person.getName()+"--"+person.getDescription()+"--";
	}

	public String[] SayHiToUserList(List<Person> personList) {
		
		String[] persons = null;
		for (int i = 0;i<personList.size();i++) {
			persons[i] = personList.get(i).getName();
		}
		return persons;
	}

}
