package com.financial.serviceinterfaces;

import com.financial.entity.Person;
import com.financial.entity.page.PageModel;
import com.financial.entity.page.PageRequestModel;


public interface PersonServiceInterfaces {
	
	
	public Person save(Person person);
	
	public Person update(Long id, Person person);

	public Person getById(Long id);
	
	public PageModel<Person> listAllByOnLazyModel(PageRequestModel prm);
	
	public void delete(Long id);
	

}
