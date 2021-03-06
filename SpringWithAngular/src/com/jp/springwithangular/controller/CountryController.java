package com.jp.springwithangular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jp.springwithangular.beans.Country;
import com.jp.springwithangular.service.ICountryService;

/**
 * 
 * @author rvikash REST Controller with different HTTP methods as
 *         GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "countries"
 *         return type is JSON
 */

@RestController
public class CountryController {
	@Autowired
	ICountryService service;
	
	/**
	 * Method fetches all country details supporting HTTP GET method
	 * 
	 * @param  MODEL
	 * @return String - List Country JSON
	 */
	@RequestMapping(value = "/countries",method = RequestMethod.GET,headers="Accept=application/json")
	public List<Country> getAllCounties(Model model) {
		
		
		return service.getAllCountries();
		
	}
	
	/**
	 * Method creates a spring form to create a country
	 * 
	 * @param id name population
	 * @return List-format JSON 
	 */
	
	@RequestMapping(value = "/countries/create/{id}/{name}/{popu}",
			headers="Accept=application/json", method = RequestMethod.POST)
	public List<Country> createCountry(@PathVariable String id,@PathVariable String name,@PathVariable String popu) {
		Country country=new Country();
		country.setCountryId(id);
		country.setCountryName(name);
		country.setPopulation(popu);
		
		
		service.addCountry(country);
	
		return service.getAllCountries();
	}
	
	/**
		 * Method creates a spring form to delete a country
		 * 
		 * @param id
		 * @return   List format Json
		 */
	
	@RequestMapping(value = "/countries/delete/{id}",
			headers="Accept=application/json",method = RequestMethod.DELETE)
	public List<Country> deleteCountry(@PathVariable int id) {
		service.deleteCountry(id);
		return service.getAllCountries();

		
	}
}
