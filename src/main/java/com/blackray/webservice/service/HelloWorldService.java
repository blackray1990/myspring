package com.blackray.webservice.service;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.blackray.webservice.model.Person;

/**
 * web service服务接口
 * @author blackray
 *
 */

@WebService
public interface HelloWorldService {
	 String sayHi(@WebParam(name="text")String text);
     String sayHiToUser(Person person);
     String[] SayHiToUserList(List<Person> personList);
}
