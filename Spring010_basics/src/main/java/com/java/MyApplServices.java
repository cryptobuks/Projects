package com.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
 * When bean alias is not mentioned, the default is class name in camel case.
 * 
 * @Component
 * 		@Service: For declaring service beans.
 * 		@Repository: For declaring dao beans.
 * 		@Controller: For declaring controller in SpringMVC.
 * 		@RestController: For declaring REST service layer.
 */

//@Component("service")
@Service("service")
@Lazy(true)
@Scope("singleton")
public class MyApplServices {
	
	private MyApplDao dao;
	
	public MyApplServices(){
		
		//This code owns responsibility of creating an object and holding a reference
		//dao = new MyApplDao();
		System.out.println("Object of class MyApplServices() is created.");
	}
	
	// Dependency injection using Constructor
	@Autowired //Autowiring/Plumbing by type.
	public MyApplServices(MyApplDao dao){
		this.dao = dao;
		System.out.println("Object of class MyApplServices(dao) is created.");		
	}
	

}
