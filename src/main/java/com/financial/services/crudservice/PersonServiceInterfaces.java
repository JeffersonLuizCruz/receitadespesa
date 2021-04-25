package com.financial.services.crudservice;

import com.financial.entities.Person;
import com.financial.services.pagemodel.PageModel;
import com.financial.services.pagemodel.PageRequestModel;


public interface PersonServiceInterfaces {
	
	
	public Person save(Person person);
	
	public Person update(Long id, Person person);

	public Person getById(Long id);
	
	public PageModel<Person> listAllByOnLazyModel(PageRequestModel prm);
	
	public void delete(Long id);
	

}
