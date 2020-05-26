package com.spring.boot.jpa.association.oneToOne;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/association/oneToOne")
class OneToOneFKApi {
	
	@Autowired
	private LicenseRepository repository;
	
	@PostMapping("/insert")
	public List<Object[]> insert(@RequestBody InputData input) {
		Person person = new Person();
		person.setFirstName(input.getFirstName());
		person.setLastName(input.getLastName());
		person.setAge(input.getAge());
		
		Calendar now = Calendar.getInstance();
		Calendar after = Calendar.getInstance();
		after.add(Calendar.YEAR, 10);
		
		License license = new License();
		license.setType(input.getLicenseType());
		license.setValidFrom(now.getTime());
		license.setValidTo(after.getTime());
		license.setPerson(person);
		repository.save(license);
		return repository.findAllLicense();
	}
	
	@DeleteMapping("/removeLicense/{id}")
	public List<Object[]> removeLicense(@PathVariable int id) {
		repository.deleteById(id);
		return repository.findAllLicense();
	}
	
	@DeleteMapping("/removePerson/{id}")
	public List<Object[]> removePerson(@PathVariable int id) {
		repository.removePersonById(id);
		return repository.findAllLicense();
	}
}
