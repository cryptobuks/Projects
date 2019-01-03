package com.jp.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.IHrService;

@Controller
public class HrController {

	@Autowired
	@Qualifier("hrService")
	private IHrService hrService;
	
	@RequestMapping("/home")
	public String getHomePage(){
		return "Home";
	}
	
	@RequestMapping("/empDetails")
	public ModelAndView getEmpDetails() throws HrException{
		Employee emp = hrService.getEmpDetails(1);
		ModelAndView mAndV = new ModelAndView("ViewDetails");
		mAndV.addObject("emp",emp);
		return mAndV;
	}

}
